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
@Table(name = "geo_upazilas")
@Builder
/*    */ public class Upazila {
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private Integer id;
    @Column(name = "geo_division_id")
    /*    */ private Integer divisionId;

    /*    */
    /*  9 */
    public Upazila(Integer id, Integer divisionId, Integer districtId, String nameEnglish, String nameBangla) {
        this.id = id;
        this.divisionId = divisionId;
        this.districtId = districtId;
        this.nameEnglish = nameEnglish;
        this.nameBangla = nameBangla;
    }

    @Column(name = "geo_district_id")
    /*    */ private Integer districtId;
    @Column(name = "upazila_name_eng")
    /*    */ private String nameEnglish;
    @Column(name = "upazila_name_bng")
    /* 12 */ private String nameBangla;

    public Upazila() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public void setNameBangla(String nameBangla) {
        this.nameBangla = nameBangla;
    }

    public static UpazilaBuilder builder() {
        /* 13 */
        return new UpazilaBuilder();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public Integer getId() {
        /* 18 */
        return this.id;
        /*    */
    }

    public Integer getDivisionId() {
        /* 20 */
        return this.divisionId;
        /*    */
    }

    public Integer getDistrictId() {
        /* 22 */
        return this.districtId;
        /*    */
    }

    public String getNameEnglish() {
        /* 24 */
        return this.nameEnglish;
        /*    */
    }

    public String getNameBangla() {
        /* 26 */
        return this.nameBangla;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\Upazila.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */