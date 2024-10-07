/*    */
package com.istl.database.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*    */
@Entity
/*    */
@Table(name = "geo_divisions")
@Builder
/*    */ public class Division {
    /*    */
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private int id;

    /*    */
    /*  9 */
    public Division(int id, String nameEnglish, String nameBangla) {
        this.id = id;
        this.nameEnglish = nameEnglish;
        this.nameBangla = nameBangla;
    }

    @Column(name = "division_name_eng")
    /*    */ private String nameEnglish;
    @Column(name = "division_name_bng")
    /*    */ private String nameBangla;

    public Division() {
    }

    public void setId(int id) {
        /* 12 */
        this.id = id;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public void setNameBangla(String nameBangla) {
        this.nameBangla = nameBangla;
    }

    public static DivisionBuilder builder() {
        /* 13 */
        return new DivisionBuilder();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public int getId() {
        /* 18 */
        return this.id;
        /*    */
    }

    public String getNameEnglish() {
        /* 20 */
        return this.nameEnglish;
        /*    */
    }

    public String getNameBangla() {
        /* 22 */
        return this.nameBangla;
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\Division.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */