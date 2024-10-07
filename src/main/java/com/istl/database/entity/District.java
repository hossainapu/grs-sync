/*    */ package com.istl.database.entity;

import lombok.Builder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*    */ @Entity
/*    */ @Table(name = "geo_districts")
@Builder
/*    */ public class District { @Id
/*    */   @Column(name = "id")
/*    */   private Integer id; @Column(name = "geo_division_id")
/*    */   private Integer divisionId;
/*    */   
/*  9 */   public District(Integer id, Integer divisionId, String nameEnglish, String nameBangla) { this.id = id; this.divisionId = divisionId; this.nameEnglish = nameEnglish; this.nameBangla = nameBangla; } @Column(name = "district_name_eng")
/*    */   private String nameEnglish; @Column(name = "district_name_bng")
/*    */   private String nameBangla; public District() {} public void setId(Integer id) {
/* 12 */     this.id = id; } public void setDivisionId(Integer divisionId) { this.divisionId = divisionId; } public void setNameEnglish(String nameEnglish) { this.nameEnglish = nameEnglish; } public void setNameBangla(String nameBangla) { this.nameBangla = nameBangla; } public static DistrictBuilder builder() {
/* 13 */     return new DistrictBuilder();
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer getId() {
/* 18 */     return this.id;
/*    */   } public Integer getDivisionId() {
/* 20 */     return this.divisionId;
/*    */   } public String getNameEnglish() {
/* 22 */     return this.nameEnglish;
/*    */   } public String getNameBangla() {
/* 24 */     return this.nameBangla;
/*    */   } }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\District.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */