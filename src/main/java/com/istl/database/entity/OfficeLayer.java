/*    */ package com.istl.database.entity;
import lombok.Builder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*    */ @Entity
/*    */ @Table(name = "office_layers")
@Builder
/*    */ public class OfficeLayer { @Id
/*    */   @Column(name = "id")
/*    */   private Long id; @Column(length = 255, name = "layer_name_bng")
/*    */   private String layerNameBangla; @Column(length = 255, name = "layer_name_eng")
/*  8 */   private String layerNameEnglish; public OfficeLayer(Long id, String layerNameBangla, String layerNameEnglish, Integer layerLevel, Integer customLayerId, Integer layerSequence, Long officeMinistryId) { this.id = id; this.layerNameBangla = layerNameBangla; this.layerNameEnglish = layerNameEnglish; this.layerLevel = layerLevel; this.customLayerId = customLayerId; this.layerSequence = layerSequence; this.officeMinistryId = officeMinistryId; } @Column(name = "layer_level") private Integer layerLevel; @Column(name = "custom_layer_id")
/*    */   private Integer customLayerId; @Column(name = "layer_sequence")
/*    */   private Integer layerSequence; @Column(name = "office_ministry_id")
/* 11 */   private Long officeMinistryId; public OfficeLayer() {} public void setId(Long id) { this.id = id; } public void setLayerNameBangla(String layerNameBangla) { this.layerNameBangla = layerNameBangla; } public void setLayerNameEnglish(String layerNameEnglish) { this.layerNameEnglish = layerNameEnglish; } public void setLayerLevel(Integer layerLevel) { this.layerLevel = layerLevel; } public void setCustomLayerId(Integer customLayerId) { this.customLayerId = customLayerId; } public void setLayerSequence(Integer layerSequence) { this.layerSequence = layerSequence; } public void setOfficeMinistryId(Long officeMinistryId) { this.officeMinistryId = officeMinistryId; } public static OfficeLayerBuilder builder() {
/* 12 */     return new OfficeLayerBuilder();
/*    */   }
/*    */ 
/*    */   
/*    */   public Long getId() {
/* 17 */     return this.id;
/*    */   }
/*    */   public String getLayerNameBangla() {
/* 20 */     return this.layerNameBangla;
/*    */   }
/*    */   public String getLayerNameEnglish() {
/* 23 */     return this.layerNameEnglish;
/*    */   }
/*    */   public Integer getLayerLevel() {
/* 26 */     return this.layerLevel;
/*    */   }
/*    */   public Integer getCustomLayerId() {
/* 29 */     return this.customLayerId;
/*    */   }
/*    */   public Integer getLayerSequence() {
/* 32 */     return this.layerSequence;
/*    */   }
/*    */   public Long getOfficeMinistryId() {
/* 35 */     return this.officeMinistryId;
/*    */   } }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\OfficeLayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */