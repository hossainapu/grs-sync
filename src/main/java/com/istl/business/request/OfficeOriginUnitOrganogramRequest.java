/*    */ package com.istl.business.request;

import lombok.Builder;

@Builder
/*    */ public class OfficeOriginUnitOrganogramRequest { private Integer id; private Integer originUnit;
/*    */   private Integer superiorUnit;
/*    */   private String superiorDesignation;
/*    */   private String name;
/*    */   
/*  7 */   public void setId(Integer id) { this.id = id; } private String nameBn; private String shortName; private String shortNameBn; private Integer level; private Integer sequence; public void setOriginUnit(Integer originUnit) { this.originUnit = originUnit; } public void setSuperiorUnit(Integer superiorUnit) { this.superiorUnit = superiorUnit; } public void setSuperiorDesignation(String superiorDesignation) { this.superiorDesignation = superiorDesignation; } public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; } public void setShortName(String shortName) { this.shortName = shortName; } public void setShortNameBn(String shortNameBn) { this.shortNameBn = shortNameBn; } public void setLevel(Integer level) { this.level = level; } public void setSequence(Integer sequence) { this.sequence = sequence; }
/*    */    public OfficeOriginUnitOrganogramRequest() {} public OfficeOriginUnitOrganogramRequest(Integer id, Integer originUnit, Integer superiorUnit, String superiorDesignation, String name, String nameBn, String shortName, String shortNameBn, Integer level, Integer sequence) {
/*  9 */     this.id = id; this.originUnit = originUnit; this.superiorUnit = superiorUnit; this.superiorDesignation = superiorDesignation; this.name = name; this.nameBn = nameBn; this.shortName = shortName; this.shortNameBn = shortNameBn; this.level = level; this.sequence = sequence;
/*    */   } public static OfficeOriginUnitOrganogramRequestBuilder builder() {
/* 11 */     return new OfficeOriginUnitOrganogramRequestBuilder();
/*    */   }
/* 13 */   public Integer getId() { return this.id; }
/* 14 */   public Integer getOriginUnit() { return this.originUnit; }
/* 15 */   public Integer getSuperiorUnit() { return this.superiorUnit; }
/* 16 */   public String getSuperiorDesignation() { return this.superiorDesignation; }
/* 17 */   public String getName() { return this.name; }
/* 18 */   public String getNameBn() { return this.nameBn; }
/* 19 */   public String getShortName() { return this.shortName; }
/* 20 */   public String getShortNameBn() { return this.shortNameBn; }
/* 21 */   public Integer getLevel() { return this.level; } public Integer getSequence() {
/* 22 */     return this.sequence;
/*    */   } }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\OfficeOriginUnitOrganogramRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */