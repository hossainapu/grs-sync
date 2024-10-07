/*    */ package com.istl.utils;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import java.security.KeyManagementException;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import javax.net.ssl.HostnameVerifier;
/*    */ import javax.net.ssl.HttpsURLConnection;
/*    */ import javax.net.ssl.SSLContext;
/*    */ import javax.net.ssl.TrustManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DisableSSLCertificateCheckUtil
/*    */ {
/*    */   public static void disableChecks() throws NoSuchAlgorithmException, KeyManagementException {
/*    */     try {
/* 18 */       (new URL("https://0.0.0.0/")).getContent();
/* 19 */     } catch (IOException iOException) {}
/*    */ 
/*    */     
/*    */     try {
/* 23 */       SSLContext sslc = SSLContext.getInstance("TLS");
/* 24 */       TrustManager[] trustManagerArray = { (TrustManager) new  Exception() };
/* 25 */       sslc.init(null, trustManagerArray, null);
/* 26 */       HttpsURLConnection.setDefaultSSLSocketFactory(sslc.getSocketFactory());
/* 27 */       HttpsURLConnection.setDefaultHostnameVerifier((HostnameVerifier)new Exception());
/* 28 */     } catch (Exception var2) {
/* 29 */       var2.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\ist\\utils\DisableSSLCertificateCheckUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */