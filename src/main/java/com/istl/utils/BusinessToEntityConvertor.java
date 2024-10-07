/*     */
package com.istl.utils;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */

import com.istl.business.entity.*;
import com.istl.database.entity.EmployeeOffice;
import com.istl.database.entity.EmployeeRecord;
import com.istl.redis.EmpOfficeRedis;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
import java.util.stream.Collectors;

/*     */
/*     */ public class BusinessToEntityConvertor {
    /*     */
    public static com.istl.database.entity.Division convert(Division o) {
        /*  18 */
        return (o != null) ? com.istl.database.entity.Division.builder()
/*  19 */.id(o.getId().intValue())
/*  20 */.nameEnglish(o.getName())
/*  21 */.nameBangla(o.getNameBn())
/*  22 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.Division> convertDivision(List<Division> o) {
        /*  28 */
        return (o != null) ? o.stream()
/*  29 */.map(v -> convert(v))
/*  30 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static com.istl.database.entity.OfficeMinistry convertOfficeMinistryEntity(OfficeMinistry o) {
        /*  35 */
        return (o != null) ? com.istl.database.entity.OfficeMinistry.builder()
/*  36 */.id(o.getId())
/*  37 */.nameEnglish(o.getName())
/*  38 */.nameBangla(o.getNameBn())
/*  39 */.nameEnglishShort(o.getNameShort())
/*  40 */.officeType(o.getType())
/*  41 */.referenceCode(o.getReference())
/*  42 */.status(o.getStatus())
/*  43 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    public static List<com.istl.database.entity.OfficeMinistry> convertOfficeMinistryList(List<OfficeMinistry> o) {
        /*  47 */
        return (o != null) ? o.stream()
/*  48 */.map(v -> convertOfficeMinistryEntity(v))
/*  49 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.OfficeOriginUnitOrganogram convertOfficeOriginUnitOrganogramEntity(OfficeOriginUnitOrganogram o) {
        /*  53 */
        return (o != null) ? com.istl.database.entity.OfficeOriginUnitOrganogram.builder()
/*  54 */.id(o.getId())
/*  55 */.nameEnglish(o.getName())
/*  56 */.nameBangla(o.getNameBn())
/*  57 */.officeOriginUnitId(o.getOriginUnit())
/*  58 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    public static List<com.istl.database.entity.OfficeOriginUnitOrganogram> convertOfficeOriginUnitOrganogramList(List<OfficeOriginUnitOrganogram> o) {
        /*  62 */
        return (o != null) ? o.stream()
/*  63 */.map(v -> convertOfficeOriginUnitOrganogramEntity(v))
/*  64 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.OfficeLayer convertOfficeLayerEntity(OfficeLayer o, Long ministryId) {
        /*  68 */
        return (o != null) ? com.istl.database.entity.OfficeLayer.builder()
/*  69 */.id(o.getId())
/*  70 */.layerNameEnglish(o.getName())
/*  71 */.layerNameBangla(o.getNameBn())
/*  72 */.customLayerId(o.getCustomlayerid())
/*  73 */.layerLevel(o.getLevel())
/*  74 */.officeMinistryId(ministryId)
/*  75 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    public static List<com.istl.database.entity.OfficeLayer> convertOfficeLayerList(List<OfficeLayer> o, Long ministryId) {
        /*  79 */
        return (o != null) ? o.stream()
/*  80 */.map(v -> convertOfficeLayerEntity(v, ministryId))
/*  81 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.District convert(District o) {
        /*  85 */
        return (o != null) ? com.istl.database.entity.District.builder()
/*  86 */.id(o.getId())
/*  87 */.nameEnglish(o.getName())
/*  88 */.nameBangla(o.getNameBn())
/*  89 */.divisionId(o.getDivision())
/*  90 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.District> convertDistrict(List<District> o) {
        /*  97 */
        return (o != null) ? o.stream()
/*  98 */.map(v -> convert(v))
/*  99 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.Upazila convert(Upazila o) {
        /* 103 */
        return (o != null) ? com.istl.database.entity.Upazila.builder()
/* 104 */.id(o.getId())
/* 105 */.nameEnglish(o.getName())
/* 106 */.nameBangla(o.getNameBn())
/* 107 */.divisionId(o.getDivision())
/* 108 */.districtId(o.getDistrict())
/* 109 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.Upazila> convertUpazila(List<Upazila> o) {
        /* 116 */
        return (o != null) ? o.stream()
/* 117 */.map(v -> convert(v))
/* 118 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.Thana convert(Thana o) {
        /* 122 */
        return (o != null) ? com.istl.database.entity.Thana.builder()
/* 123 */.id(o.getId())
/* 124 */.nameEnglish(o.getName())
/* 125 */.nameBangla(o.getNameBn())
/* 126 */.divisionId(o.getDivision())
/* 127 */.districtId(o.getDistrict())
/* 128 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.Thana> convertThana(List<Thana> o) {
        /* 135 */
        return (o != null) ? o.stream()
/* 136 */.map(v -> convert(v))
/* 137 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.CityCorporation convert(CityCorporation o) {
        /* 141 */
        return (o != null) ? com.istl.database.entity.CityCorporation.builder()
/* 142 */.id(o.getId())
/* 143 */.nameEnglish(o.getName())
/* 144 */.nameBangla(o.getNameBn())
/* 145 */.divisionId(o.getDivision())
/* 146 */.districtId(o.getDistrict())
/* 147 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.CityCorporation> convertCityCorporation(List<CityCorporation> o) {
        /* 153 */
        return (o != null) ? o.stream()
/* 154 */.map(v -> convert(v))
/* 155 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static com.istl.database.entity.Municipality convert(Municipality o) {
        /* 160 */
        return (o != null) ? com.istl.database.entity.Municipality.builder()
/* 161 */.id(o.getId())
/* 162 */.nameEnglish(o.getName())
/* 163 */.nameBangla(o.getNameBn())
/* 164 */.divisionId(o.getDivision())
/* 165 */.districtId(o.getDistrict())
/* 166 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.Municipality> convertMunicipality(List<Municipality> o) {
        /* 172 */
        return (o != null) ? o.stream()
/* 173 */.map(v -> convert(v))
/* 174 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.Office convert(Office o) {
        /* 178 */
        return (o != null) ? com.istl.database.entity.Office.builder()
/* 179 */.id(Long.valueOf(o.getId().longValue()))
/*     */
/* 181 */.officeMinistryId(Long.valueOf(o.getMinistry().longValue()))
/* 182 */.officeLayerId(Long.valueOf(o.getLayer().longValue()))
/* 183 */.parentOfficeId(Long.valueOf(o.getParentOfficeId().longValue()))
/* 184 */.nameEnglish(o.getName())
/* 185 */.nameBangla(o.getNameBn())
/* 186 */.divisionId(o.getDivision())
/* 187 */.districtId(o.getDistrict())
/* 188 */.upazilaId(o.getUpazila())
/* 189 */.websiteUrl(o.getWebsite())
/* 190 */.officeOriginId(Long.valueOf(o.getOrigin().longValue()))
/* 191 */.status(Boolean.TRUE)
/* 192 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.Office> convertOffice(List<Office> o) {
        /* 198 */
        return (o != null) ? o.stream()
/* 199 */.map(v -> convert(v))
/* 200 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.OfficeUnit> convertOfficeUnit(List<OfficeUnit> listB) {
        /* 205 */
        if (listB != null && listB.size() > 0) {
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /* 216 */
            List<com.istl.database.entity.OfficeUnit> officeUnits = listB.stream().filter(Objects::nonNull).map(ou -> com.istl.database.entity.OfficeUnit.builder().id(new Long(ou.getId().intValue())).officeId(ou.getOffice()).ministryId(ou.getMinistry()).officeLayerId(ou.getLayer()).parentUnitId(ou.getParent()).unitNameBangla(ou.getNameBn()).unitNameEnglish(ou.getName()).email(ou.getEmail()).phoneNumber(ou.getPhone()).build()).collect(Collectors.toList());
            /* 217 */
            return officeUnits;
            /*     */
        }
        /* 219 */
        return new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.OfficeUnitOrganogram> convertOfficeUnitOrganogram(List<OfficeUnitOrganogram> listB, Long officeId) {
        /* 224 */
        if (listB != null && listB.size() > 0) {
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /* 235 */
            List<com.istl.database.entity.OfficeUnitOrganogram> officeUnitOrganograms = listB.stream().filter(Objects::nonNull).map(o -> com.istl.database.entity.OfficeUnitOrganogram.builder().id(new Long(o.getId().intValue())).status(Boolean.valueOf(true)).isAdmin(Boolean.valueOf(false)).officeId(o.getOfficeId()).officeUnitId(o.getOfficeUnitId()).designationBangla(o.getNameBn()).designationEnglish(o.getName()).refOriginUnitOrgId(o.getRefOrigin()).build()).collect(Collectors.toList());
            /*     */
            /* 237 */
            return officeUnitOrganograms;
            /*     */
        }
        /* 239 */
        return new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.EmployeeRecord> convertEmpRecord(List<EmpRecord> listB) {
        /* 244 */
        if (listB != null && listB.size() > 0) {
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /* 261 */
            List<com.istl.database.entity.EmployeeRecord> records = (List<EmployeeRecord>) listB.stream().filter(Objects::nonNull).map(l -> com.istl.database.entity.EmployeeRecord.builder().id(new Long(l.getId().intValue())).nameEnglish(l.getName()).nameBangla(l.getNameBn()).motherNameEnglish(l.getMother()).motherNameBangla(l.getMother()).fatherNameEnglish(l.getFather()).fatherNameBangla(l.getFather()).personalEmail(l.getEmail()).personalMobile(l.getMobile()).nationalId(l.getNid()).dateOfBirth(l.getDob()).gender(l.getGender()).build()).collect(Collectors.toList());
            /* 262 */
            return records;
            /*     */
        }
        /*     */
        /* 265 */
        return new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.EmployeeOffice> convertEmpOffice(List<EmpOffice> listB) {
        /* 270 */
        if (listB != null && listB.size() > 0) {
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /*     */
            /* 281 */
            List<com.istl.database.entity.EmployeeOffice> employeeOffices = (List<EmployeeOffice>) listB.stream().filter(Objects::nonNull).map(eo -> com.istl.database.entity.EmployeeOffice.builder().id(new Long(eo.getId().intValue())).officeId(eo.getOffice()).officeUnitId(eo.getUnit()).officeUnitOrganogramId(eo.getOrganogram()).employeeRecordId(eo.getEmployeeRecord()).designation(eo.getDesignation()).status(Boolean.valueOf(eo.isStatus())).isOfficeHead(Boolean.valueOf((eo.getOfficeHead() != null && eo.getOfficeHead().intValue() == 1))).isDefaultRole(Boolean.valueOf(false)).build()).collect(Collectors.toList());
            /*     */
            /* 283 */
            return employeeOffices;
            /*     */
        }
        /* 285 */
        return new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static EmpOfficeRedis convertEmpOfficeToEmpOfficeRedis(EmpOffice eo) {
        /* 289 */
        return (eo != null) ?
                /* 290 */       EmpOfficeRedis.builder()
/* 291 */.id(new Long(eo.getId().intValue()))
/* 292 */.officeId(eo.getOffice())
/* 293 */.officeUnitId(eo.getUnit())
/* 294 */.officeUnitOrganogramId(eo.getOrganogram())
/* 295 */.employeeRecordId(eo.getEmployeeRecord())
/* 296 */.build() :
                /*     */
                /* 298 */       EmpOfficeRedis.builder().build();
        /*     */
    }

    /*     */
    public static EmpOfficeRedis convertEmpOfficeToEmpOfficeRedis(EmployeeOffice eo) {
        /* 301 */
        return (eo != null) ?
                /* 302 */       EmpOfficeRedis.builder()
/* 303 */.id(new Long(eo.getId().longValue()))
/* 304 */.officeId(eo.getOfficeId())
/* 305 */.officeUnitId(eo.getOfficeUnitId())
/* 306 */.officeUnitOrganogramId(eo.getOfficeUnitOrganogramId())
/* 307 */.employeeRecordId(eo.getEmployeeRecordId())
/* 308 */.build() :
                /*     */
                /* 310 */       EmpOfficeRedis.builder().build();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.OfficeOriginUnit convert(OfficeOriginUnit o) {
        /* 314 */
        return (o != null) ?
                /* 315 */       com.istl.database.entity.OfficeOriginUnit.builder()
/* 316 */.id(Long.valueOf(o.getId().longValue()))
/* 317 */.officeOriginId(Long.valueOf(o.getOfficeOrigin().longValue()))
/* 318 */.nameBangla(o.getNameBn())
/* 319 */.nameEnglish(o.getName())
/* 320 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.OfficeOriginUnit> convertOfficeOriginUnit(List<OfficeOriginUnit> o) {
        /* 326 */
        return (o != null) ? o.stream()
/* 327 */.map(v -> convert(v))
/* 328 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.OfficeOrigin convert(OfficeOrigin o) {
        /* 332 */
        return (o != null) ?
                /* 333 */       com.istl.database.entity.OfficeOrigin.builder()
/* 334 */.id(Long.valueOf(o.getId().longValue()))
/* 335 */.officeLayerId(Long.valueOf(o.getLayer().longValue()))
/* 336 */.officeNameEnglish(o.getName())
/* 337 */.officeNameBangla(o.getNameBn())
/* 338 */.parentOfficeOriginId(Long.valueOf(o.getParent().longValue()))
/* 339 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.OfficeOrigin> convertOfficeOrigin(List<OfficeOrigin> o) {
        /* 345 */
        return (o != null) ? o.stream()
/* 346 */.map(v -> convert(v))
/* 347 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.OfficeOriginUnitOrganogram convert(OfficeOriginUnitOrganogram o) {
        /* 351 */
        return (o != null) ?
                /* 352 */       com.istl.database.entity.OfficeOriginUnitOrganogram.builder()
/* 353 */.id(Long.valueOf(o.getId().longValue()))
/* 354 */.officeOriginUnitId(o.getOriginUnit())
/* 355 */.nameBangla(o.getNameBn())
/* 356 */.nameEnglish(o.getName())
/* 357 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.OfficeOriginUnitOrganogram> convertOfficeOriginUnitOrganogram(List<OfficeOriginUnitOrganogram> o) {
        /* 363 */
        return (o != null) ? o.stream()
/* 364 */.map(v -> convert(v))
/* 365 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }

    /*     */
    /*     */
    public static com.istl.database.entity.CustomOfficeLayer convert(CustomOfficeLayer o) {
        /* 369 */
        return (o != null) ?
                /* 370 */       com.istl.database.entity.CustomOfficeLayer.builder()
/* 371 */.id(Long.valueOf(o.getId().longValue()))
/* 372 */.name(o.getName())
/* 373 */.layerLevel(o.getLayer_level())
/* 374 */.build() : null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public static List<com.istl.database.entity.CustomOfficeLayer> convertCustomOfficeLayerList(List<CustomOfficeLayer> o) {
        /* 380 */
        return (o != null) ? o.stream()
/* 381 */.map(v -> convert(v))
/* 382 */.collect(Collectors.toList()) : new ArrayList<>();
        /*     */
    }
    /*     */
}