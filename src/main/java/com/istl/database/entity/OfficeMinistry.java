/*    */
package com.istl.database.entity;

import lombok.Builder;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*    */
@Entity
/*    */
@Table(name = "office_ministries")
@Builder
/*    */ public class OfficeMinistry {
    @Id
    /*    */
    @Column(name = "id", unique = true)
    /*    */ private Long id;
    @NotNull
    /*    */
    @Range(min = 1L, max = 2L)
    /*    */
    @Column(name = "office_type", columnDefinition = "TINYINT(2)")
    /*    */ private Integer officeType;
    @Column(name = "name_bng")
    /*    */ private String nameBangla;

    /* 11 */
    public OfficeMinistry(Long id, @NotNull Integer officeType, String nameBangla, String nameEnglish, String nameEnglishShort, String referenceCode, Boolean status) {
        this.id = id;
        this.officeType = officeType;
        this.nameBangla = nameBangla;
        this.nameEnglish = nameEnglish;
        this.nameEnglishShort = nameEnglishShort;
        this.referenceCode = referenceCode;
        this.status = status;
    }

    @Column(name = "name_eng")
    private String nameEnglish;
    @Column(name = "name_eng_short")
    /*    */ private String nameEnglishShort;
    @Column(name = "reference_code")
    /*    */ private String referenceCode;
    @Column(name = "status")
    /* 14 */ private Boolean status;

    public OfficeMinistry() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOfficeType(@NotNull Integer officeType) {
        this.officeType = officeType;
    }

    public void setNameBangla(String nameBangla) {
        this.nameBangla = nameBangla;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public void setNameEnglishShort(String nameEnglishShort) {
        this.nameEnglishShort = nameEnglishShort;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public static OfficeMinistryBuilder builder() {
        /* 15 */
        return new OfficeMinistryBuilder();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 21 */
        return this.id;
        /*    */
    }

    /*    */
    /*    */
    @NotNull
    /*    */ public Integer getOfficeType() {
        /* 26 */
        return this.officeType;
        /*    */
    }

    /*    */
    public String getNameBangla() {
        /* 29 */
        return this.nameBangla;
        /*    */
    }

    /*    */
    public String getNameEnglish() {
        /* 32 */
        return this.nameEnglish;
        /*    */
    }

    /*    */
    public String getNameEnglishShort() {
        /* 35 */
        return this.nameEnglishShort;
        /*    */
    }

    /*    */
    public String getReferenceCode() {
        /* 38 */
        return this.referenceCode;
        /*    */
    }

    /*    */
    public Boolean getStatus() {
        /* 41 */
        return this.status;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\OfficeMinistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */