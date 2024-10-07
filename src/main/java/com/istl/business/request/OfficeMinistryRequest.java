/*    */ package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

/*    */
/*    */
@Builder
/*    */ public class OfficeMinistryRequest implements Serializable {
/*    */   private Integer id;
/*    */   private Integer type;
/*    */   private String reference;
/*    */   
/*  9 */   public void setId(Integer id) { this.id = id; } private String name; private String nameShort; private String nameBn; private Integer status; public void setType(Integer type) { this.type = type; } public void setReference(String reference) { this.reference = reference; } public void setName(String name) { this.name = name; } public void setNameShort(String nameShort) { this.nameShort = nameShort; } public void setNameBn(String nameBn) { this.nameBn = nameBn; } public void setStatus(Integer status) { this.status = status; }
/*    */   
/*    */   public OfficeMinistryRequest() {}
/* 12 */   public static OfficeMinistryRequestBuilder builder() { return new OfficeMinistryRequestBuilder(); } public OfficeMinistryRequest(Integer id, Integer type, String reference, String name, String nameShort, String nameBn, Integer status) {
/* 13 */     this.id = id; this.type = type; this.reference = reference; this.name = name; this.nameShort = nameShort; this.nameBn = nameBn; this.status = status;
/*    */   }
/* 15 */   public Integer getId() { return this.id; }
/* 16 */   public Integer getType() { return this.type; }
/* 17 */   public String getReference() { return this.reference; }
/* 18 */   public String getName() { return this.name; }
/* 19 */   public String getNameShort() { return this.nameShort; }
/* 20 */   public String getNameBn() { return this.nameBn; } public Integer getStatus() {
/* 21 */     return this.status;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\OfficeMinistryRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */