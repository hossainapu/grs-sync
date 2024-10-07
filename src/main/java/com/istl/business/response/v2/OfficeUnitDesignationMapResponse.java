/*    */
package com.istl.business.response.v2;
/*    */
/*    */

import com.istl.business.entity.Office;
import lombok.Builder;
/*    */ import java.io.Serializable;
/*    */ import java.util.Map;

/*    */
@Builder
/*    */ public class OfficeUnitDesignationMapResponse extends ServiceResponse implements Serializable {
    /*    */ Map<String, OfficeUnitDesignationMapResponse.Office> data;

    public class Office {
        public Integer office_id;
        public Integer office_layer_id;
        public Integer office_ministry_id;
        public String office_name_bn;
        public String office_name_en;
        public Map<String, OfficeUnitDesignationMapResponse.Unit> units;
    }

    public class Unit {
        public Integer office_origin_unit_id;
        public String unit_name_bng;
        public String unit_name_eng;
        public String office_unit_category;
        public Integer parent_unit_id;
        public String unit_nothi_code;
        public Integer unit_level;
        public String email;
        public String phone;
        public String mobile;
        public String fax;
        public Long office_unit_id;
        public Map<String, Designation> designations;
    }

    public class Designation {
        public Integer designation_id;
        public String designation_eng;
        public String designation_bng;
        public Integer designation_level;
        public Integer designation_sequence;
        public boolean is_admin;
        public boolean is_unit_admin;
        public boolean is_unit_head;
        public boolean is_office_head;
    }


    public Map<String, Office> getData() {
        return data;
    }

    public void setData(Map<String, Office> data) {
        this.data = data;
    }
}