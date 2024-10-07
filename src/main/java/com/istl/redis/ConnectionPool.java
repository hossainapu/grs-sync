/*     */ package com.istl.redis;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class ConnectionPool
/*     */   implements Runnable
/*     */ {
/*     */   private String driver;
/*     */   private String url;
/*     */   private String username;
/*     */   private String password;
/*     */   private int maxConnections;
/*     */   private boolean waitIfBusy;
/*     */   public Vector<Connection> availableConnections;
/*     */   public Vector<Connection> busyConnections;
/*     */   private boolean connectionPending = false;
/*     */   
/*     */   public ConnectionPool() {}
/*     */   
/*     */   public ConnectionPool(String driver, String url, String username, String password, int initialConnections, int maxConnections, boolean waitIfBusy) throws SQLException {
/*  24 */     this.driver = driver;
/*  25 */     this.url = url;
/*  26 */     this.username = username;
/*  27 */     this.password = password;
/*  28 */     this.maxConnections = maxConnections;
/*  29 */     this.waitIfBusy = waitIfBusy;
/*  30 */     if (initialConnections > maxConnections) {
/*  31 */       initialConnections = maxConnections;
/*     */     }
/*  33 */     this.availableConnections = new Vector<>(initialConnections);
/*  34 */     this.busyConnections = new Vector<>();
/*  35 */     for (int i = 0; i < initialConnections; i++) {
/*  36 */       this.availableConnections.addElement(makeNewConnection());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Connection getConnection() throws SQLException {
/*  45 */     if (!this.availableConnections.isEmpty()) {
/*     */       
/*  47 */       Connection existingConnection = this.availableConnections.lastElement();
/*  48 */       int lastIndex = this.availableConnections.size() - 1;
/*  49 */       this.availableConnections.removeElementAt(lastIndex);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  55 */       if (existingConnection.isClosed()) {
/*  56 */         notifyAll();
/*  57 */         return getConnection();
/*     */       } 
/*  59 */       this.busyConnections.addElement(existingConnection);
/*  60 */       return existingConnection;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     if (totalConnections() < this.maxConnections && !this.connectionPending) {
/*  77 */       makeBackgroundConnection();
/*  78 */     } else if (!this.waitIfBusy) {
/*  79 */       throw new SQLException("Connection limit reached");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  85 */       wait();
/*  86 */     } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */     
/*  89 */     return getConnection();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void makeBackgroundConnection() {
/* 103 */     this.connectionPending = true;
/*     */     try {
/* 105 */       Thread connectThread = new Thread(this);
/* 106 */       connectThread.start();
/* 107 */     } catch (OutOfMemoryError outOfMemoryError) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 114 */       Connection connection = makeNewConnection();
/* 115 */       synchronized (this) {
/* 116 */         this.availableConnections.addElement(connection);
/* 117 */         this.connectionPending = false;
/* 118 */         notifyAll();
/*     */       } 
/* 120 */     } catch (Exception e) {
/*     */ 
/*     */       
/* 123 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Connection makeNewConnection() throws SQLException {
/*     */     try {
/* 136 */       Class.forName(this.driver);
/*     */       
/* 138 */       Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
/*     */ 
/*     */ 
/*     */       
/* 142 */       return connection;
/* 143 */     } catch (Exception cnfe) {
/*     */ 
/*     */       
/* 146 */       cnfe.printStackTrace();
/* 147 */       throw new SQLException("ConnectionPool:: SQLException encountered:: " + cnfe
/*     */           
/* 149 */           .getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void free(Connection connection) {
/* 159 */     if (connection != null) {
/* 160 */       this.busyConnections.removeElement(connection);
/* 161 */       this.availableConnections.addElement(connection);
/*     */       
/* 163 */       notifyAll();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized int totalConnections() {
/* 168 */     return this.availableConnections.size() + this.busyConnections.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void closeAllConnections() {
/* 181 */     closeConnections(this.availableConnections);
/* 182 */     this.availableConnections = new Vector<>();
/* 183 */     closeConnections(this.busyConnections);
/* 184 */     this.busyConnections = new Vector<>();
/*     */   }
/*     */   
/*     */   private void closeConnections(Vector<Connection> connections) {
/*     */     try {
/* 189 */       for (int i = 0; i < connections.size(); i++) {
/* 190 */         Connection connection = connections.elementAt(i);
/* 191 */         if (!connection.isClosed()) {
/* 192 */           connection.close();
/*     */         }
/*     */       } 
/* 195 */     } catch (SQLException sqle) {
/* 196 */       sqle.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized String toString() {
/* 207 */     String info = "ConnectionPool(" + this.url + "," + this.username + "), available=" + this.availableConnections.size() + ", busy=" + this.busyConnections.size() + ", max=" + this.maxConnections;
/* 208 */     return info;
/*     */   }
/*     */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\redis\ConnectionPool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */