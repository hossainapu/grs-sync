/*    */
package com.istl.database.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
/*    */
@Table(name = "employee_records")
@Builder
/*    */ public class EmployeeRecord {
    @Id
    /*    */
    @Column(name = "id")
    /*    */ private Long id;
    @Column(name = "name_eng")
    /*    */ private String nameEnglish;
    @Column(name = "name_bng")
    /*    */ private String nameBangla;
    @Column(name = "mother_name_eng")
    /*    */ private String motherNameEnglish;
    @Column(name = "mother_name_bng")
    /*    */ private String motherNameBangla;
    @Column(name = "father_name_eng")
    /* 10 */ private String fatherNameEnglish;

    public EmployeeRecord(Long id, String nameEnglish, String nameBangla, String motherNameEnglish, String motherNameBangla, String fatherNameEnglish, String fatherNameBangla, String personalEmail, String personalMobile, String nationalId, Date dateOfBirth, String gender) {
        this.id = id;
        this.nameEnglish = nameEnglish;
        this.nameBangla = nameBangla;
        this.motherNameEnglish = motherNameEnglish;
        this.motherNameBangla = motherNameBangla;
        this.fatherNameEnglish = fatherNameEnglish;
        this.fatherNameBangla = fatherNameBangla;
        this.personalEmail = personalEmail;
        this.personalMobile = personalMobile;
        this.nationalId = nationalId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @Column(name = "father_name_bng")
    private String fatherNameBangla;
    @Column(name = "personal_email")
    private String personalEmail;
    @Column(name = "personal_mobile")
    private String personalMobile;
    @Column(name = "nid")
    /*    */ private String nationalId;
    @Column(name = "date_of_birth")
    /*    */ private Date dateOfBirth;
    @Column(name = "gender")
    /* 13 */ private String gender;

    public EmployeeRecord() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public void setNameBangla(String nameBangla) {
        this.nameBangla = nameBangla;
    }

    public void setMotherNameEnglish(String motherNameEnglish) {
        this.motherNameEnglish = motherNameEnglish;
    }

    public void setMotherNameBangla(String motherNameBangla) {
        this.motherNameBangla = motherNameBangla;
    }

    public void setFatherNameEnglish(String fatherNameEnglish) {
        this.fatherNameEnglish = fatherNameEnglish;
    }

    public void setFatherNameBangla(String fatherNameBangla) {
        this.fatherNameBangla = fatherNameBangla;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public void setPersonalMobile(String personalMobile) {
        this.personalMobile = personalMobile;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static EmployeeRecordBuilder builder() {
        /* 14 */
        return new EmployeeRecordBuilder();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 19 */
        return this.id;
        /*    */
    }

    /*    */
    public String getNameEnglish() {
        /* 22 */
        return this.nameEnglish;
        /*    */
    }

    /*    */
    public String getNameBangla() {
        /* 25 */
        return this.nameBangla;
        /*    */
    }

    /*    */
    public String getMotherNameEnglish() {
        /* 28 */
        return this.motherNameEnglish;
        /*    */
    }

    /*    */
    public String getMotherNameBangla() {
        /* 31 */
        return this.motherNameBangla;
        /*    */
    }

    /*    */
    public String getFatherNameEnglish() {
        /* 34 */
        return this.fatherNameEnglish;
        /*    */
    }

    /*    */
    public String getFatherNameBangla() {
        /* 37 */
        return this.fatherNameBangla;
        /*    */
    }

    /*    */
    public String getPersonalEmail() {
        /* 40 */
        return this.personalEmail;
        /*    */
    }

    /*    */
    public String getPersonalMobile() {
        /* 43 */
        return this.personalMobile;
        /*    */
    }

    /*    */
    public String getNationalId() {
        /* 46 */
        return this.nationalId;
        /*    */
    }

    /*    */
    public Date getDateOfBirth() {
        /* 49 */
        return this.dateOfBirth;
        /*    */
    }

    /*    */
    public String getGender() {
        /* 52 */
        return this.gender;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\entity\EmployeeRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */