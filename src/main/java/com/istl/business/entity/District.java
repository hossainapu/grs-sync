/*    */
package com.istl.business.entity;

/*    */
/*    */

import lombok.Builder;

import java.io.Serializable;

/*    */
@Builder
/*    */ public class District implements Serializable {
    /*    */   private Integer id;
    /*    */   private String name;
    /*    */   private String nameBn;

    /*    */
    /* 10 */
    public void setId(Integer id) {
        this.id = id;
    }

    private String bbsCode;
    private String divisionBbsCode;
    private Integer division;

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setBbsCode(String bbsCode) {
        this.bbsCode = bbsCode;
    }

    public void setDivisionBbsCode(String divisionBbsCode) {
        this.divisionBbsCode = divisionBbsCode;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    /*    */
    /*    */
    public District() {
    }

    /* 13 */
    public static DistrictBuilder builder() {
        return new DistrictBuilder();
    }

    public District(Integer id, String name, String nameBn, String bbsCode, String divisionBbsCode, Integer division) {
        /* 14 */
        this.id = id;
        this.name = name;
        this.nameBn = nameBn;
        this.bbsCode = bbsCode;
        this.divisionBbsCode = divisionBbsCode;
        this.division = division;
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
    public String getDivisionBbsCode() {
        return this.divisionBbsCode;
    }

    public Integer getDivision() {
        /* 21 */
        return this.division;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\District.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */