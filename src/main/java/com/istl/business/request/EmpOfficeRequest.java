/*    */
package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
/*    */ public class EmpOfficeRequest implements Serializable {
    /*    */   private Integer id;
    /*    */   private Integer employeeRecord;
    /*    */   private String idNumber;
    /*    */   private String designation;
    /*    */   private String designationLevel;

    /*    */
    /*  9 */
    public void setId(Integer id) {
        this.id = id;
    }

    private String designationSequence;
    private Integer office;
    private Integer unit;
    private String organogram;
    private String joiningDate;

    public void setEmployeeRecord(Integer employeeRecord) {
        this.employeeRecord = employeeRecord;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDesignationLevel(String designationLevel) {
        this.designationLevel = designationLevel;
    }

    public void setDesignationSequence(String designationSequence) {
        this.designationSequence = designationSequence;
    }

    public void setOffice(Integer office) {
        this.office = office;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public void setOrganogram(String organogram) {
        this.organogram = organogram;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    /*    */
    /*    */
    public EmpOfficeRequest() {
    }

    /* 12 */
    public EmpOfficeRequest(Integer id, Integer employeeRecord, String idNumber, String designation, String designationLevel, String designationSequence, Integer office, Integer unit, String organogram, String joiningDate) {
        this.id = id;
        this.employeeRecord = employeeRecord;
        this.idNumber = idNumber;
        this.designation = designation;
        this.designationLevel = designationLevel;
        this.designationSequence = designationSequence;
        this.office = office;
        this.unit = unit;
        this.organogram = organogram;
        this.joiningDate = joiningDate;
    }

    public static EmpOfficeRequestBuilder builder() {
        /* 13 */
        return new EmpOfficeRequestBuilder();
        /*    */
    }

    /* 15 */
    public Integer getId() {
        return this.id;
    }

    /* 16 */
    public Integer getEmployeeRecord() {
        return this.employeeRecord;
    }

    /* 17 */
    public String getIdNumber() {
        return this.idNumber;
    }

    /* 18 */
    public String getDesignation() {
        return this.designation;
    }

    /* 19 */
    public String getDesignationLevel() {
        return this.designationLevel;
    }

    /* 20 */
    public String getDesignationSequence() {
        return this.designationSequence;
    }

    /* 21 */
    public Integer getOffice() {
        return this.office;
    }

    /* 22 */
    public Integer getUnit() {
        return this.unit;
    }

    /* 23 */
    public String getOrganogram() {
        return this.organogram;
    }

    public String getJoiningDate() {
        /* 24 */
        return this.joiningDate;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\EmpOfficeRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */