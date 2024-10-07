/*    */ package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

/*    */
/*    */
@Builder
/*    */ public class LoginRequest implements Serializable {
/*    */   private String client_id;
/*    */   private String username;
/*    */   private String password;
/*    */   
/*  9 */   public void setClient_id(String client_id) { this.client_id = client_id; } public void setUsername(String username) { this.username = username; } public void setPassword(String password) { this.password = password; } public LoginRequest(String client_id, String username, String password) {
/* 10 */     this.client_id = client_id; this.username = username; this.password = password;
/*    */   }
/*    */   
/* 13 */   public String getClient_id() { return this.client_id; }
/* 14 */   public String getUsername() { return this.username; } public String getPassword() {
/* 15 */     return this.password;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\LoginRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */