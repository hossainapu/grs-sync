/*     */ package com.istl.business.manager;
/*     */ import com.istl.business.manager.MigrationService;
/*     */ import com.istl.business.request.LoginRequest;
/*     */ import com.istl.business.response.LoginResponse;
/*     */ import com.istl.config.RestTemplateHeaderModifierInterceptor;
/*     */ import com.istl.utils.DisableSSLCertificateCheckUtil;
import com.istl.utils.Utility;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.servlet.ServletException;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.http.HttpEntity;
/*     */ import org.springframework.http.client.ClientHttpRequestInterceptor;
/*     */ import org.springframework.scheduling.annotation.Scheduled;
/*     */ import org.springframework.stereotype.Component;
/*     */ import org.springframework.util.CollectionUtils;
/*     */ import org.springframework.web.client.RestTemplate;
/*     */ 
/*     */ @Component
/*     */ public class MigrationManager {
/*  25 */   private static final Logger log = LoggerFactory.getLogger(com.istl.business.manager.MigrationManager.class);
/*     */   
/*     */   @Autowired
/*     */   MigrationService migrationService;
/*     */   
/*     */   @Value("${nothi.baseUrl}")
/*     */   private String baseUrl;
/*     */   
/*     */   @Value("${nothi.clientId}")
/*     */   private String clientId;
/*     */   
/*     */   @Value("${nothi.username}")
/*     */   private String username;
/*     */   
/*     */   @Value("${nothi.password}")
/*     */   private String password;
/*     */   
/*     */   @Value("${nothi.uri.login}")
/*     */   private String loginUri;
/*     */   
/*     */   @Value("${cron.schedule.token}")
/*     */   private String tokenscheduler;
/*     */   @Value("${cron.schedule.sync}")
/*     */   private String syncScheduler;
/*     */   private RestTemplate restTemplate;
/*     */   
/*     */   @PostConstruct
/*     */   public void init() throws ServletException {
/*  53 */     this.restTemplate = new RestTemplate();
/*  54 */     List<ClientHttpRequestInterceptor> interceptors = this.restTemplate.getInterceptors();
/*  55 */     if (CollectionUtils.isEmpty(interceptors)) {
/*  56 */       interceptors = new ArrayList<>();
/*     */     }
/*  58 */     interceptors.add(new RestTemplateHeaderModifierInterceptor());
/*  59 */     this.restTemplate.setInterceptors(interceptors);
/*     */     
/*     */     try {
/*  62 */       Utility.expirationTime = Long.valueOf((new Date()).getTime());
/*  63 */       DisableSSLCertificateCheckUtil.disableChecks();
/*  64 */     } catch (Exception e) {
/*  65 */       Utility.authToken = "";
/*  66 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   @Scheduled(cron = "${cron.schedule.token}")
/*     */   public void cronJobSch() {
/*  72 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
/*  73 */     Date now = new Date();
/*  74 */     String strDate = sdf.format(now);
/*  75 */     System.out.println("Java cron job expression:: " + strDate);
/*     */     
/*  77 */     HttpEntity<LoginRequest> httpRequest = new HttpEntity(new LoginRequest(this.clientId, this.username, this.password));
/*     */     
/*     */     try {
/*  80 */       LoginResponse resultObject = (LoginResponse)this.restTemplate.postForObject(this.baseUrl + this.loginUri, httpRequest, LoginResponse.class, new Object[0]);
/*  81 */       if (!resultObject.getStatus().equalsIgnoreCase("success")) {
/*  82 */         throw new Exception(resultObject.getMessage());
/*     */       }
/*  84 */       Utility.authToken = resultObject.getData().getToken();
/*  85 */       Utility.expirationTime = Long.valueOf((new Date()).getTime() + 60000L);
/*  86 */     } catch (Exception e) {
/*  87 */       log.error("===INTERNAL API COMMUNICATION FAILED:", e);
/*     */     } 
/*     */     
/*  90 */     log.info("==FINAL==");
/*     */   }
/*     */   public void redisSync() {
/*  93 */     log.info("== redisUpdateOnStartUp START ==");
/*  94 */     this.migrationService.redisUpdateOnStartUp();
/*  95 */     log.info("== redisUpdateOnStartUp END ==");
/*     */   }
/*     */ 
/*     */   
/*     */   @Scheduled(cron = "${cron.schedule.sync}")
/*     */   public void migratorCronJobSch() {
/* 101 */     log.info("== Migration START ==");
/* 102 */     cronJobSch();
/* 103 */     this.migrationService.migrateAll();
/* 104 */     log.info("== Migration END ==");
/*     */   }
/*     */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\manager\MigrationManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */