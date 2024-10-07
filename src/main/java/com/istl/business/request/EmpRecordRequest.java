/*    */ package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
/*    */ public class EmpRecordRequest implements Serializable { private Integer id; private String name;
/*    */   private String nameBn;
/*    */   private String father;
/*    */   private String mother;
/*    */   private String dob;
/*    */   private String pob;
/*    */   
/*  9 */   public void setId(Integer id) { this.id = id; } private String nationality; private String nid; private String religion; private String joiningDate; private Integer currentRank; private Integer currentOffice; private Integer status; public void setName(String name) { this.name = name; } public void setNameBn(String nameBn) { this.nameBn = nameBn; } public void setFather(String father) { this.father = father; } public void setMother(String mother) { this.mother = mother; } public void setDob(String dob) { this.dob = dob; } public void setPob(String pob) { this.pob = pob; } public void setNationality(String nationality) { this.nationality = nationality; } public void setNid(String nid) { this.nid = nid; } public void setReligion(String religion) { this.religion = religion; } public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; } public void setCurrentRank(Integer currentRank) { this.currentRank = currentRank; } public void setCurrentOffice(Integer currentOffice) { this.currentOffice = currentOffice; } public void setStatus(Integer status) { this.status = status; }
/*    */    public EmpRecordRequest() {}
/* 11 */   public EmpRecordRequest(Integer id, String name, String nameBn, String father, String mother, String dob, String pob, String nationality, String nid, String religion, String joiningDate, Integer currentRank, Integer currentOffice, Integer status) { this.id = id; this.name = name; this.nameBn = nameBn; this.father = father; this.mother = mother; this.dob = dob; this.pob = pob; this.nationality = nationality; this.nid = nid; this.religion = religion; this.joiningDate = joiningDate; this.currentRank = currentRank; this.currentOffice = currentOffice; this.status = status; } public static EmpRecordRequestBuilder builder() {
/* 12 */     return new EmpRecordRequestBuilder();
/*    */   }
/*    */   
/* 15 */   public Integer getId() { return this.id; }
/* 16 */   public String getName() { return this.name; }
/* 17 */   public String getNameBn() { return this.nameBn; }
/* 18 */   public String getFather() { return this.father; }
/* 19 */   public String getMother() { return this.mother; }
/* 20 */   public String getDob() { return this.dob; }
/* 21 */   public String getPob() { return this.pob; }
/* 22 */   public String getNationality() { return this.nationality; }
/* 23 */   public String getNid() { return this.nid; }
/* 24 */   public String getReligion() { return this.religion; }
/* 25 */   public String getJoiningDate() { return this.joiningDate; }
/* 26 */   public Integer getCurrentRank() { return this.currentRank; }
/* 27 */   public Integer getCurrentOffice() { return this.currentOffice; } public Integer getStatus() {
/* 28 */     return this.status;
/*    */   } }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\EmpRecordRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */