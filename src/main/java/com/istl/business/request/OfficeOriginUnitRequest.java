/*    */
package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
/*    */ public class OfficeOriginUnitRequest implements Serializable {
    /*    */   private Integer id;
    /*    */   private String name;
    /*    */   private String nameBn;
    /*    */   private Integer bbsCode;
    /*    */   private Integer status;

    /*    */
    /*  9 */
    public void setId(Integer id) {
        this.id = id;
    }

    private Integer division;
    private Integer district;
    private Integer officeOrigin;
    private Integer ministry;
    private Integer level;
    private Integer layer;

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setBbsCode(Integer bbsCode) {
        this.bbsCode = bbsCode;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public void setOfficeOrigin(Integer officeOrigin) {
        this.officeOrigin = officeOrigin;
    }

    public void setMinistry(Integer ministry) {
        this.ministry = ministry;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    /*    */
    /* 11 */
    public OfficeOriginUnitRequest(Integer id, String name, String nameBn, Integer bbsCode, Integer status, Integer division, Integer district, Integer officeOrigin, Integer ministry, Integer level, Integer layer) {
        this.id = id;
        this.name = name;
        this.nameBn = nameBn;
        this.bbsCode = bbsCode;
        this.status = status;
        this.division = division;
        this.district = district;
        this.officeOrigin = officeOrigin;
        this.ministry = ministry;
        this.level = level;
        this.layer = layer;
    }

    public static OfficeOriginUnitRequestBuilder builder() {
        /* 12 */
        return new OfficeOriginUnitRequestBuilder();
        /*    */
    }

    /*    */
    public OfficeOriginUnitRequest() {
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
    public Integer getBbsCode() {
        return this.bbsCode;
    }

    /* 19 */
    public Integer getStatus() {
        return this.status;
    }

    /* 20 */
    public Integer getDivision() {
        return this.division;
    }

    /* 21 */
    public Integer getDistrict() {
        return this.district;
    }

    /* 22 */
    public Integer getOfficeOrigin() {
        return this.officeOrigin;
    }

    /* 23 */
    public Integer getMinistry() {
        return this.ministry;
    }

    /* 24 */
    public Integer getLevel() {
        return this.level;
    }

    public Integer getLayer() {
        /* 25 */
        return this.layer;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\OfficeOriginUnitRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */