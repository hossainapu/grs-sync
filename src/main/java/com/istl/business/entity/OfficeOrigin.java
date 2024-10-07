/*    */
package com.istl.business.entity;
/*    */
/*    */

import java.io.Serializable;

/*    */
/*    */ public class OfficeOrigin implements Serializable {
    /*    */   private Integer id;
    /*    */   private Integer ministry;
    /*    */   private Integer layer;
    /*    */   private String name;

    /*    */
    /*    */
    public void setId(Integer id) {
        /* 12 */
        this.id = id;
    }

    private String nameBn;
    private Integer level;
    private Integer sequence;
    private Integer parent;

    public void setMinistry(Integer ministry) {
        this.ministry = ministry;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    /*    */
    /*    */
    /*    */
    public Integer getId() {
        /* 16 */
        return this.id;
        /* 17 */
    }

    public Integer getMinistry() {
        return this.ministry;
    }

    /* 18 */
    public Integer getLayer() {
        return this.layer;
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
    public Integer getLevel() {
        return this.level;
    }

    /* 22 */
    public Integer getSequence() {
        return this.sequence;
    }

    public Integer getParent() {
        /* 23 */
        return this.parent;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\OfficeOrigin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */