/*    */ package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
/*    */ public class OfficeRequest implements Serializable { private Integer id; private String name; private String nameBn;
/*    */   private Integer ministry;
/*    */   private Integer layer;
/*    */   private Integer division;
/*    */   private Integer district;
/*    */   private Integer upazila;
/*    */   
/*  9 */   public void setId(Integer id) { this.id = id; } private String code; private String address; private String email; private String website; private String phone; private String mobile; private String fax; private Integer parent; private Integer status; public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; } public void setMinistry(Integer ministry) { this.ministry = ministry; } public void setLayer(Integer layer) { this.layer = layer; } public void setDivision(Integer division) { this.division = division; } public void setDistrict(Integer district) { this.district = district; } public void setUpazila(Integer upazila) { this.upazila = upazila; } public void setCode(String code) { this.code = code; } public void setAddress(String address) { this.address = address; } public void setEmail(String email) { this.email = email; } public void setWebsite(String website) { this.website = website; } public void setPhone(String phone) { this.phone = phone; } public void setMobile(String mobile) { this.mobile = mobile; } public void setFax(String fax) { this.fax = fax; } public void setParent(Integer parent) { this.parent = parent; } public void setStatus(Integer status) { this.status = status; }
/*    */   
/*    */   public OfficeRequest() {}
/* 12 */   public static OfficeRequestBuilder builder() { return new OfficeRequestBuilder(); } public OfficeRequest(Integer id, String name, String nameBn, Integer ministry, Integer layer, Integer division, Integer district, Integer upazila, String code, String address, String email, String website, String phone, String mobile, String fax, Integer parent, Integer status) {
/* 13 */     this.id = id; this.name = name; this.nameBn = nameBn; this.ministry = ministry; this.layer = layer; this.division = division; this.district = district; this.upazila = upazila; this.code = code; this.address = address; this.email = email; this.website = website; this.phone = phone; this.mobile = mobile; this.fax = fax; this.parent = parent; this.status = status;
/*    */   }
/* 15 */   public Integer getId() { return this.id; }
/* 16 */   public String getName() { return this.name; }
/* 17 */   public String getNameBn() { return this.nameBn; }
/* 18 */   public Integer getMinistry() { return this.ministry; }
/* 19 */   public Integer getLayer() { return this.layer; }
/* 20 */   public Integer getDivision() { return this.division; }
/* 21 */   public Integer getDistrict() { return this.district; }
/* 22 */   public Integer getUpazila() { return this.upazila; }
/* 23 */   public String getCode() { return this.code; }
/* 24 */   public String getAddress() { return this.address; }
/* 25 */   public String getEmail() { return this.email; }
/* 26 */   public String getWebsite() { return this.website; }
/* 27 */   public String getPhone() { return this.phone; }
/* 28 */   public String getMobile() { return this.mobile; }
/* 29 */   public String getFax() { return this.fax; }
/* 30 */   public Integer getParent() { return this.parent; } public Integer getStatus() {
/* 31 */     return this.status;
/*    */   } }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\OfficeRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */