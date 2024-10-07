/*    */ package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

/*    */
@Builder
/*    */ public class MunicipalityRequest implements Serializable {
/*    */   private Integer id;
/*    */   private Integer division;
/*    */   private Integer district;
/*    */   private Integer upazila;
/*    */   
/*  9 */   public void setId(Integer id) { this.id = id; } private String name; private String nameBn; private String bbsCode; private Integer status; public void setDivision(Integer division) { this.division = division; } public void setDistrict(Integer district) { this.district = district; } public void setUpazila(Integer upazila) { this.upazila = upazila; } public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; } public void setBbsCode(String bbsCode) { this.bbsCode = bbsCode; } public void setStatus(Integer status) { this.status = status; }
/*    */   
/*    */   public MunicipalityRequest() {}
/* 12 */   public static MunicipalityRequestBuilder builder() { return new MunicipalityRequestBuilder(); } public MunicipalityRequest(Integer id, Integer division, Integer district, Integer upazila, String name, String nameBn, String bbsCode, Integer status) {
/* 13 */     this.id = id; this.division = division; this.district = district; this.upazila = upazila; this.name = name; this.nameBn = nameBn; this.bbsCode = bbsCode; this.status = status;
/*    */   }
/* 15 */   public Integer getId() { return this.id; }
/* 16 */   public Integer getDivision() { return this.division; }
/* 17 */   public Integer getDistrict() { return this.district; }
/* 18 */   public Integer getUpazila() { return this.upazila; }
/* 19 */   public String getName() { return this.name; }
/* 20 */   public String getNameBn() { return this.nameBn; }
/* 21 */   public String getBbsCode() { return this.bbsCode; } public Integer getStatus() {
/* 22 */     return this.status;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\MunicipalityRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */