/*    */ package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

/*    */
@Builder
/*    */ public class OfficeOriginRequest implements Serializable {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String nameBn;
/*    */   private Integer ministry;
/*    */   
/*  9 */   public void setId(Integer id) { this.id = id; } private Integer layer; private Integer parent; private Integer level; private Integer sequence; private Integer status; public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; } public void setMinistry(Integer ministry) { this.ministry = ministry; } public void setLayer(Integer layer) { this.layer = layer; } public void setParent(Integer parent) { this.parent = parent; } public void setLevel(Integer level) { this.level = level; } public void setSequence(Integer sequence) { this.sequence = sequence; } public void setStatus(Integer status) { this.status = status; }
/*    */   
/* 11 */   public OfficeOriginRequest(Integer id, String name, String nameBn, Integer ministry, Integer layer, Integer parent, Integer level, Integer sequence, Integer status) { this.id = id; this.name = name; this.nameBn = nameBn; this.ministry = ministry; this.layer = layer; this.parent = parent; this.level = level; this.sequence = sequence; this.status = status; } public static OfficeOriginRequestBuilder builder() {
/* 12 */     return new OfficeOriginRequestBuilder();
/*    */   }
/*    */   public OfficeOriginRequest() {}
/* 15 */   public Integer getId() { return this.id; }
/* 16 */   public String getName() { return this.name; }
/* 17 */   public String getNameBn() { return this.nameBn; }
/* 18 */   public Integer getMinistry() { return this.ministry; }
/* 19 */   public Integer getLayer() { return this.layer; }
/* 20 */   public Integer getParent() { return this.parent; }
/* 21 */   public Integer getLevel() { return this.level; }
/* 22 */   public Integer getSequence() { return this.sequence; } public Integer getStatus() {
/* 23 */     return this.status;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\OfficeOriginRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */