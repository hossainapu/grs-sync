/*    */
package com.istl.business.response;
/*    */
/*    */

import lombok.Builder;

import java.io.Serializable;

/*    */
@Builder
/*    */ public class LoginResponse extends ServiceResponse implements Serializable {
    /*    */ LoginData data;

    /*    */
    /*  8 */
    public void setData(LoginData data) {
        this.data = data;
    }

    public LoginResponse(LoginData data) {
        /*  9 */
        this.data = data;
        /*    */
    }

    public static LoginResponseBuilder builder() {
        /* 11 */
        return new LoginResponseBuilder();
        /*    */
    }

    public LoginResponse() {
    }

    /*    */
    public LoginData getData() {
        /* 14 */
        return this.data;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\response\LoginResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */