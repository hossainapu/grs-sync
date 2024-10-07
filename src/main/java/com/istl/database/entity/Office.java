/*    */
package com.istl.database.entity;

import lombok.Builder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "offices")
@Builder
public class Office {
    @Id
    @Column(name = "id")
    /*    */ private Long id;
    @Column(name = "office_ministry_id")
    /*    */ private Long officeMinistryId;
    @Column(name = "office_layer_id")
    /*    */ private Long officeLayerId;
    @Column(name = "parent_office_id")
    /*    */ private Long parentOfficeId;
    @NotNull
    /*    */
    @Column(name = "office_name_eng")
    /*    */ private String nameEnglish;
    @NotNull
    /*    */
    @Column(name = "office_name_bng")
    /*  9 */ private String nameBangla;

    public Office(Long id, Long officeMinistryId, Long officeLayerId, Long parentOfficeId, @NotNull String nameEnglish, @NotNull String nameBangla, Integer districtId, Integer divisionId, Integer upazilaId, String websiteUrl, Long officeOriginId, Boolean status) {
        this.id = id;
        this.officeMinistryId = officeMinistryId;
        this.officeLayerId = officeLayerId;
        this.parentOfficeId = parentOfficeId;
        this.nameEnglish = nameEnglish;
        this.nameBangla = nameBangla;
        this.districtId = districtId;
        this.divisionId = divisionId;
        this.upazilaId = upazilaId;
        this.websiteUrl = websiteUrl;
        this.officeOriginId = officeOriginId;
        this.status = status;
    }

    @Column(name = "geo_district_id")
    private Integer districtId;
    @Column(name = "geo_division_id")
    private Integer divisionId;
    @Column(name = "geo_upazila_id")
    private Integer upazilaId;
    @Column(name = "office_web")
    /*    */ private String websiteUrl;
    @Column(name = "office_origin_id")
    /*    */ private Long officeOriginId;
    @Column(name = "status")
    /* 12 */ private Boolean status;

    public Office() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOfficeMinistryId(Long officeMinistryId) {
        this.officeMinistryId = officeMinistryId;
    }

    public void setOfficeLayerId(Long officeLayerId) {
        this.officeLayerId = officeLayerId;
    }

    public void setParentOfficeId(Long parentOfficeId) {
        this.parentOfficeId = parentOfficeId;
    }

    public void setNameEnglish(@NotNull String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public void setNameBangla(@NotNull String nameBangla) {
        this.nameBangla = nameBangla;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public void setUpazilaId(Integer upazilaId) {
        this.upazilaId = upazilaId;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setOfficeOriginId(Long officeOriginId) {
        this.officeOriginId = officeOriginId;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public static OfficeBuilder builder() {
        /* 13 */
        return new OfficeBuilder();
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
    public Long getOfficeMinistryId() {
        /* 21 */
        return this.officeMinistryId;
        /*    */
    }

    /*    */
    public Long getOfficeLayerId() {
        /* 24 */
        return this.officeLayerId;
        /*    */
    }

    /*    */
    public Long getParentOfficeId() {
        /* 27 */
        return this.parentOfficeId;
        /*    */
    }

    /*    */
    @NotNull
    /*    */ public String getNameEnglish() {
        /* 31 */
        return this.nameEnglish;
        /*    */
    }

    /*    */
    @NotNull
    /*    */ public String getNameBangla() {
        /* 35 */
        return this.nameBangla;
        /*    */
    }

    /*    */
    public Integer getDistrictId() {
        /* 38 */
        return this.districtId;
        /*    */
    }

    /*    */
    public Integer getDivisionId() {
        /* 41 */
        return this.divisionId;
        /*    */
    }

    /*    */
    public Integer getUpazilaId() {
        /* 44 */
        return this.upazilaId;
        /*    */
    }

    /*    */
    public String getWebsiteUrl() {
        /* 47 */
        return this.websiteUrl;
        /*    */
    }

    /*    */
    public Long getOfficeOriginId() {
        /* 50 */
        return this.officeOriginId;
        /*    */
    }

    /*    */
    public Boolean getStatus() {
        /* 53 */
        return this.status;
        /*    */
    }


}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\Office.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */