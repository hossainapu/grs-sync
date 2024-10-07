/*    */
package com.istl.business.entity;

import lombok.Builder;

/*    */
@Builder
/*    */ public class CustomOfficeLayer {
    /*    */   private Long id;
    /*    */   private String name;
    /*    */   private Integer layer_level;

    /*    */
    /*  8 */
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLayer_level(Integer layer_level) {
        this.layer_level = layer_level;
    }

    public String toString() {
        return "CustomOfficeLayer(id=" + getId() + ", name=" + getName() + ", layer_level=" + getLayer_level() + ")";
    }

    public CustomOfficeLayer(Long id, String name, Integer layer_level) {
        /*  9 */
        this.id = id;
        this.name = name;
        this.layer_level = layer_level;
        /*    */
    }

    public CustomOfficeLayer() {
    }

    public static CustomOfficeLayerBuilder builder() {
        /* 11 */
        return new CustomOfficeLayerBuilder();
        /*    */
    }

    /*    */
    /* 14 */
    public Long getId() {
        return this.id;
    }

    /* 15 */
    public String getName() {
        return this.name;
    }

    public Integer getLayer_level() {
        /* 16 */
        return this.layer_level;
        /*    */
    }
    /*    */
}