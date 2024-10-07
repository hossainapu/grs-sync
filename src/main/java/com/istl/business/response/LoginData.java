/*    */
package com.istl.business.response;
/*    */
/*    */

import java.io.Serializable;

/*    */
/*    */ public class LoginData implements Serializable {
    /*    */ String token;

    /*    */
    /*    */
    public void setToken(String token) {
        /*  9 */
        this.token = token;
    }

    public LoginData(String token) {
        /* 10 */
        this.token = token;
        /*    */
    }

    public LoginData() {
    }

    /*    */
    public String getToken() {
        /* 13 */
        return this.token;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\response\LoginData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */