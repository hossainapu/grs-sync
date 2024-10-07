/*    */
package com.istl.business.entity;

import java.io.Serializable;

/*    */
/*    */
/*    */ public class OfficeUnitOrganogram implements Serializable {
    /*    */   private Integer id;
    /*    */   private Integer originUnit;
    /*    */   private Integer sequence;
    /*    */   private Integer superiorUnit;
    /*    */   private Integer superiorDesignation;
    /*    */   private Integer level;

    /*    */
    /* 12 */
    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private String nameBn;
    private String shortNameBn;
    private String shortName;
    private Integer refOrigin;
    private Integer officeId;
    private Integer officeUnitId;

    public void setOriginUnit(Integer originUnit) {
        this.originUnit = originUnit;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public void setSuperiorUnit(Integer superiorUnit) {
        this.superiorUnit = superiorUnit;
    }

    public void setSuperiorDesignation(Integer superiorDesignation) {
        this.superiorDesignation = superiorDesignation;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setShortNameBn(String shortNameBn) {
        this.shortNameBn = shortNameBn;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setRefOrigin(Integer refOrigin) {
        this.refOrigin = refOrigin;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public void setOfficeUnitId(Integer officeUnitId) {
        this.officeUnitId = officeUnitId;
    }

    /*    */
    /*    */
    /*    */
    public Integer getId() {
        /* 16 */
        return this.id;
        /* 17 */
    }

    public Integer getOriginUnit() {
        return this.originUnit;
    }

    /* 18 */
    public Integer getSequence() {
        return this.sequence;
    }

    /* 19 */
    public Integer getSuperiorUnit() {
        return this.superiorUnit;
    }

    /* 20 */
    public Integer getSuperiorDesignation() {
        return this.superiorDesignation;
    }

    /* 21 */
    public Integer getLevel() {
        return this.level;
    }

    /* 22 */
    public String getName() {
        return this.name;
    }

    /* 23 */
    public String getNameBn() {
        return this.nameBn;
    }

    /* 24 */
    public String getShortNameBn() {
        return this.shortNameBn;
    }

    /* 25 */
    public String getShortName() {
        return this.shortName;
    }

    /* 26 */
    public Integer getRefOrigin() {
        return this.refOrigin;
    }

    /* 27 */
    public Integer getOfficeId() {
        return this.officeId;
    }

    public Integer getOfficeUnitId() {
        /* 28 */
        return this.officeUnitId;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\OfficeUnitOrganogram.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */