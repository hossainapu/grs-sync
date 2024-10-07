/*    */
package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
/*    */ public class OfficeUnitOrganoganogramRequest implements Serializable {
    private Integer office;
    /*    */   private Integer unit;
    /*    */   private Integer superiorUnit;
    /*    */   private String superiorDesignation;
    /*    */   private String name;
    /*    */   private String nameBn;

    /*    */
    /*  9 */
    public void setOffice(Integer office) {
        this.office = office;
    }

    private String shortName;
    private String shortNameBn;
    private Integer designationLevel;
    private Integer designationSequence;
    private String description;
    private Integer refOrigin;
    private Integer status;

    public void setUnit(Integer unit) {
        this.unit = unit;
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

    public void setDesignationLevel(Integer designationLevel) {
        this.designationLevel = designationLevel;
    }

    public void setDesignationSequence(Integer designationSequence) {
        this.designationSequence = designationSequence;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRefOrigin(Integer refOrigin) {
        this.refOrigin = refOrigin;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /*    */
    public OfficeUnitOrganoganogramRequest() {
    }

    /* 11 */
    public OfficeUnitOrganoganogramRequest(Integer office, Integer unit, Integer superiorUnit, String superiorDesignation, String name, String nameBn, String shortName, String shortNameBn, Integer designationLevel, Integer designationSequence, String description, Integer refOrigin, Integer status) {
        this.office = office;
        this.unit = unit;
        this.superiorUnit = superiorUnit;
        this.superiorDesignation = superiorDesignation;
        this.name = name;
        this.nameBn = nameBn;
        this.shortName = shortName;
        this.shortNameBn = shortNameBn;
        this.designationLevel = designationLevel;
        this.designationSequence = designationSequence;
        this.description = description;
        this.refOrigin = refOrigin;
        this.status = status;
    }

    public static OfficeUnitOrganoganogramRequestBuilder builder() {
        /* 12 */
        return new OfficeUnitOrganoganogramRequestBuilder();
        /*    */
    }

    /*    */
    /* 15 */
    public Integer getOffice() {
        return this.office;
    }

    /* 16 */
    public Integer getUnit() {
        return this.unit;
    }

    /* 17 */
    public Integer getSuperiorUnit() {
        return this.superiorUnit;
    }

    /* 18 */
    public String getSuperiorDesignation() {
        return this.superiorDesignation;
    }

    /* 19 */
    public String getName() {
        return this.name;
    }

    /* 20 */
    public String getNameBn() {
        return this.nameBn;
    }

    /* 21 */
    public String getShortName() {
        return this.shortName;
    }

    /* 22 */
    public String getShortNameBn() {
        return this.shortNameBn;
    }

    /* 23 */
    public Integer getDesignationLevel() {
        return this.designationLevel;
    }

    /* 24 */
    public Integer getDesignationSequence() {
        return this.designationSequence;
    }

    /* 25 */
    public String getDescription() {
        return this.description;
    }

    /* 26 */
    public Integer getRefOrigin() {
        return this.refOrigin;
    }

    public Integer getStatus() {
        /* 27 */
        return this.status;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\OfficeUnitOrganoganogramRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */