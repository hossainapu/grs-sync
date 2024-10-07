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
@Table(name = "office_origin_units")
@Builder
/*    */ public class OfficeOriginUnit {
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private Long id;
    @Column(name = "office_origin_id")
    /*    */ private Long officeOriginId;

    /*    */
    /*  9 */
    public OfficeOriginUnit(Long id, Long officeOriginId, String nameBangla, String nameEnglish) {
        this.id = id;
        this.officeOriginId = officeOriginId;
        this.nameBangla = nameBangla;
        this.nameEnglish = nameEnglish;
    }

    @Column(name = "unit_name_bng")
    /*    */ private String nameBangla;
    @Column(name = "unit_name_eng")
    /*    */ private String nameEnglish;

    public OfficeOriginUnit() {
    }

    public void setId(Long id) {
        /* 12 */
        this.id = id;
    }

    public void setOfficeOriginId(Long officeOriginId) {
        this.officeOriginId = officeOriginId;
    }

    public void setNameBangla(String nameBangla) {
        this.nameBangla = nameBangla;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public static OfficeOriginUnitBuilder builder() {
        /* 13 */
        return new OfficeOriginUnitBuilder();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 18 */
        return this.id;
        /*    */
    }

    /*    */
    public Long getOfficeOriginId() {
        /* 21 */
        return this.officeOriginId;
        /*    */
    }

    /*    */
    public String getNameBangla() {
        /* 24 */
        return this.nameBangla;
        /*    */
    }

    /*    */
    public String getNameEnglish() {
        /* 27 */
        return this.nameEnglish;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\OfficeOriginUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */