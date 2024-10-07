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
@Table(name = "office_origins")
@Builder
/*    */ public class OfficeOrigin {
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private Long id;
    @Column(name = "office_layer_id")
    /*    */ private Long officeLayerId;

    /*  8 */
    public OfficeOrigin(Long id, Long officeLayerId, String officeNameEnglish, String officeNameBangla, Long parentOfficeOriginId) {
        this.id = id;
        this.officeLayerId = officeLayerId;
        this.officeNameEnglish = officeNameEnglish;
        this.officeNameBangla = officeNameBangla;
        this.parentOfficeOriginId = parentOfficeOriginId;
    }

    @Column(name = "office_name_eng")
    /*    */ private String officeNameEnglish;
    @Column(name = "office_name_bng")
    /*    */ private String officeNameBangla;
    @Column(name = "parent_office_id")
    /* 11 */ private Long parentOfficeOriginId;

    public OfficeOrigin() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOfficeLayerId(Long officeLayerId) {
        this.officeLayerId = officeLayerId;
    }

    public void setOfficeNameEnglish(String officeNameEnglish) {
        this.officeNameEnglish = officeNameEnglish;
    }

    public void setOfficeNameBangla(String officeNameBangla) {
        this.officeNameBangla = officeNameBangla;
    }

    public void setParentOfficeOriginId(Long parentOfficeOriginId) {
        this.parentOfficeOriginId = parentOfficeOriginId;
    }

    public static OfficeOriginBuilder builder() {
        /* 12 */
        return new OfficeOriginBuilder();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 17 */
        return this.id;
        /*    */
    }

    /*    */
    public Long getOfficeLayerId() {
        /* 20 */
        return this.officeLayerId;
        /*    */
    }

    /*    */
    public String getOfficeNameEnglish() {
        /* 23 */
        return this.officeNameEnglish;
        /*    */
    }

    /*    */
    public String getOfficeNameBangla() {
        /* 26 */
        return this.officeNameBangla;
        /*    */
    }

    /*    */
    public Long getParentOfficeOriginId() {
        /* 29 */
        return this.parentOfficeOriginId;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\OfficeOrigin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */