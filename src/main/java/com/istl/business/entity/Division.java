/*    */
package com.istl.business.entity;

/*    */
/*    */ import java.io.Serializable;

/*    */
/*    */ public class Division implements Serializable {
    /*    */   private Integer id;
    /*    */   private String name;
    /*    */   private String nameBn;
    /*    */   private String bbsCode;

    /*    */
    /*    */
    public void setId(Integer id) {
        /* 12 */
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public void setBbsCode(String bbsCode) {
        this.bbsCode = bbsCode;
    }

    /*    */
    /*    */
    /*    */
    public Integer getId() {
        /* 16 */
        return this.id;
        /* 17 */
    }

    public String getName() {
        return this.name;
    }

    /* 18 */
    public String getNameBn() {
        return this.nameBn;
    }

    public String getBbsCode() {
        /* 19 */
        return this.bbsCode;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\Division.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */