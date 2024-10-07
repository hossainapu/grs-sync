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
@Table(name = "office_origin_unit_organograms")
@Builder
/*    */ public class OfficeOriginUnitOrganogram {
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private Long id;
    @Column(name = "office_origin_unit_id")
    /*    */ private Long officeOriginUnitId;

    /*    */
    /*  9 */
    public OfficeOriginUnitOrganogram(Long id, Long officeOriginUnitId, String nameBangla, String nameEnglish) {
        this.id = id;
        this.officeOriginUnitId = officeOriginUnitId;
        this.nameBangla = nameBangla;
        this.nameEnglish = nameEnglish;
    }

    @Column(name = "designation_bng")
    /*    */ private String nameBangla;
    @Column(name = "designation_eng")
    /*    */ private String nameEnglish;

    public OfficeOriginUnitOrganogram() {
    }

    public void setId(Long id) {
        /* 12 */
        this.id = id;
    }

    public void setOfficeOriginUnitId(Long officeOriginUnitId) {
        this.officeOriginUnitId = officeOriginUnitId;
    }

    public void setNameBangla(String nameBangla) {
        this.nameBangla = nameBangla;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public static OfficeOriginUnitOrganogramBuilder builder() {
        /* 13 */
        return new OfficeOriginUnitOrganogramBuilder();
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
    public Long getOfficeOriginUnitId() {
        /* 21 */
        return this.officeOriginUnitId;
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


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\OfficeOriginUnitOrganogram.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */