/*    */
package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

/*    */
@Builder
/*    */ public class DistrictRequest implements Serializable {
    /*    */ Integer id;
    /*    */ String name;
    /*    */ String nameBn;
    /*    */ String bbsCode;
    /*    */ Integer status;
    /*    */ Integer division;

    /*    */
    /* 11 */
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setBbsCode(String bbsCode) {
        this.bbsCode = bbsCode;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public DistrictRequest(Integer id, String name, String nameBn, String bbsCode, Integer status, Integer division) {
        /* 12 */
        this.id = id;
        this.name = name;
        this.nameBn = nameBn;
        this.bbsCode = bbsCode;
        this.status = status;
        this.division = division;
        /*    */
    }

    public DistrictRequest() {
    }

    public static DistrictRequestBuilder builder() {
        /* 14 */
        return new DistrictRequestBuilder();
        /*    */
    }

    /* 16 */
    public Integer getId() {
        return this.id;
    }

    /* 17 */
    public String getName() {
        return this.name;
    }

    /* 18 */
    public String getNameBn() {
        return this.nameBn;
    }

    /* 19 */
    public String getBbsCode() {
        return this.bbsCode;
    }

    /* 20 */
    public Integer getStatus() {
        return this.status;
    }

    public Integer getDivision() {
        /* 21 */
        return this.division;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\DistrictRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */