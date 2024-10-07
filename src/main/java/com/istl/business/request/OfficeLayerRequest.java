/*    */
package com.istl.business.request;

import lombok.Builder;

import java.io.Serializable;

/*    */
@Builder
/*    */ public class OfficeLayerRequest implements Serializable {
    /*    */   private Integer id;
    /*    */   private Integer parent;
    /*    */   private String ministry;
    /*    */   private String name;

    /*    */
    /*  9 */
    public void setId(Integer id) {
        this.id = id;
    }

    private Integer level;
    private String nameBn;
    private Integer status;
    private Integer sequence;

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public void setMinistry(String ministry) {
        this.ministry = ministry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /*    */
    /*    */
    public OfficeLayerRequest() {
    }

    /* 12 */
    public static OfficeLayerRequestBuilder builder() {
        return new OfficeLayerRequestBuilder();
    }

    public OfficeLayerRequest(Integer id, Integer parent, String ministry, String name, Integer level, String nameBn, Integer status, Integer sequence) {
        /* 13 */
        this.id = id;
        this.parent = parent;
        this.ministry = ministry;
        this.name = name;
        this.level = level;
        this.nameBn = nameBn;
        this.status = status;
        this.sequence = sequence;
        /*    */
    }

    /* 15 */
    public Integer getId() {
        return this.id;
    }

    /* 16 */
    public Integer getParent() {
        return this.parent;
    }

    /* 17 */
    public String getMinistry() {
        return this.ministry;
    }

    /* 18 */
    public String getName() {
        return this.name;
    }

    /* 19 */
    public Integer getLevel() {
        return this.level;
    }

    /* 20 */
    public String getNameBn() {
        return this.nameBn;
    }

    /* 21 */
    public Integer getStatus() {
        return this.status;
    }

    public Integer getSequence() {
        /* 22 */
        return this.sequence;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\OfficeLayerRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */