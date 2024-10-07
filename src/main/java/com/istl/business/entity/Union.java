/*    */ package com.istl.business.entity;

import java.io.Serializable;

/*    */
/*    */ public class Union implements Serializable {
/*    */   private Integer id;
/*    */   private Integer division;
/*    */   private Integer district;
/*    */   private Integer upazila;
/*    */   private String bbsCode;
/*    */   private String name;
/*    */   private String nameBn;
/*    */   
/* 12 */   public void setId(Integer id) { this.id = id; } public void setDivision(Integer division) { this.division = division; } public void setDistrict(Integer district) { this.district = district; } public void setUpazila(Integer upazila) { this.upazila = upazila; } public void setBbsCode(String bbsCode) { this.bbsCode = bbsCode; } public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getId() {
/* 17 */     return this.id; }
/* 18 */   public Integer getDivision() { return this.division; }
/* 19 */   public Integer getDistrict() { return this.district; }
/* 20 */   public Integer getUpazila() { return this.upazila; }
/* 21 */   public String getBbsCode() { return this.bbsCode; }
/* 22 */   public String getName() { return this.name; } public String getNameBn() {
/* 23 */     return this.nameBn;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\Union.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */