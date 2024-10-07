/*    */ package com.istl.database.entity;

import lombok.Builder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*    */ @Entity
/*    */ @Table(name = "geo_city_corporations")
@Builder
/*    */ public class CityCorporation { @Id
/*    */   @Column(name = "id")
/*    */   private Integer id;
/*    */   @Column(name = "geo_division_id")
/*    */   private Integer divisionId;
/*    */   
/* 10 */   public void setId(Integer id) { this.id = id; } @Column(name = "geo_district_id") private Integer districtId; @Column(name = "city_corporation_name_eng") private String nameEnglish; @Column(name = "city_corporation_name_bng") private String nameBangla; public void setDivisionId(Integer divisionId) { this.divisionId = divisionId; } public void setDistrictId(Integer districtId) { this.districtId = districtId; } public void setNameEnglish(String nameEnglish) { this.nameEnglish = nameEnglish; } public void setNameBangla(String nameBangla) { this.nameBangla = nameBangla; }
/*    */    public CityCorporation() {}
/* 12 */   public CityCorporation(Integer id, Integer divisionId, Integer districtId, String nameEnglish, String nameBangla) { this.id = id; this.divisionId = divisionId; this.districtId = districtId; this.nameEnglish = nameEnglish; this.nameBangla = nameBangla; } public static CityCorporationBuilder builder() {
/* 13 */     return new CityCorporationBuilder();
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer getId() {
/* 18 */     return this.id;
/*    */   } public Integer getDivisionId() {
/* 20 */     return this.divisionId;
/*    */   } public Integer getDistrictId() {
/* 22 */     return this.districtId;
/*    */   } public String getNameEnglish() {
/* 24 */     return this.nameEnglish;
/*    */   } public String getNameBangla() {
/* 26 */     return this.nameBangla;
/*    */   } }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\CityCorporation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */