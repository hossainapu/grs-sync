/*    */
package com.istl.business.entity;

import com.istl.business.response.v2.OfficeUnitDesignationMapResponse;

import java.io.Serializable;
import java.util.Map;

/*    */
/*    */ public class OfficeUnit implements Serializable {
    /*    */   private Integer id;
    /*    */   private Integer parent;
    /*    */   private Integer sarok;
    /*    */   private Integer level;
    /*    */   private String name;
    /*    */   private String nameBn;
    /*    */   private Integer office;
    private Map<String, OfficeOrganogram> designations;

    /*    */
    /* 12 */
    public void setId(Integer id) {
        this.id = id;
    }

    private Integer ministry;
    private Integer layer;
    private String phone;
    private String nothi;
    private Integer officeoriginunitid;
    private String category;
    private String fax;
    private String email;

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public void setSarok(Integer sarok) {
        this.sarok = sarok;
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

    public void setOffice(Integer office) {
        this.office = office;
    }

    public void setMinistry(Integer ministry) {
        this.ministry = ministry;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNothi(String nothi) {
        this.nothi = nothi;
    }

    public void setOfficeoriginunitid(Integer officeoriginunitid) {
        this.officeoriginunitid = officeoriginunitid;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*    */
    /*    */
    /*    */
    public Integer getId() {
        /* 16 */
        return this.id;
        /* 17 */
    }

    public Integer getParent() {
        return this.parent;
    }

    /* 18 */
    public Integer getSarok() {
        return this.sarok;
    }

    /* 19 */
    public Integer getLevel() {
        return this.level;
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
    public Integer getOffice() {
        return this.office;
    }

    /* 23 */
    public Integer getMinistry() {
        return this.ministry;
    }

    /* 24 */
    public Integer getLayer() {
        return this.layer;
    }

    /* 25 */
    public String getPhone() {
        return this.phone;
    }

    /* 26 */
    public String getNothi() {
        return this.nothi;
    }

    /* 27 */
    public Integer getOfficeoriginunitid() {
        return this.officeoriginunitid;
    }

    /* 28 */
    public String getCategory() {
        return this.category;
    }

    /* 29 */
    public String getFax() {
        return this.fax;
    }

    public String getEmail() {
        /* 30 */
        return this.email;
        /*    */
    }

    public Map<String, OfficeOrganogram> getDesignations() {
        return designations;
    }

    public void setDesignations(Map<String, OfficeOrganogram> designations) {
        this.designations = designations;
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\OfficeUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */