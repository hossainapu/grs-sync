/*    */
package com.istl.business.request;

import lombok.Builder;

@Builder
public class CustomOfficeLayerRequest {
    /*    */   private String layer_levels;

    /*    */
    /*    */
    public CustomOfficeLayerRequest() {
    }

    /*    */
    /*    */
    public void setLayer_levels(String layer_levels) {
        /*  7 */
        this.layer_levels = layer_levels;
        /*    */
    }

    /*    */
    public static CustomOfficeLayerRequestBuilder builder() {
        /* 10 */
        return new CustomOfficeLayerRequestBuilder();
    }

    public CustomOfficeLayerRequest(String layer_levels) {
        /* 11 */
        this.layer_levels = layer_levels;
        /*    */
    }

    /*    */
    /*    */
    public String getLayer_levels() {
        /* 15 */
        return this.layer_levels;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\request\CustomOfficeLayerRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */