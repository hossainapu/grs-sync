/*     */ package com.istl.business.manager;
/*     */ import com.google.gson.Gson;
import com.istl.business.entity.CustomOfficeLayer;
/*     */ import com.istl.business.entity.Office;
import com.istl.business.request.CustomOfficeLayerRequest;
/*     */ import com.istl.business.request.v2.OfficeUnitDesignationMapRequest;
/*     */ import com.istl.business.response.CustomOfficeLayerResponse;
/*     */ import com.istl.business.response.v2.OfficeUnitDesignationMapResponse;
/*     */ import com.istl.config.RestTemplateHeaderModifierInterceptor;
import com.istl.utils.DisableSSLCertificateCheckUtil;
/*     */ import com.istl.utils.Utility;
/*     */ import java.util.*;
/*     */
/*     */
/*     */
/*     */ import java.util.stream.Collectors;
/*     */ import javax.annotation.PostConstruct;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.http.HttpEntity;
/*     */ import org.springframework.http.HttpMethod;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.http.client.ClientHttpRequestInterceptor;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/*     */
/*     */ @Service
/*     */ public class DoptorConnectorServiceNew {
/*  28 */   private static final Logger log = LoggerFactory.getLogger(com.istl.business.manager.DoptorConnectorServiceNew.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */ Gson gson;
/*     */ 
/*     */   
/*     */   private RestTemplate restTemplate;
/*     */   
/*     */   @Value("${nothi.baseUrlv1}")
/*     */   private String baseUrl;
/*     */ 
/*     */   
/*     */   @PostConstruct
/*     */   public void init() {
/*  43 */     this.restTemplate = new RestTemplate();
/*  44 */     List<ClientHttpRequestInterceptor> interceptors = this.restTemplate.getInterceptors();
/*  45 */     if (CollectionUtils.isEmpty(interceptors)) {
/*  46 */       interceptors = new ArrayList<>();
/*     */     }
/*  48 */     interceptors.add(new RestTemplateHeaderModifierInterceptor());
/*  49 */     this.restTemplate.setInterceptors(interceptors);
/*     */     
/*     */     try {
/*  52 */       Utility.expirationTime = Long.valueOf((new Date()).getTime());
/*  53 */       DisableSSLCertificateCheckUtil.disableChecks();
/*  54 */     } catch (Exception e) {
/*  55 */       Utility.authToken = "";
/*  56 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<CustomOfficeLayer> getCustomOfficeLayer(CustomOfficeLayerRequest request) {
/*  61 */     CustomOfficeLayerResponse response = sendRequestPost(request, this.baseUrl + "/api/custom-layer-level", CustomOfficeLayerResponse.class);
/*  62 */     if (response.getStatus().equalsIgnoreCase("success")) {
/*  63 */       return response.getData();
/*     */     }
/*  65 */     return new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<OfficeUnitDesignationMapResponse.Office> getOfficeUnitDesignationMap(OfficeUnitDesignationMapRequest request) {
/*  75 */     Object o = sendRequestPost(request, this.baseUrl + "/api/office/unit-designation-map", Object.class);
/*  76 */     OfficeUnitDesignationMapResponse response = this.gson.fromJson(this.gson.toJson(o), OfficeUnitDesignationMapResponse.class);
/*  77 */     if (response.getStatus().equalsIgnoreCase("success")) {
/*  78 */       return response.getData().entrySet().stream()
/*  79 */         .map(Map.Entry::getValue)
/*  80 */         .collect(Collectors.toList());
/*     */     }
/*     */     
/*  83 */     return new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <R, S> List<R> sendRequest(S request, String apiURL) {
/*     */     try {
/*  95 */       String urlWithParam = UriComponentsBuilder.fromHttpUrl(apiURL).queryParams(Utility.getParams(request)).build().toUriString();
/*  96 */       ResponseEntity<List> response = this.restTemplate.exchange(urlWithParam, HttpMethod.GET, null, List.class, new Object[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 103 */       return Arrays.asList((R[])new List[] { (List)response.getBody() });
/*     */     }
/* 105 */     catch (Exception e) {
/* 106 */       e.printStackTrace();
/*     */       
/* 108 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public <Re, Rs> Rs sendRequestPost(Re request, String apiURL, Class<Rs> type) {
/* 114 */     HttpEntity<Re> httpRequest = new HttpEntity(request);
/*     */     
/*     */     try {
/* 117 */       return (Rs)this.restTemplate.postForObject(apiURL, httpRequest, type, new Object[0]);
/*     */ 
/*     */     
/*     */     }
/* 121 */     catch (Exception e) {
/* 122 */       e.printStackTrace();
/* 123 */       log.error("===INTERNAL API COMMUNICATION FAILED:", e);
/*     */       
/* 125 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public <Re, Rs> Rs sendRequestGet(Re request, String apiURL, Class<Rs> type) {
/* 131 */     HttpEntity<Re> httpRequest = new HttpEntity(request);
/*     */     
/*     */     try {
/* 134 */       return (Rs)this.restTemplate.getForObject(apiURL, type, new Object[0]);
/*     */     
/*     */     }
/* 137 */     catch (Exception e) {
/* 138 */       e.printStackTrace();
/* 139 */       log.error("===INTERNAL API COMMUNICATION FAILED:", e);
/*     */       
/* 141 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\manager\DoptorConnectorServiceNew.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */