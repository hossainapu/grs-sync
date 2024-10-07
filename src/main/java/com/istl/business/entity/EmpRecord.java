/*    */
package com.istl.business.entity;

import java.io.Serializable;
import java.util.Date;

/*    */ public class EmpRecord implements Serializable {
    private Integer cadreNonCadre;
    private String gender;
    private String father;
    private String nameBn;
    /*    */   private String nid;
    /*    */   private String mobile;
    /*    */   private Date joiningDate;
    /*    */   private Integer currentOffice;
    /*    */   private String religion;
    /*    */   private String ppn;

    /*    */
    /* 10 */
    public void setCadreNonCadre(Integer cadreNonCadre) {
        this.cadreNonCadre = cadreNonCadre;
    }

    private String mother;
    private String bloodGroup;
    private Date dob;
    private Integer grade;
    private String name;
    private Integer id;
    private String maritalStatus;
    private String email;
    private String nationality;
    private Integer currentRank;

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setCurrentOffice(Integer currentOffice) {
        this.currentOffice = currentOffice;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setPpn(String ppn) {
        this.ppn = ppn;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setCurrentRank(Integer currentRank) {
        this.currentRank = currentRank;
    }

    /*    */
    public EmpRecord() {
    }

    public EmpRecord(Integer cadreNonCadre, String gender, String father, String nameBn, String nid, String mobile, Date joiningDate, Integer currentOffice, String religion, String ppn, String mother, String bloodGroup, Date dob, Integer grade, String name, Integer id, String maritalStatus, String email, String nationality, Integer currentRank) {
        /* 12 */
        this.cadreNonCadre = cadreNonCadre;
        this.gender = gender;
        this.father = father;
        this.nameBn = nameBn;
        this.nid = nid;
        this.mobile = mobile;
        this.joiningDate = joiningDate;
        this.currentOffice = currentOffice;
        this.religion = religion;
        this.ppn = ppn;
        this.mother = mother;
        this.bloodGroup = bloodGroup;
        this.dob = dob;
        this.grade = grade;
        this.name = name;
        this.id = id;
        this.maritalStatus = maritalStatus;
        this.email = email;
        this.nationality = nationality;
        this.currentRank = currentRank;
        /*    */
    }

    /*    */
    /* 15 */
    public Integer getCadreNonCadre() {
        return this.cadreNonCadre;
    }

    public String getGender() {
        /* 16 */
        return this.gender;
        /*    */
    }

    /* 18 */
    public String getFather() {
        return this.father;
    }

    /* 19 */
    public String getNameBn() {
        return this.nameBn;
    }

    public String getNid() {
        /* 20 */
        return this.nid;
        /*    */
    }

    /* 22 */
    public String getMobile() {
        return this.mobile;
    }

    /* 23 */
    public Date getJoiningDate() {
        return this.joiningDate;
    }

    /* 24 */
    public Integer getCurrentOffice() {
        return this.currentOffice;
    }

    /* 25 */
    public String getReligion() {
        return this.religion;
    }

    /* 26 */
    public String getPpn() {
        return this.ppn;
    }

    /* 27 */
    public String getMother() {
        return this.mother;
    }

    /* 28 */
    public String getBloodGroup() {
        return this.bloodGroup;
    }

    /* 29 */
    public Date getDob() {
        return this.dob;
    }

    /* 30 */
    public Integer getGrade() {
        return this.grade;
    }

    /* 31 */
    public String getName() {
        return this.name;
    }

    /* 32 */
    public Integer getId() {
        return this.id;
    }

    /* 33 */
    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public String getEmail() {
        /* 34 */
        return this.email;
        /*    */
    }

    /*    */
    /* 37 */
    public String getNationality() {
        return this.nationality;
    }

    public Integer getCurrentRank() {
        /* 38 */
        return this.currentRank;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\EmpRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */