/*    */
package com.istl.business.entity;

import java.io.Serializable;

/*    */
/*    */ public class Municipality implements Serializable {
    /*    */   private Integer id;
    /*    */   private Integer division;
    /*    */   private Integer district;
    /*    */   private Integer upazila;
    /*    */   private String name;
    /*    */   private String nameBn;
    /*    */   private String bbsCode;

    /*    */
    /* 12 */
    public void setId(Integer id) {
        this.id = id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setBbsCode(String bbsCode) {
        this.bbsCode = bbsCode;
    }

    /*    */
    /*    */
    /*    */
    public Integer getId() {
        /* 16 */
        return this.id;
        /* 17 */
    }

    public Integer getDivision() {
        return this.division;
    }

    /* 18 */
    public Integer getDistrict() {
        return this.district;
    }

    /* 19 */
    public Integer getUpazila() {
        return this.upazila;
    }

    /* 20 */
    public String getName() {
        return this.name;
    }

    /* 21 */
    public String getNameBn() {
        return this.nameBn;
    }

    public String getBbsCode() {
        /* 22 */
        return this.bbsCode;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\Municipality.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */