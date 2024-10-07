/*    */
package com.istl.business.response;
/*    */
/*    */

import lombok.Builder;

import java.io.Serializable;

/*    */
/*    */
/*    */
//@Builder
/*    */ public class ServiceResponse
        /*    */ implements Serializable
        /*    */ {
    /*    */
    public void setStatus(String status) {
        /* 11 */
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ServiceResponse(String status, String message) {
        /* 12 */
        this.status = status;
        this.message = message;
        /*    */
    }

    /*    */
    /* 15 */   private String status = "true";
    private String message;

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        /* 16 */
        return this.message;
        /*    */
    }

    /*    */
    /*    */
    public ServiceResponse() {
        /* 20 */
        this.status = "true";
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\response\ServiceResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */