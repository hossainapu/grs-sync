/*    */
package com.istl.business.response.v2;
/*    */
/*    */

import java.io.Serializable;

/*    */
/*    */
/*    */ public class ServiceResponse
        /*    */ implements Serializable
        /*    */ {
    /*    */
    public void setStatus(String status) {
        /* 10 */
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ServiceResponse(String status, String message) {
        /* 11 */
        this.status = status;
        this.message = message;
        /*    */
    }

    /*    */
    /* 14 */   private String status = "true";
    private String message;

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        /* 15 */
        return this.message;
        /*    */
    }

    /*    */
    /*    */
    public ServiceResponse() {
        /* 19 */
        this.status = "true";
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\response\v2\ServiceResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */