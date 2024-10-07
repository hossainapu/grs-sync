/*    */ package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
/*    */ public class OfficeUnitRequest implements Serializable { private Integer id;
/*    */   private Integer parent;
/*    */   private Integer office;
/*    */   private Integer ministry;
/*    */   private String name;
/*    */   private String nameBn;
/*    */   
/*  9 */   public void setId(Integer id) { this.id = id; } private String level; private Integer layer; private String phone; private String email; private String fax; private Integer status; public void setParent(Integer parent) { this.parent = parent; } public void setOffice(Integer office) { this.office = office; } public void setMinistry(Integer ministry) { this.ministry = ministry; } public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; } public void setLevel(String level) { this.level = level; } public void setLayer(Integer layer) { this.layer = layer; } public void setPhone(String phone) { this.phone = phone; } public void setEmail(String email) { this.email = email; } public void setFax(String fax) { this.fax = fax; } public void setStatus(Integer status) { this.status = status; }
/*    */    public OfficeUnitRequest() {}
/* 11 */   public OfficeUnitRequest(Integer id, Integer parent, Integer office, Integer ministry, String name, String nameBn, String level, Integer layer, String phone, String email, String fax, Integer status) { this.id = id; this.parent = parent; this.office = office; this.ministry = ministry; this.name = name; this.nameBn = nameBn; this.level = level; this.layer = layer; this.phone = phone; this.email = email; this.fax = fax; this.status = status; } public static OfficeUnitRequestBuilder builder() {
/* 12 */     return new OfficeUnitRequestBuilder();
/*    */   }
/*    */   
/* 15 */   public Integer getId() { return this.id; }
/* 16 */   public Integer getParent() { return this.parent; }
/* 17 */   public Integer getOffice() { return this.office; }
/* 18 */   public Integer getMinistry() { return this.ministry; }
/* 19 */   public String getName() { return this.name; }
/* 20 */   public String getNameBn() { return this.nameBn; }
/* 21 */   public String getLevel() { return this.level; }
/* 22 */   public Integer getLayer() { return this.layer; }
/* 23 */   public String getPhone() { return this.phone; }
/* 24 */   public String getEmail() { return this.email; }
/* 25 */   public String getFax() { return this.fax; } public Integer getStatus() {
/* 26 */     return this.status;
/*    */   } }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\OfficeUnitRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */