/*     */ package com.istl.business.manager;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.istl.business.entity.*;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ import com.istl.business.request.*;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ import com.istl.config.RestTemplateHeaderModifierInterceptor;
import com.istl.utils.DisableSSLCertificateCheckUtil;
import com.istl.utils.Utility;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
import java.util.List;
/*     */ import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.http.client.ClientHttpRequestInterceptor;
/*     */ import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

/*     */
/*     */ @Service
/*     */ public class DoptorConnectorServiceV1 {
/*  33 */   private static final Logger log = LoggerFactory.getLogger(com.istl.business.manager.DoptorConnectorServiceV1.class);
/*     */   @Autowired
/*     */ Gson gson;
/*     */   @Autowired
/*     */ ObjectMapper objectMapper;
/*     */   private RestTemplate restTemplate;
/*     */   @Value("${nothi.baseUrlv1}")
/*     */   private String baseUrl;
/*     */   
/*     */   @PostConstruct
/*     */   public void init() {
/*  44 */     this.restTemplate = new RestTemplate();
/*  45 */     List<ClientHttpRequestInterceptor> interceptors = this.restTemplate.getInterceptors();
/*  46 */     if (CollectionUtils.isEmpty(interceptors)) {
/*  47 */       interceptors = new ArrayList<>();
/*     */     }
/*  49 */     interceptors.add(new RestTemplateHeaderModifierInterceptor());
/*  50 */     this.restTemplate.setInterceptors(interceptors);
/*     */     
/*     */     try {
/*  53 */       Utility.expirationTime = Long.valueOf((new Date()).getTime());
/*  54 */       DisableSSLCertificateCheckUtil.disableChecks();
/*  55 */     } catch (Exception e) {
/*  56 */       Utility.authToken = "";
/*  57 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Division> getDivision(DivisionRequest request) {
/*  63 */     return sendRequest(request, this.baseUrl + "/api/v1/division", Division[].class);
/*     */   }
/*     */   
/*     */   public List<OfficeMinistry> getOfficeMinistry(OfficeMinistryRequest request) {
/*  67 */     return sendRequest(request, this.baseUrl + "/api/v1/officeministry", OfficeMinistry[].class);
/*     */   }
/*     */   
/*     */   public List<OfficeLayer> getOfficeLayer(OfficeLayerRequest request) {
/*  71 */     return sendRequest(request, this.baseUrl + "/api/v1/officelayer", OfficeLayer[].class);
/*     */   }
/*     */   
/*     */   public List<OfficeOriginUnitOrganogram> getOfficeOriginUnitOrganogram(OfficeOriginUnitOrganogramRequest request) {
/*  75 */     return sendRequest(request, this.baseUrl + "/api/v1/officeoriginunitorganogram", OfficeOriginUnitOrganogram[].class);
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
/*     */   public List<District> getDistrict(DistrictRequest request) {
/*  99 */     return sendRequest(request, this.baseUrl + "/api/v1/district", District[].class);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Thana> getThana(ThanaRequest request) {
/* 104 */     return sendRequest(request, this.baseUrl + "/api/v1/thana", Thana[].class);
/*     */   }
/*     */   
/*     */   public List<Upazila> getUpazila(UpazilaRequest request) {
/* 108 */     return sendRequest(request, this.baseUrl + "/api/v1/upazilla", Upazila[].class);
/*     */   }
/*     */   
/*     */   public List<CityCorporation> getCityCorporation(CityCorporationRequest request) {
/* 112 */     return sendRequest(request, this.baseUrl + "/api/v1/citycorporation", CityCorporation[].class);
/*     */   }
/*     */   
/*     */   public List<Municipality> getMunicipality(MunicipalityRequest request) {
/* 116 */     return sendRequest(request, this.baseUrl + "/api/v1/municipalitie", Municipality[].class);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Office> getOffice(OfficeRequest officeRequest) {
/* 121 */     return sendRequest(officeRequest, this.baseUrl + "/api/v1/office", Office[].class);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OfficeOriginUnit> getOfficeoriginUnit(OfficeOriginUnitRequest officeRequest) {
/* 126 */     return sendRequest(officeRequest, this.baseUrl + "/api/v1/officeoriginunit", OfficeOriginUnit[].class);
/*     */   }
/*     */   
/*     */   public List<OfficeOrigin> getOfficeOrigin(OfficeOriginRequest request) {
/* 130 */     return sendRequest(request, this.baseUrl + "/api/v1/officeorigin", OfficeOrigin[].class);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<EmpRecord> getEmpRecord(EmpRecordRequest request) {
/* 135 */     return sendRequest(request, this.baseUrl + "/api/v1/emprecord", EmpRecord[].class);
/*     */   }
/*     */   
/*     */   public List<EmpOffice> getEmployeeOffice(EmpOfficeRequest request) {
/* 139 */     return sendRequest(request, this.baseUrl + "/api/v1/empoffice", EmpOffice[].class);
/*     */   }
/*     */   
/*     */   public List<OfficeUnit> getOfficeUnit(OfficeUnitRequest request) {
/* 143 */     return sendRequest(request, this.baseUrl + "/api/v1/officeunit", OfficeUnit[].class);
/*     */   }
/*     */   
/*     */   public List<OfficeUnitOrganogram> getOfficeUnitOrganogram(OfficeUnitOrganoganogramRequest request) {
/* 147 */     return sendRequest(request, this.baseUrl + "/api/v1/officeunitorganogram", OfficeUnitOrganogram[].class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <R, S> List<R> sendRequest(S request, String apiURL, Class<R[]> T) {
/*     */     try {
/* 155 */       String urlWithParam = UriComponentsBuilder.fromHttpUrl(apiURL).queryParams(Utility.getParams(request)).build().toUriString();
/*     */ 
/*     */       
/* 158 */       ResponseEntity<Object[]> exchange = this.restTemplate.exchange(urlWithParam, HttpMethod.GET, null, Object[].class, new Object[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       Object[] body = (Object[])exchange.getBody();
/* 166 */       if (body.length > 0) {
/*     */         
/* 168 */         R[] rs = (R[])this.gson.fromJson(this.gson.toJson(body), T);
/* 169 */         return Arrays.asList(rs);
/*     */       } 
/* 171 */       return new ArrayList<>();
/*     */     
/*     */     }
/* 174 */     catch (HttpMessageNotReadableException e) {
/*     */       
/* 176 */       return new ArrayList<>();
/* 177 */     } catch (Exception e) {
/*     */       
/* 179 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <R, S> List<R> sendRequestEx(S request, String apiURL, Class<R[]> T) {
/*     */     try {
/* 187 */       String urlWithParam = UriComponentsBuilder.fromHttpUrl(apiURL).queryParams(Utility.getParams(request)).build().toUriString();
/* 188 */       ResponseEntity<Object[]> exchange = this.restTemplate.exchange(urlWithParam, HttpMethod.GET, null, Object[].class, new Object[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 194 */       R[] rs = (R[])this.gson.fromJson(this.gson.toJson(exchange.getBody()), T);
/*     */ 
/*     */       
/* 197 */       return Arrays.asList(rs);
/*     */     }
/* 199 */     catch (Exception e) {
/* 200 */       e.printStackTrace();
/* 201 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <R, S> List<R> sendRequest(S request, String apiURL) {
/*     */     try {
/* 209 */       String urlWithParam = UriComponentsBuilder.fromHttpUrl(apiURL).queryParams(Utility.getParams(request)).build().toUriString();
/* 210 */       ResponseEntity<List> response = this.restTemplate.exchange(urlWithParam, HttpMethod.GET, null, List.class, new Object[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 217 */       return Arrays.asList((R[])new List[] { (List)response.getBody() });
/*     */     }
/* 219 */     catch (Exception e) {
/* 220 */       e.printStackTrace();
/*     */       
/* 222 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\manager\DoptorConnectorServiceV1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */