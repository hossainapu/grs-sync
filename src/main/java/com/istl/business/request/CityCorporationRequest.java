/*    */ package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

/*    */
/*    */
@Builder
/*    */ public class CityCorporationRequest implements Serializable {
/*    */   private Integer id;
/*    */   private Integer division;
/*    */   private Integer district;
/*    */   
/*  9 */   public void setId(Integer id) { this.id = id; } private String bbsCode; private String name; private String nameBn; private Integer status; public void setDivision(Integer division) { this.division = division; } public void setDistrict(Integer district) { this.district = district; } public void setBbsCode(String bbsCode) { this.bbsCode = bbsCode; } public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; } public void setStatus(Integer status) { this.status = status; }
/*    */   
/*    */   public CityCorporationRequest() {}
/* 12 */   public static CityCorporationRequestBuilder builder() { return new CityCorporationRequestBuilder(); } public CityCorporationRequest(Integer id, Integer division, Integer district, String bbsCode, String name, String nameBn, Integer status) {
/* 13 */     this.id = id; this.division = division; this.district = district; this.bbsCode = bbsCode; this.name = name; this.nameBn = nameBn; this.status = status;
/*    */   }
/*    */   
/* 16 */   public Integer getId() { return this.id; }
/* 17 */   public Integer getDivision() { return this.division; }
/* 18 */   public Integer getDistrict() { return this.district; }
/* 19 */   public String getBbsCode() { return this.bbsCode; }
/* 20 */   public String getName() { return this.name; }
/* 21 */   public String getNameBn() { return this.nameBn; } public Integer getStatus() {
/* 22 */     return this.status;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\CityCorporationRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */