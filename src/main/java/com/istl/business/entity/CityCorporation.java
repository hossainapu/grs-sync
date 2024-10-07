/*    */ package com.istl.business.entity;

import java.io.Serializable;

/*    */
/*    */ 
/*    */ public class CityCorporation implements Serializable {
/*    */   private Integer id;
/*    */   private Integer division;
/*    */   private Integer district;
/*    */   private String bbsCode;
/*    */   private String name;
/*    */   private String nameBn;
/*    */   
/* 12 */   public void setId(Integer id) { this.id = id; } public void setDivision(Integer division) { this.division = division; } public void setDistrict(Integer district) { this.district = district; } public void setBbsCode(String bbsCode) { this.bbsCode = bbsCode; } public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; }
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getId() {
/* 17 */     return this.id; }
/* 18 */   public Integer getDivision() { return this.division; }
/* 19 */   public Integer getDistrict() { return this.district; }
/* 20 */   public String getBbsCode() { return this.bbsCode; }
/* 21 */   public String getName() { return this.name; } public String getNameBn() {
/* 22 */     return this.nameBn;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\CityCorporation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */