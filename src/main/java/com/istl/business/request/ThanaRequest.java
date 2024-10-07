/*    */ package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
/*    */ 
/*    */ 
/*    */ public class ThanaRequest implements Serializable {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String nameBn;
/*    */   
/*  9 */   public void setId(Integer id) { this.id = id; } private String bbsCode; private Integer division; private Integer district; private Integer status; public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; } public void setBbsCode(String bbsCode) { this.bbsCode = bbsCode; } public void setDivision(Integer division) { this.division = division; } public void setDistrict(Integer district) { this.district = district; } public void setStatus(Integer status) { this.status = status; }
/*    */   
/*    */   public ThanaRequest() {}
/* 12 */   public ThanaRequest(Integer id, String name, String nameBn, String bbsCode, Integer division, Integer district, Integer status) { this.id = id; this.name = name; this.nameBn = nameBn; this.bbsCode = bbsCode; this.division = division; this.district = district; this.status = status; } public static ThanaRequestBuilder builder() {
/* 13 */     return new ThanaRequestBuilder();
/*    */   }
/* 15 */   public Integer getId() { return this.id; }
/* 16 */   public String getName() { return this.name; }
/* 17 */   public String getNameBn() { return this.nameBn; }
/* 18 */   public String getBbsCode() { return this.bbsCode; }
/* 19 */   public Integer getDivision() { return this.division; }
/* 20 */   public Integer getDistrict() { return this.district; } public Integer getStatus() {
/* 21 */     return this.status;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\ThanaRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */