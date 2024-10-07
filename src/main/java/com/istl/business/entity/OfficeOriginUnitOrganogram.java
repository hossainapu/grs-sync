/*    */
package com.istl.business.entity;
/*    */
/*    */

import java.io.Serializable;

/*    */
/*    */ public class OfficeOriginUnitOrganogram implements Serializable {
    /*    */   private Long id;
    /*    */   private Long originUnit;
    /*    */   private Integer superiorUnit;
    /*    */   private String superiorDesignation;
    /*    */   private String name;

    /*    */
    /* 12 */
    public void setId(Long id) {
        this.id = id;
    }

    private String nameBn;
    private String shortName;
    private String shortNameBn;
    private Integer level;
    private Integer sequence;

    public void setOriginUnit(Long originUnit) {
        this.originUnit = originUnit;
    }

    public void setSuperiorUnit(Integer superiorUnit) {
        this.superiorUnit = superiorUnit;
    }

    public void setSuperiorDesignation(String superiorDesignation) {
        this.superiorDesignation = superiorDesignation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setShortNameBn(String shortNameBn) {
        this.shortNameBn = shortNameBn;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 16 */
        return this.id;
        /* 17 */
    }

    public Long getOriginUnit() {
        return this.originUnit;
    }

    /* 18 */
    public Integer getSuperiorUnit() {
        return this.superiorUnit;
    }

    /* 19 */
    public String getSuperiorDesignation() {
        return this.superiorDesignation;
    }

    /* 20 */
    public String getName() {
        return this.name;
    }

    /* 21 */
    public String getNameBn() {
        return this.nameBn;
    }

    /* 22 */
    public String getShortName() {
        return this.shortName;
    }

    /* 23 */
    public String getShortNameBn() {
        return this.shortNameBn;
    }

    /* 24 */
    public Integer getLevel() {
        return this.level;
    }

    public Integer getSequence() {
        /* 25 */
        return this.sequence;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\OfficeOriginUnitOrganogram.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */