/*    */ package com.istl.business.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class OfficeLayer implements Serializable {
/*    */   private Long id;
/*    */   private Integer level;
/*    */   private Integer customlayerid;
/*    */   private String name;
/*    */   private String nameBn;
/*    */   
/* 12 */   public void setId(Long id) { this.id = id; } public void setLevel(Integer level) { this.level = level; } public void setCustomlayerid(Integer customlayerid) { this.customlayerid = customlayerid; } public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; }
/*    */ 
/*    */   
/*    */   public Long getId() {
/* 16 */     return this.id;
/* 17 */   } public Integer getLevel() { return this.level; }
/* 18 */   public Integer getCustomlayerid() { return this.customlayerid; }
/* 19 */   public String getName() { return this.name; } public String getNameBn() {
/* 20 */     return this.nameBn;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\OfficeLayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */