/*    */
package com.istl.business.request

        ;
/*    */
/*    */

import lombok.Builder;

import java.io.Serializable;

/*    */
@Builder
/*    */ public class DivisionRequest implements Serializable {
    /*    */   private Integer id;
    /*    */   private String name;

    /*    */
    /*  9 */
    public void setId(Integer id) {
        this.id = id;
    }

    private String nameBn;
    private String bbsCode;
    private Integer status;

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

    /*    */
    /*    */
    public DivisionRequest() {
    }

    /* 12 */
    public static DivisionRequestBuilder builder() {
        return new DivisionRequestBuilder();
    }

    public DivisionRequest(Integer id, String name, String nameBn, String bbsCode, Integer status) {
        /* 13 */
        this.id = id;
        this.name = name;
        this.nameBn = nameBn;
        this.bbsCode = bbsCode;
        this.status = status;
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
    public String getBbsCode() {
        return this.bbsCode;
    }

    public Integer getStatus() {
        /* 19 */
        return this.status;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\DivisionRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */