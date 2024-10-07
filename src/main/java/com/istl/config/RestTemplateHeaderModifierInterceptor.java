/*    */ package com.istl.config;
/*    */ 
/*    */ import com.istl.utils.Utility;
/*    */ import java.io.IOException;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.http.HttpRequest;
/*    */ import org.springframework.http.MediaType;
/*    */ import org.springframework.http.client.ClientHttpRequestExecution;
/*    */ import org.springframework.http.client.ClientHttpRequestInterceptor;
/*    */ import org.springframework.http.client.ClientHttpResponse;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {
/* 16 */   private static final Logger log = LoggerFactory.getLogger(com.istl.config.RestTemplateHeaderModifierInterceptor.class);
/*    */ 
/*    */   
/* 19 */   private static final Logger LOGGER = LoggerFactory.getLogger(com.istl.config.RestTemplateHeaderModifierInterceptor.class);
/*    */ 
/*    */   
/*    */   public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
/* 23 */     if (request.getHeaders().get("Content-Type") == null) {
/* 24 */       request.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
/*    */     }
/* 26 */     if (request.getHeaders().get("Accept") == null) {
/* 27 */       request.getHeaders().add("Accept", "application/json");
/*    */     }
/* 29 */     if (Utility.authToken != null) {
/* 30 */       request.getHeaders().add("Authorization", "Bearer " + Utility.authToken);
/*    */     }
/* 32 */     request.getHeaders().add("api-version", "1");
/*    */     
/* 34 */     ClientHttpResponse response = execution.execute(request, body);
/* 35 */     response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
/* 36 */     return response;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\config\RestTemplateHeaderModifierInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */