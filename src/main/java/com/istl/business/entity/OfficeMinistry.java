/*    */
package com.istl.business.entity;

import lombok.Builder;

import java.io.Serializable;

/*    */
/*    */
@Builder
/*    */ public class OfficeMinistry implements Serializable {
    /*    */   private Long id;
    /*    */   private Integer type;
    /*    */   private String reference;
    /*    */   private String name;
    /*    */   private String nameShort;
    /*    */   private String nameBn;
    /*    */   private Boolean status;

    /*    */
    /* 13 */
    public void setId(Long id) {
        this.id = id;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    /*    */
    /*    */
    public OfficeMinistry() {
    }

    /* 16 */
    public static OfficeMinistryBuilder builder() {
        return new OfficeMinistryBuilder();
    }

    public OfficeMinistry(Long id, Integer type, String reference, String name, String nameShort, String nameBn, Boolean status) {
        /* 17 */
        this.id = id;
        this.type = type;
        this.reference = reference;
        this.name = name;
        this.nameShort = nameShort;
        this.nameBn = nameBn;
        this.status = status;
        /*    */
    }

    /*    */
    /* 20 */
    public Long getId() {
        return this.id;
    }

    /* 21 */
    public Integer getType() {
        return this.type;
    }

    /* 22 */
    public String getReference() {
        return this.reference;
    }

    /* 23 */
    public String getName() {
        return this.name;
    }

    /* 24 */
    public String getNameShort() {
        return this.nameShort;
    }

    /* 25 */
    public String getNameBn() {
        return this.nameBn;
    }

    public Boolean getStatus() {
        /* 26 */
        return this.status;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\OfficeMinistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */