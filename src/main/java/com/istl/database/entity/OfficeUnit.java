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
@Table(name = "office_units")
@Builder
/*    */ public class OfficeUnit {
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private Long id;
    @Column(name = "office_id")
    /*    */ private Integer officeId;
    @Column(name = "office_ministry_id")
    /*    */ private Integer ministryId;
    @Column(name = "office_layer_id")
    /*    */ private Integer officeLayerId;

    /*    */
    /* 11 */
    public OfficeUnit(Long id, Integer officeId, Integer ministryId, Integer officeLayerId, Integer parentUnitId, String unitNameEnglish, String unitNameBangla, String email, String phoneNumber) {
        this.id = id;
        this.officeId = officeId;
        this.ministryId = ministryId;
        this.officeLayerId = officeLayerId;
        this.parentUnitId = parentUnitId;
        this.unitNameEnglish = unitNameEnglish;
        this.unitNameBangla = unitNameBangla;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "parent_unit_id")
    private Integer parentUnitId;
    @Column(name = "unit_name_eng")
    private String unitNameEnglish;
    @Column(name = "unit_name_bng")
    private String unitNameBangla;
    @Column(name = "email")
    /*    */ private String email;
    @Column(name = "phone")
    /* 13 */ private String phoneNumber;

    public OfficeUnit() {
    }

    public static OfficeUnitBuilder builder() {
        return new OfficeUnitBuilder();
    }

    /*    */
    /* 15 */
    public void setId(Long id) {
        this.id = id;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public void setMinistryId(Integer ministryId) {
        this.ministryId = ministryId;
    }

    public void setOfficeLayerId(Integer officeLayerId) {
        this.officeLayerId = officeLayerId;
    }

    public void setParentUnitId(Integer parentUnitId) {
        this.parentUnitId = parentUnitId;
    }

    public void setUnitNameEnglish(String unitNameEnglish) {
        this.unitNameEnglish = unitNameEnglish;
    }

    public void setUnitNameBangla(String unitNameBangla) {
        this.unitNameBangla = unitNameBangla;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*    */
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
    public Integer getMinistryId() {
        /* 26 */
        return this.ministryId;
        /*    */
    }

    /*    */
    public Integer getOfficeLayerId() {
        /* 29 */
        return this.officeLayerId;
        /*    */
    }

    /*    */
    public Integer getParentUnitId() {
        /* 32 */
        return this.parentUnitId;
        /*    */
    }

    /*    */
    public String getUnitNameEnglish() {
        /* 35 */
        return this.unitNameEnglish;
        /*    */
    }

    /*    */
    public String getUnitNameBangla() {
        /* 38 */
        return this.unitNameBangla;
        /*    */
    }

    /*    */
    public String getEmail() {
        /* 41 */
        return this.email;
        /*    */
    }

    /*    */
    public String getPhoneNumber() {
        /* 44 */
        return this.phoneNumber;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\OfficeUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */