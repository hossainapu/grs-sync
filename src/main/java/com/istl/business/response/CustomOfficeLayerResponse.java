/*    */
package com.istl.business.response;
/*    */
/*    */

import com.istl.business.entity.CustomOfficeLayer;
/*    */
import lombok.Builder;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;

/*    */
@Builder
/*    */ public class CustomOfficeLayerResponse
        /*    */ extends ServiceResponse implements Serializable {
    /*    */ List<CustomOfficeLayer> data;

    /*    */
    /*    */
    public void setData(List<CustomOfficeLayer> data) {
        /* 13 */
        this.data = data;
    }

    public String toString() {
        return "CustomOfficeLayerResponse(data=" + getData() + ")";
    }

    public CustomOfficeLayerResponse(List<CustomOfficeLayer> data) {
        /* 14 */
        this.data = data;
        /*    */
    }

    public CustomOfficeLayerResponse() {
    }

    public static CustomOfficeLayerResponseBuilder builder() {
        /* 16 */
        return new CustomOfficeLayerResponseBuilder();
        /*    */
    }

    public List<CustomOfficeLayer> getData() {
        /* 18 */
        return this.data;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\response\CustomOfficeLayerResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */