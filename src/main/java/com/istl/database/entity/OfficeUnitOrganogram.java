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
@Table(name = "office_unit_organograms")
@Builder
/*    */ public class OfficeUnitOrganogram {
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private Long id;
    @Column(name = "is_admin")
    /*    */ public Boolean isAdmin;
    @Column(name = "status")
    /*    */ public Boolean status;
    @Column(name = "office_id")
    /*  9 */ private Integer officeId;

    public OfficeUnitOrganogram(Long id, Boolean isAdmin, Boolean status, Integer officeId, Integer officeUnitId, String designationEnglish, String designationBangla, Integer refOriginUnitOrgId) {
        this.id = id;
        this.isAdmin = isAdmin;
        this.status = status;
        this.officeId = officeId;
        this.officeUnitId = officeUnitId;
        this.designationEnglish = designationEnglish;
        this.designationBangla = designationBangla;
        this.refOriginUnitOrgId = refOriginUnitOrgId;
    }

    @Column(name = "office_unit_id")
    private Integer officeUnitId;
    @Column(name = "designation_eng")
    private String designationEnglish;
    @Column(name = "designation_bng")
    /*    */ private String designationBangla;
    @Column(name = "ref_origin_unit_org_id")
    /* 11 */ private Integer refOriginUnitOrgId;

    public OfficeUnitOrganogram() {
    }

    public static OfficeUnitOrganogramBuilder builder() {
        return new OfficeUnitOrganogramBuilder();
    }

    /*    */
    /* 13 */
    public void setId(Long id) {
        this.id = id;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public void setOfficeUnitId(Integer officeUnitId) {
        this.officeUnitId = officeUnitId;
    }

    public void setDesignationEnglish(String designationEnglish) {
        this.designationEnglish = designationEnglish;
    }

    public void setDesignationBangla(String designationBangla) {
        this.designationBangla = designationBangla;
    }

    public void setRefOriginUnitOrgId(Integer refOriginUnitOrgId) {
        this.refOriginUnitOrgId = refOriginUnitOrgId;
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 19 */
        return this.id;
        /*    */
    }

    /*    */
    public Boolean getIsAdmin() {
        /* 22 */
        return this.isAdmin;
        /*    */
    }

    /*    */
    public Boolean getStatus() {
        /* 25 */
        return this.status;
        /*    */
    }

    /*    */
    public Integer getOfficeId() {
        /* 28 */
        return this.officeId;
        /*    */
    }

    /*    */
    public Integer getOfficeUnitId() {
        /* 31 */
        return this.officeUnitId;
        /*    */
    }

    /*    */
    public String getDesignationEnglish() {
        /* 34 */
        return this.designationEnglish;
        /*    */
    }

    /*    */
    public String getDesignationBangla() {
        /* 37 */
        return this.designationBangla;
        /*    */
    }

    /*    */
    public Integer getRefOriginUnitOrgId() {
        /* 40 */
        return this.refOriginUnitOrgId;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\OfficeUnitOrganogram.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */