/*    */
package com.istl.business.entity;

import java.util.Date;

/*    */ public class OfficeInfo {
    private Integer id;
    private Integer employee_record_id;
    /*    */   private Integer office_id;
    /*    */   private Integer office_unit_id;
    /*    */   private Integer office_unit_organogram_id;
    /*    */   private String designation;
    /*    */   private Integer designation_level;
    /*    */   private Integer designation_sequence;
    /*    */   private Integer office_head;
    /*    */   private String incharge_label;

    /*    */
    /* 12 */
    public void setId(Integer id) {
        this.id = id;
    }

    private Date joining_date;
    private Date last_office_date;
    private boolean status;
    private Integer show_unit;
    private String designation_en;
    private String unit_name_bn;
    private String office_name_bn;
    private String unit_name_en;
    private String office_name_en;
    private Integer protikolpo_status;

    public void setEmployee_record_id(Integer employee_record_id) {
        this.employee_record_id = employee_record_id;
    }

    public void setOffice_id(Integer office_id) {
        this.office_id = office_id;
    }

    public void setOffice_unit_id(Integer office_unit_id) {
        this.office_unit_id = office_unit_id;
    }

    public void setOffice_unit_organogram_id(Integer office_unit_organogram_id) {
        this.office_unit_organogram_id = office_unit_organogram_id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDesignation_level(Integer designation_level) {
        this.designation_level = designation_level;
    }

    public void setDesignation_sequence(Integer designation_sequence) {
        this.designation_sequence = designation_sequence;
    }

    public void setOffice_head(Integer office_head) {
        this.office_head = office_head;
    }

    public void setIncharge_label(String incharge_label) {
        this.incharge_label = incharge_label;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
    }

    public void setLast_office_date(Date last_office_date) {
        this.last_office_date = last_office_date;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setShow_unit(Integer show_unit) {
        this.show_unit = show_unit;
    }

    public void setDesignation_en(String designation_en) {
        this.designation_en = designation_en;
    }

    public void setUnit_name_bn(String unit_name_bn) {
        this.unit_name_bn = unit_name_bn;
    }

    public void setOffice_name_bn(String office_name_bn) {
        this.office_name_bn = office_name_bn;
    }

    public void setUnit_name_en(String unit_name_en) {
        this.unit_name_en = unit_name_en;
    }

    public void setOffice_name_en(String office_name_en) {
        this.office_name_en = office_name_en;
    }

    public void setProtikolpo_status(Integer protikolpo_status) {
        this.protikolpo_status = protikolpo_status;
    }

    /*    */
    /*    */
    /*    */
    public Integer getId() {
        /* 16 */
        return this.id;
        /* 17 */
    }

    public Integer getEmployee_record_id() {
        return this.employee_record_id;
    }

    /* 18 */
    public Integer getOffice_id() {
        return this.office_id;
    }

    /* 19 */
    public Integer getOffice_unit_id() {
        return this.office_unit_id;
    }

    /* 20 */
    public Integer getOffice_unit_organogram_id() {
        return this.office_unit_organogram_id;
    }

    /* 21 */
    public String getDesignation() {
        return this.designation;
    }

    /* 22 */
    public Integer getDesignation_level() {
        return this.designation_level;
    }

    /* 23 */
    public Integer getDesignation_sequence() {
        return this.designation_sequence;
    }

    /* 24 */
    public Integer getOffice_head() {
        return this.office_head;
    }

    /* 25 */
    public String getIncharge_label() {
        return this.incharge_label;
    }

    /* 26 */
    public Date getJoining_date() {
        return this.joining_date;
    }

    /* 27 */
    public Date getLast_office_date() {
        return this.last_office_date;
    }

    /* 28 */
    public boolean isStatus() {
        return this.status;
    }

    /* 29 */
    public Integer getShow_unit() {
        return this.show_unit;
    }

    /* 30 */
    public String getDesignation_en() {
        return this.designation_en;
    }

    /* 31 */
    public String getUnit_name_bn() {
        return this.unit_name_bn;
    }

    /* 32 */
    public String getOffice_name_bn() {
        return this.office_name_bn;
    }

    /* 33 */
    public String getUnit_name_en() {
        return this.unit_name_en;
    }

    /* 34 */
    public String getOffice_name_en() {
        return this.office_name_en;
    }

    public Integer getProtikolpo_status() {
        /* 35 */
        return this.protikolpo_status;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\OfficeInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */