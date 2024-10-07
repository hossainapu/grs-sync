/*    */
package com.istl.database.entity;

/*    */
/*    */

import lombok.Builder;

import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;

/*    */
/*    */
@Entity
/*    */
@Table(name = "office_custom_layers")
@Builder
/*    */ public class CustomOfficeLayer {
    /*    */
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private Long id;

    /*    */
    /* 15 */
    public CustomOfficeLayer(Long id, String name, Integer layerLevel) {
        this.id = id;
        this.name = name;
        this.layerLevel = layerLevel;
    }

    @Column(name = "name")
    /*    */ private String name;
    @Column(name = "layer_level")
    /* 17 */ private Integer layerLevel;

    public CustomOfficeLayer() {
    }

    public static CustomOfficeLayerBuilder builder() {
        return new CustomOfficeLayerBuilder();
    }

    /* 18 */
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLayerLevel(Integer layerLevel) {
        this.layerLevel = layerLevel;
    }

    public Long getId() {
        /* 24 */
        return this.id;
        /*    */
    }

    public String getName() {
        /* 26 */
        return this.name;
        /*    */
    }

    public Integer getLayerLevel() {
        /* 28 */
        return this.layerLevel;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\CustomOfficeLayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */