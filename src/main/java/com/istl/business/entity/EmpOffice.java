/*    */
package com.istl.business.entity;
/*    */
/*    */

import java.io.Serializable;
/*    */ import java.util.Date;

/*    */
/*    */ public class EmpOffice implements Serializable {
    /*    */   private Integer id;
    /*    */   private Integer unit;
    /*    */   private Integer employeeRecord;
    /*    */   private Date joiningDate;
    /*    */   private Integer office;

    /*    */
    /* 13 */
    public void setId(Integer id) {
        this.id = id;
    }

    private String designation;
    private Integer organogram;
    private Date lastDate;
    private boolean status;
    private Integer officeHead;

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public void setEmployeeRecord(Integer employeeRecord) {
        this.employeeRecord = employeeRecord;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setOffice(Integer office) {
        this.office = office;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setOrganogram(Integer organogram) {
        this.organogram = organogram;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setOfficeHead(Integer officeHead) {
        this.officeHead = officeHead;
    }

    /*    */
    /*    */
    /*    */
    public Integer getId() {
        /* 17 */
        return this.id;
        /* 18 */
    }

    public Integer getUnit() {
        return this.unit;
    }

    /* 19 */
    public Integer getEmployeeRecord() {
        return this.employeeRecord;
    }

    /* 20 */
    public Date getJoiningDate() {
        return this.joiningDate;
    }

    /* 21 */
    public Integer getOffice() {
        return this.office;
    }

    /* 22 */
    public String getDesignation() {
        return this.designation;
    }

    /* 23 */
    public Integer getOrganogram() {
        return this.organogram;
    }

    /* 24 */
    public Date getLastDate() {
        return this.lastDate;
    }

    /* 25 */
    public boolean isStatus() {
        return this.status;
    }

    public Integer getOfficeHead() {
        /* 26 */
        return this.officeHead;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\EmpOffice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */