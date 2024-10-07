/*    */
package com.istl.business.request.v2;
/*    */
/*    */

import lombok.Builder;

import java.io.Serializable;

/*    */
@Builder
/*    */ public class OfficeUnitDesignationMapRequest
        /*    */ implements Serializable
        /*    */ {
    /*    */ String office_id;

    /*    */
    /*    */
    public void setOffice_id(String office_id) {
        /* 11 */
        this.office_id = office_id;
    }





    public OfficeUnitDesignationMapRequest(String office_id) {
        /* 12 */
        this.office_id = office_id;
        /*    */
    }

    public OfficeUnitDesignationMapRequest() {
    }

    public static OfficeUnitDesignationMapRequestBuilder builder() {
        /* 14 */
        return new OfficeUnitDesignationMapRequestBuilder();
        /*    */
    }

    public String getOffice_id() {
        /* 16 */
        return this.office_id;
        /*    */
    }
    /*    */
}