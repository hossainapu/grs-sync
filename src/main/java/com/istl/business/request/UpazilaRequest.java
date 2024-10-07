/*    */
package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

/*    */
/*    */
@Builder
/*    */ public class UpazilaRequest implements Serializable {
    /*    */   private Integer id;
    /*    */   private Integer division;
    /*    */   private Integer district;

    /*    */
    /*  9 */
    public void setId(Integer id) {
        this.id = id;
    }

    private String bbsCode;
    private String name;
    private String nameBn;
    private Integer status;

    public void setDivision(Integer division) {
        this.division = division;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public void setBbsCode(String bbsCode) {
        this.bbsCode = bbsCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /*    */
    /*    */
    public UpazilaRequest() {
    }

    /* 12 */
    public UpazilaRequest(Integer id, Integer division, Integer district, String bbsCode, String name, String nameBn, Integer status) {
        this.id = id;
        this.division = division;
        this.district = district;
        this.bbsCode = bbsCode;
        this.name = name;
        this.nameBn = nameBn;
        this.status = status;
    }

    public static UpazilaRequestBuilder builder() {
        /* 13 */
        return new UpazilaRequestBuilder();
        /*    */
    }

    /* 15 */
    public Integer getId() {
        return this.id;
    }

    /* 16 */
    public Integer getDivision() {
        return this.division;
    }

    /* 17 */
    public Integer getDistrict() {
        return this.district;
    }

    /* 18 */
    public String getBbsCode() {
        return this.bbsCode;
    }

    /* 19 */
    public String getName() {
        return this.name;
    }

    /* 20 */
    public String getNameBn() {
        return this.nameBn;
    }

    public Integer getStatus() {
        /* 21 */
        return this.status;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\UpazilaRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */