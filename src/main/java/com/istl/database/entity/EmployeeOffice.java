/*    */
package com.istl.database.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*    */
@Entity
/*    */
@Table(name = "employee_offices")
@Builder
/*    */ public class EmployeeOffice {
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private Long id;
    @Column(name = "office_id")
    /*    */ private Integer officeId;
    @Column(name = "office_unit_id")
    /*    */ private Integer officeUnitId;
    @Column(name = "office_unit_organogram_id")
    /*    */ private Integer officeUnitOrganogramId;
    @Column(name = "employee_record_id")
    /*    */ private Integer employeeRecordId;

    /* 11 */
    public EmployeeOffice(Long id, Integer officeId, Integer officeUnitId, Integer officeUnitOrganogramId, Integer employeeRecordId, String identificationNumber, String designation, String inchargeLabel, Boolean status, Boolean isOfficeHead, Boolean isDefaultRole) {
        this.id = id;
        this.officeId = officeId;
        this.officeUnitId = officeUnitId;
        this.officeUnitOrganogramId = officeUnitOrganogramId;
        this.employeeRecordId = employeeRecordId;
        this.identificationNumber = identificationNumber;
        this.designation = designation;
        this.inchargeLabel = inchargeLabel;
        this.status = status;
        this.isOfficeHead = isOfficeHead;
        this.isDefaultRole = isDefaultRole;
    }

    @Column(name = "identification_number")
    private String identificationNumber;
    @Column(name = "designation")
    private String designation;
    @Column(name = "incharge_label")
    private String inchargeLabel;
    @Column(name = "status")
    /*    */ private Boolean status;
    @Column(name = "office_head")
    /*    */ private Boolean isOfficeHead;
    @Column(name = "is_default_role")
    /* 14 */ private Boolean isDefaultRole;

    public EmployeeOffice() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public void setOfficeUnitId(Integer officeUnitId) {
        this.officeUnitId = officeUnitId;
    }

    public void setOfficeUnitOrganogramId(Integer officeUnitOrganogramId) {
        this.officeUnitOrganogramId = officeUnitOrganogramId;
    }

    public void setEmployeeRecordId(Integer employeeRecordId) {
        this.employeeRecordId = employeeRecordId;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setInchargeLabel(String inchargeLabel) {
        this.inchargeLabel = inchargeLabel;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setIsOfficeHead(Boolean isOfficeHead) {
        this.isOfficeHead = isOfficeHead;
    }

    public void setIsDefaultRole(Boolean isDefaultRole) {
        this.isDefaultRole = isDefaultRole;
    }

    public static EmployeeOfficeBuilder builder() {
        /* 15 */
        return new EmployeeOfficeBuilder();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 20 */
        return this.id;
        /*    */
    }

    /*    */
    public Integer getOfficeId() {
        /* 23 */
        return this.officeId;
        /*    */
    }

    /*    */
    public Integer getOfficeUnitId() {
        /* 26 */
        return this.officeUnitId;
        /*    */
    }

    /*    */
    public Integer getOfficeUnitOrganogramId() {
        /* 29 */
        return this.officeUnitOrganogramId;
        /*    */
    }

    /*    */
    public Integer getEmployeeRecordId() {
        /* 32 */
        return this.employeeRecordId;
        /*    */
    }

    /*    */
    public String getIdentificationNumber() {
        /* 35 */
        return this.identificationNumber;
        /*    */
    }

    /*    */
    public String getDesignation() {
        /* 38 */
        return this.designation;
        /*    */
    }

    /*    */
    public String getInchargeLabel() {
        /* 41 */
        return this.inchargeLabel;
        /*    */
    }

    /*    */
    public Boolean getStatus() {
        /* 44 */
        return this.status;
        /*    */
    }

    /*    */
    public Boolean getIsOfficeHead() {
        /* 47 */
        return this.isOfficeHead;
        /*    */
    }

    /*    */
    public Boolean getIsDefaultRole() {
        /* 50 */
        return this.isDefaultRole;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\EmployeeOffice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */