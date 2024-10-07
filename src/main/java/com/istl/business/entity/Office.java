/*    */
package com.istl.business.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Builder
@NoArgsConstructor
@AllArgsConstructor
/*    */ public class Office implements Serializable {
    private Integer id;
    private String name;
    private String nameBn;
    private String code;
    /*    */   private Integer division;
    /*    */   private Integer district;
    /*    */   private Integer upazila;
    /*    */   private String phone;
    /*    */   private String mobile;

    /*    */
    /*  9 */
    public void setId(Integer id) {
        this.id = id;
    }

    private String digitalNothiCode;
    private String fax;
    private String email;
    private String website;
    private Integer ministry;
    private Integer layer;
    private Integer origin;
    private Integer customLayer;
    private Integer parentOfficeId;

    private Map<String, OfficeUnit> units;

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public void setUpazila(Integer upazila) {
        this.upazila = upazila;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setDigitalNothiCode(String digitalNothiCode) {
        this.digitalNothiCode = digitalNothiCode;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setMinistry(Integer ministry) {
        this.ministry = ministry;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public void setCustomLayer(Integer customLayer) {
        this.customLayer = customLayer;
    }

    public void setParentOfficeId(Integer parentOfficeId) {
        this.parentOfficeId = parentOfficeId;
    }

    /*    */
    /*    */

    /* 12 */

    public static OfficeBuilder builder() {
        /* 13 */
        return new OfficeBuilder();
        /*    */
    }

    /* 15 */
    public Integer getId() {
        return this.id;
    }

    /* 16 */
    public String getName() {
        return this.name;
    }

    /* 17 */
    public String getNameBn() {
        return this.nameBn;
    }

    /* 18 */
    public String getCode() {
        return this.code;
    }

    /* 19 */
    public Integer getDivision() {
        return this.division;
    }

    /* 20 */
    public Integer getDistrict() {
        return this.district;
    }

    /* 21 */
    public Integer getUpazila() {
        return this.upazila;
    }

    /* 22 */
    public String getPhone() {
        return this.phone;
    }

    /* 23 */
    public String getMobile() {
        return this.mobile;
    }

    /* 24 */
    public String getDigitalNothiCode() {
        return this.digitalNothiCode;
    }

    /* 25 */
    public String getFax() {
        return this.fax;
    }

    /* 26 */
    public String getEmail() {
        return this.email;
    }

    /* 27 */
    public String getWebsite() {
        return this.website;
    }

    /* 28 */
    public Integer getMinistry() {
        return this.ministry;
    }

    /* 29 */
    public Integer getLayer() {
        return this.layer;
    }

    /* 30 */
    public Integer getOrigin() {
        return this.origin;
    }

    /* 31 */
    public Integer getCustomLayer() {
        return this.customLayer;
    }

    public Integer getParentOfficeId() {
        /* 32 */
        return this.parentOfficeId;
        /*    */
    }

    public Map<String, OfficeUnit> getUnits() {
        return units;
    }

    public void setUnits(Map<String, OfficeUnit> units) {
        this.units = units;
    }
}