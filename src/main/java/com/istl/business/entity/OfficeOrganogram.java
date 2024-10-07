/*    */
package com.istl.business.entity;

import java.util.Date;

/*    */ public class OfficeOrganogram {
    private Integer id;
    private Integer office_id;
    private Integer office_unit_id;
    private Integer superior_unit_id;
    /*    */   private Integer superior_designation_id;
    /*    */   private Integer ref_origin_unit_org_id;
    /*    */   private Integer ref_sup_origin_unit_desig_id;
    /*    */   private Integer ref_sup_origin_unit_id;
    /*    */   private String designation_eng;
    /*    */   private String designation_bng;
    /*    */   private String short_name_eng;
    /*    */   private String short_name_bng;

    /*    */
    /* 12 */
    public void setId(Integer id) {
        this.id = id;
    }

    private Integer designation_level;
    private Integer designation_sequence;
    private String designation_description;
    private Boolean status;
    private Boolean is_admin;
    private Boolean is_unit_admin;
    private Boolean is_unit_head;
    private Boolean is_office_head;
    private Integer created_by;
    private Integer modified_by;
    private Date created;
    private Date modified;

    public void setOffice_id(Integer office_id) {
        this.office_id = office_id;
    }

    public void setOffice_unit_id(Integer office_unit_id) {
        this.office_unit_id = office_unit_id;
    }

    public void setSuperior_unit_id(Integer superior_unit_id) {
        this.superior_unit_id = superior_unit_id;
    }

    public void setSuperior_designation_id(Integer superior_designation_id) {
        this.superior_designation_id = superior_designation_id;
    }

    public void setRef_origin_unit_org_id(Integer ref_origin_unit_org_id) {
        this.ref_origin_unit_org_id = ref_origin_unit_org_id;
    }

    public void setRef_sup_origin_unit_desig_id(Integer ref_sup_origin_unit_desig_id) {
        this.ref_sup_origin_unit_desig_id = ref_sup_origin_unit_desig_id;
    }

    public void setRef_sup_origin_unit_id(Integer ref_sup_origin_unit_id) {
        this.ref_sup_origin_unit_id = ref_sup_origin_unit_id;
    }

    public void setDesignation_eng(String designation_eng) {
        this.designation_eng = designation_eng;
    }

    public void setDesignation_bng(String designation_bng) {
        this.designation_bng = designation_bng;
    }

    public void setShort_name_eng(String short_name_eng) {
        this.short_name_eng = short_name_eng;
    }

    public void setShort_name_bng(String short_name_bng) {
        this.short_name_bng = short_name_bng;
    }

    public void setDesignation_level(Integer designation_level) {
        this.designation_level = designation_level;
    }

    public void setDesignation_sequence(Integer designation_sequence) {
        this.designation_sequence = designation_sequence;
    }

    public void setDesignation_description(String designation_description) {
        this.designation_description = designation_description;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    public void setIs_unit_admin(Boolean is_unit_admin) {
        this.is_unit_admin = is_unit_admin;
    }

    public void setIs_unit_head(Boolean is_unit_head) {
        this.is_unit_head = is_unit_head;
    }

    public void setIs_office_head(Boolean is_office_head) {
        this.is_office_head = is_office_head;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    public void setModified_by(Integer modified_by) {
        this.modified_by = modified_by;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    /*    */
    /*    */
    /*    */
    public Integer getId() {
        /* 16 */
        return this.id;
        /* 17 */
    }

    public Integer getOffice_id() {
        return this.office_id;
    }

    /* 18 */
    public Integer getOffice_unit_id() {
        return this.office_unit_id;
    }

    /* 19 */
    public Integer getSuperior_unit_id() {
        return this.superior_unit_id;
    }

    /* 20 */
    public Integer getSuperior_designation_id() {
        return this.superior_designation_id;
    }

    /* 21 */
    public Integer getRef_origin_unit_org_id() {
        return this.ref_origin_unit_org_id;
    }

    /* 22 */
    public Integer getRef_sup_origin_unit_desig_id() {
        return this.ref_sup_origin_unit_desig_id;
    }

    /* 23 */
    public Integer getRef_sup_origin_unit_id() {
        return this.ref_sup_origin_unit_id;
    }

    /* 24 */
    public String getDesignation_eng() {
        return this.designation_eng;
    }

    /* 25 */
    public String getDesignation_bng() {
        return this.designation_bng;
    }

    /* 26 */
    public String getShort_name_eng() {
        return this.short_name_eng;
    }

    /* 27 */
    public String getShort_name_bng() {
        return this.short_name_bng;
    }

    /* 28 */
    public Integer getDesignation_level() {
        return this.designation_level;
    }

    /* 29 */
    public Integer getDesignation_sequence() {
        return this.designation_sequence;
    }

    /* 30 */
    public String getDesignation_description() {
        return this.designation_description;
    }

    /* 31 */
    public Boolean getStatus() {
        return this.status;
    }

    /* 32 */
    public Boolean getIs_admin() {
        return this.is_admin;
    }

    /* 33 */
    public Boolean getIs_unit_admin() {
        return this.is_unit_admin;
    }

    /* 34 */
    public Boolean getIs_unit_head() {
        return this.is_unit_head;
    }

    /* 35 */
    public Boolean getIs_office_head() {
        return this.is_office_head;
    }

    /* 36 */
    public Integer getCreated_by() {
        return this.created_by;
    }

    /* 37 */
    public Integer getModified_by() {
        return this.modified_by;
    }

    /* 38 */
    public Date getCreated() {
        return this.created;
    }

    public Date getModified() {
        /* 39 */
        return this.modified;
        /*    */
    }
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\entity\OfficeOrganogram.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */