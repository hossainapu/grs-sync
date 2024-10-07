/*    */
package com.istl.business.entity;
/*    */
/*    */

import java.io.Serializable;

/*    */
/*    */ public class OfficeOriginUnit implements Serializable {
    /*    */   private Integer id;
    /*    */   private Integer parent;
    /*    */   private Integer level;
    /*    */   private String nameBn;

    /*    */
    /*    */
    public void setId(Integer id) {
        /* 12 */
        this.id = id;
    }

    private String name;
    private Integer officeOrigin;
    private Integer ministry;
    private Integer layer;
    private Integer status;

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOfficeOrigin(Integer officeOrigin) {
        this.officeOrigin = officeOrigin;
    }

    public void setMinistry(Integer ministry) {
        this.ministry = ministry;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
    public Integer getLevel() {
        return this.level;
    }

    /* 19 */
    public String getNameBn() {
        return this.nameBn;
    }

    /* 20 */
    public String getName() {
        return this.name;
    }

    /* 21 */
    public Integer getOfficeOrigin() {
        return this.officeOrigin;
    }

    /* 22 */
    public Integer getMinistry() {
        return this.ministry;
    }

    /* 23 */
    public Integer getLayer() {
        return this.layer;
    }

    public Integer getStatus() {
        /* 24 */
        return this.status;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\OfficeOriginUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */