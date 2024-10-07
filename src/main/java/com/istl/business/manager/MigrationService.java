/*     */
package com.istl.business.manager;
/*     */

import com.istl.business.entity.*;
/*     */
/*     */
/*     */
/*     */
/*     */ import com.istl.business.entity.Office;
import com.istl.business.entity.OfficeUnit;
import com.istl.business.entity.OfficeUnitOrganogram;
import com.istl.business.request.*;
import com.istl.business.request.v2.OfficeUnitDesignationMapRequest;
import com.istl.business.response.v2.OfficeUnitDesignationMapResponse;
/*     */ import com.istl.database.manager.BaseEntityManager;
import com.istl.database.repository.*;
import com.istl.redis.RedisService;
import com.istl.utils.BusinessToEntityConvertor;
/*     */ import com.istl.utils.Utility;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
/*     */ import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import scala.Unit;

/*     */
/*     */
@Service
/*     */ public class MigrationService {
    /*  27 */   private static final Logger log = LoggerFactory.getLogger(com.istl.business.manager.MigrationService.class);
    /*     */
    /*     */   private final DoptorConnectorServiceV1 serviceV1;
    /*     */
    /*     */   private final DoptorConnectorServiceNew serviceNew;
    /*     */
    /*     */   private final DivisionRepo divisionRepo;
    /*     */
    /*     */   private final DistrictRepo districtRepo;
    /*     */
    /*     */   private final UpazilaRepo upazilaRepo;
    /*     */
    /*     */   private final ThanaRepo thanaRepo;
    /*     */
    /*     */   private final MunicipalityRepo municipalityRepo;
    /*     */
    /*     */   private final CityCorporationRepo cityCorporationRepo;
    /*     */
    /*     */   private final OfficeRepo officeRepo;
    /*     */
    /*     */   private final OfficeOriginUnitRepo officeOriginUnitRepo;
    /*     */
    /*     */   private final OfficeOriginRepo officeOriginRepo;
    /*     */
    /*     */   private final EmployeeRecordRepository employeeRecordRepository;
    /*     */
    /*     */   private final EmployeeOfficeRepository employeeOfficeRepository;
    /*     */
    /*     */   private final OfficeMinistryRepo officeMinistryRepo;
    /*     */   private final OfficeLayerRepo officeLayerRepo;
    /*     */   private final OfficeUnitRepository officeUnitRepository;
    /*     */   private final OfficeUnitOrganogramRepository officeUnitOrganogramRepository;
    /*     */   private final OfficeOriginUnitOrganogramRepo officeOriginUnitOrganogramRepo;
    /*     */   private final CustomOfficeLayerRepo customOfficeLayerRepo;
    /*     */   private final RedisService redisService;
    /*     */   private final BaseEntityManager baseEntityManager;
    /*     */
    @Value("${thread.count:5}")
    /*     */ private int threadCount;

    /*     */
    /*     */
    public MigrationService(DoptorConnectorServiceV1 serviceV1, DoptorConnectorServiceNew serviceNew, DivisionRepo divisionRepo, DistrictRepo districtRepo, UpazilaRepo upazilaRepo, ThanaRepo thanaRepo, MunicipalityRepo municipalityRepo, CityCorporationRepo cityCorporationRepo, OfficeRepo officeRepo, OfficeOriginUnitRepo officeOriginUnitRepo, OfficeOriginRepo officeOriginRepo, EmployeeRecordRepository employeeRecordRepository, EmployeeOfficeRepository employeeOfficeRepository, OfficeMinistryRepo officeMinistryRepo, OfficeLayerRepo officeLayerRepo, OfficeUnitRepository officeUnitRepository, OfficeUnitOrganogramRepository officeUnitOrganogramRepository, OfficeOriginUnitOrganogramRepo officeOriginUnitOrganogramRepo, CustomOfficeLayerRepo customOfficeLayerRepo, RedisService redisService, BaseEntityManager baseEntityManager) {
        /*  67 */
        this.serviceV1 = serviceV1;
        /*  68 */
        this.serviceNew = serviceNew;
        /*  69 */
        this.divisionRepo = divisionRepo;
        /*  70 */
        this.districtRepo = districtRepo;
        /*  71 */
        this.upazilaRepo = upazilaRepo;
        /*  72 */
        this.thanaRepo = thanaRepo;
        /*  73 */
        this.municipalityRepo = municipalityRepo;
        /*  74 */
        this.cityCorporationRepo = cityCorporationRepo;
        /*  75 */
        this.officeRepo = officeRepo;
        /*  76 */
        this.officeOriginUnitRepo = officeOriginUnitRepo;
        /*  77 */
        this.officeOriginRepo = officeOriginRepo;
        /*  78 */
        this.employeeRecordRepository = employeeRecordRepository;
        /*  79 */
        this.employeeOfficeRepository = employeeOfficeRepository;
        /*  80 */
        this.officeMinistryRepo = officeMinistryRepo;
        /*  81 */
        this.officeLayerRepo = officeLayerRepo;
        /*  82 */
        this.officeUnitRepository = officeUnitRepository;
        /*  83 */
        this.officeUnitOrganogramRepository = officeUnitOrganogramRepository;
        /*  84 */
        this.officeOriginUnitOrganogramRepo = officeOriginUnitOrganogramRepo;
        /*  85 */
        this.customOfficeLayerRepo = customOfficeLayerRepo;
        /*  86 */
        this.redisService = redisService;
        /*  87 */
        this.baseEntityManager = baseEntityManager;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void migrateDivision() {
        /*  93 */
        List<Division> divisionB = this.serviceV1.getDivision(new DivisionRequest());
        /*     */
        /*  95 */
        List<com.istl.database.entity.Division> divisions = BusinessToEntityConvertor.convertDivision(divisionB);
        /*     */
        /*  97 */
        this.divisionRepo.saveAll(divisions);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void migrateOfficeMinistry() {
        /* 103 */
        List<OfficeMinistry> officeMinistryB = this.serviceV1.getOfficeMinistry(new OfficeMinistryRequest());
        /*     */
        /* 105 */
        List<com.istl.database.entity.OfficeMinistry> officeMinistries = BusinessToEntityConvertor.convertOfficeMinistryList(officeMinistryB);
        /*     */
        /* 107 */
        this.officeMinistryRepo.saveAll(officeMinistries);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void migrateCustomOfficeLayer() {
        /* 113 */
        List<CustomOfficeLayer> allCustomOfficeLayersList = this.serviceNew.getCustomOfficeLayer(CustomOfficeLayerRequest.builder().layer_levels("0").build());
        /*     */
        /* 115 */
        for (CustomOfficeLayer customOfficeLayerLevel : allCustomOfficeLayersList) {
            /* 116 */
            List<CustomOfficeLayer> customOfficeLayersB = this.serviceNew.getCustomOfficeLayer(CustomOfficeLayerRequest.builder()
/* 117 */.layer_levels(customOfficeLayerLevel.getLayer_level().toString())
/* 118 */.build());
            /*     */
            /* 120 */
            List<com.istl.database.entity.CustomOfficeLayer> customOfficeLayers = BusinessToEntityConvertor.convertCustomOfficeLayerList(customOfficeLayersB);
            /*     */
            /* 122 */
            this.customOfficeLayerRepo.saveAll(customOfficeLayers);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void migrateOfficeMinistry(List<OfficeMinistry> officeMinistryB) {
        /* 128 */
        List<com.istl.database.entity.OfficeMinistry> officeMinistries = BusinessToEntityConvertor.convertOfficeMinistryList(officeMinistryB);
        /* 129 */
        this.officeMinistryRepo.saveAll(officeMinistries);
        /*     */
    }

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
    public void migrateOfficeLayerExtension() {
        /* 146 */
        Long startTime = Long.valueOf(System.currentTimeMillis());
        /*     */
        /* 148 */
        List<Long> ministryIds = this.officeMinistryRepo.getAllOfficeMinistryId();
        /*     */
        /* 150 */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(getThreadCount(), (ThreadFactory) new CustomizableThreadFactory("ministry-OfficeLayer-"));
        /*     */
        /* 152 */
        List<List<Long>> lists = Utility.spiltArray(ministryIds, this.threadCount);
        /* 153 */
        AtomicInteger finishedCount = new AtomicInteger(0);
        /*     */
        /* 155 */
        for (int i = 0; i < lists.size(); i++) {
            /* 156 */
            AtomicInteger finalI = new AtomicInteger(i);
            /* 157 */
            executor.execute(() -> {
                /*     */
                log.info("==STARTING FOR OfficeLayer:{}", Integer.valueOf(finalI.get()));
                /*     */
                /*     */
                for (Long ministryId : lists.get(finalI.get())) {
                    /*     */
                    List<OfficeLayer> list = migrateOfficeLayers(ministryId);
                    /*     */
                }
                /*     */
                log.info("==DONE FOR  OfficeLayer :{}", Integer.valueOf(finalI.get()));
                /*     */
                finishedCount.getAndIncrement();
                /*     */
            });
            /*     */
        }
        /* 167 */
        while (executor.getActiveCount() > 0) {
            /*     */
            try {
                /* 169 */
                Thread.sleep(10000L);
                /* 170 */
            } catch (Exception exception) {
            }
            /*     */
        }
        /*     */
        /*     */
        /* 174 */
        executor.shutdown();
        /* 175 */
        log.info("migrateOfficeLayer: {} min , thread: {}", Long.valueOf((System.currentTimeMillis() - startTime.longValue()) / 60000L), Integer.valueOf(this.threadCount));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public List<OfficeLayer> migrateOfficeLayers(Long ministryId) {
        /* 181 */
        List<OfficeLayer> officeLayerB = this.serviceV1.getOfficeLayer(OfficeLayerRequest.builder().ministry(ministryId.toString()).build());
        /* 182 */
        List<com.istl.database.entity.OfficeLayer> officeLayers = BusinessToEntityConvertor.convertOfficeLayerList(officeLayerB, ministryId);
        /* 183 */
        this.officeLayerRepo.saveAll(officeLayers);
        /* 184 */
        return officeLayerB;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void migrateOfficeOriginExtension() {
        /* 190 */
        Long startTime = Long.valueOf(System.currentTimeMillis());
        /*     */
        /* 192 */
        List<Long> ministryIds = this.officeMinistryRepo.getAllOfficeMinistryId();
        /*     */
        /* 194 */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(getThreadCount(), (ThreadFactory) new CustomizableThreadFactory("ministry-OfficeOrigin-"));
        /*     */
        /* 196 */
        List<List<Long>> lists = Utility.spiltArray(ministryIds, this.threadCount);
        /* 197 */
        AtomicInteger finishedCount = new AtomicInteger(0);
        /*     */
        /* 199 */
        for (int i = 0; i < lists.size(); i++) {
            /* 200 */
            AtomicInteger finalI = new AtomicInteger(i);
            /* 201 */
            executor.execute(() -> {
                /*     */
                log.info("==STARTING FOR OfficeOrigin:{}", Integer.valueOf(finalI.get()));
                /*     */
                /*     */
                for (Long ministryId : lists.get(finalI.get())) {
                    /*     */
                    migrateOfficeOrigins(ministryId);
                    /*     */
                }
                /*     */
                /*     */
                log.info("==DONE FOR   OfficeOrigin :{}", Integer.valueOf(finalI.get()));
                /*     */
                finishedCount.getAndIncrement();
                /*     */
            });
            /*     */
        }
        /* 212 */
        while (executor.getActiveCount() > 0) {
            /*     */
            try {
                /* 214 */
                Thread.sleep(10000L);
                /* 215 */
            } catch (Exception exception) {
            }
            /*     */
        }
        /*     */
        /*     */
        /* 219 */
        executor.shutdown();
        /* 220 */
        log.info("migrateOfficeOrigin: {} min , thread: {}", Long.valueOf((System.currentTimeMillis() - startTime.longValue()) / 60000L), Integer.valueOf(this.threadCount));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public List<OfficeOrigin> migrateOfficeOrigins(Long ministryId) {
        /* 226 */
        List<OfficeOrigin> officeOriginsB = this.serviceV1.getOfficeOrigin(
                /* 227 */         OfficeOriginRequest.builder().ministry(Integer.valueOf(ministryId.intValue())).build());
        /*     */
        /*     */
        /*     */
        /* 231 */
        List<com.istl.database.entity.OfficeOrigin> officeOrigins = BusinessToEntityConvertor.convertOfficeOrigin(officeOriginsB);
        /* 232 */
        this.officeOriginRepo.saveAll(officeOrigins);
        /*     */
        /*     */
        /* 235 */
        return officeOriginsB;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void migrateOfficeOriginUnitExtension() {
        /* 241 */
        Long startTime = Long.valueOf(System.currentTimeMillis());
        /*     */
        /* 243 */
        List<Long> officeOriginIds = this.officeOriginRepo.getAllOfficeOriginId();
        /*     */
        /* 245 */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(getThreadCount(), (ThreadFactory) new CustomizableThreadFactory("ministry-OfficeOriginUnit-"));
        /*     */
        /* 247 */
        List<List<Long>> lists = Utility.spiltArray(officeOriginIds, this.threadCount);
        /* 248 */
        AtomicInteger finishedCount = new AtomicInteger(0);
        /*     */
        /* 250 */
        for (int i = 0; i < lists.size(); i++) {
            /* 251 */
            AtomicInteger finalI = new AtomicInteger(i);
            /* 252 */
            executor.execute(() -> {
                /*     */
                log.info("==STARTING FOR OfficeOriginUnit:{}", Integer.valueOf(finalI.get()));
                /*     */
                /*     */
                for (Long officeOriginId : lists.get(finalI.get())) {
                    /*     */
                    migrateOfficeOriginUnits(officeOriginId);
                    /*     */
                }
                /*     */
                log.info("==DONE FOR    OfficeOriginUnit :{}", Integer.valueOf(finalI.get()));
                /*     */
                finishedCount.getAndIncrement();
                /*     */
            });
            /*     */
        }
        /* 262 */
        while (executor.getActiveCount() > 0) {
            /*     */
            try {
                /* 264 */
                Thread.sleep(10000L);
                /* 265 */
            } catch (Exception exception) {
            }
            /*     */
        }
        /*     */
        /*     */
        /* 269 */
        executor.shutdown();
        /* 270 */
        log.info("migrateOfficeOriginUnit: {} min , thread: {}", Long.valueOf((System.currentTimeMillis() - startTime.longValue()) / 60000L), Integer.valueOf(this.threadCount));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public List<OfficeOriginUnit> migrateOfficeOriginUnits(Long officeOriginId) {
        /* 276 */
        List<OfficeOriginUnit> officeOriginUnitsB = this.serviceV1.getOfficeoriginUnit(
                /* 277 */         OfficeOriginUnitRequest.builder().officeOrigin(Integer.valueOf(officeOriginId.intValue())).build());
        /*     */
        /*     */
        /*     */
        /* 281 */
        List<com.istl.database.entity.OfficeOriginUnit> officeOriginUnits = BusinessToEntityConvertor.convertOfficeOriginUnit(officeOriginUnitsB);
        /*     */
        /* 283 */
        this.officeOriginUnitRepo.saveAll(officeOriginUnits);
        /* 284 */
        return officeOriginUnitsB;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void migrateOfficeOriginUnitOrganogramExtension() {
        /* 290 */
        Long startTime = Long.valueOf(System.currentTimeMillis());
        /*     */
        /* 292 */
        List<Long> officeOriginUnitIds = this.officeOriginUnitRepo.getAllOfficeOriginUnitId();
        /*     */
        /* 294 */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(getThreadCount(), (ThreadFactory) new CustomizableThreadFactory("ministry-OfficeOriginUnitOrganogram-"));
        /*     */
        /* 296 */
        List<List<Long>> lists = Utility.spiltArray(officeOriginUnitIds, this.threadCount);
        /* 297 */
        AtomicInteger finishedCount = new AtomicInteger(0);
        /*     */
        /* 299 */
        for (int i = 0; i < lists.size(); i++) {
            /* 300 */
            AtomicInteger finalI = new AtomicInteger(i);
            /* 301 */
            executor.execute(() -> {
                /*     */
                log.info("==STARTING FOR OfficeOriginUnitOrganogram:{}", Integer.valueOf(finalI.get()));
                /*     */
                /*     */
                for (Long officeOriginUnitId : lists.get(finalI.get())) {
                    /*     */
                    migrateOfficeOriginUnitOrganograms(officeOriginUnitId);
                    /*     */
                }
                /*     */
                log.info("==DONE FOR OfficeOriginUnitOrganogram :{}", Integer.valueOf(finalI.get()));
                /*     */
                finishedCount.getAndIncrement();
                /*     */
            });
            /*     */
        }
        /* 311 */
        while (executor.getActiveCount() > 0) {
            /*     */
            try {
                /* 313 */
                Thread.sleep(10000L);
                /* 314 */
            } catch (Exception exception) {
            }
            /*     */
        }
        /*     */
        /*     */
        /* 318 */
        executor.shutdown();
        /* 319 */
        log.info("migrateOfficeOriginUnitOrganogram: {} min , thread: {}", Long.valueOf((System.currentTimeMillis() - startTime.longValue()) / 60000L), Integer.valueOf(this.threadCount));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public List<OfficeOriginUnitOrganogram> migrateOfficeOriginUnitOrganograms(Long officeOriginUnitId) {
        /* 324 */
        List<OfficeOriginUnitOrganogram> officeOriginUnitOrganograms = this.serviceV1.getOfficeOriginUnitOrganogram(
                /* 325 */         OfficeOriginUnitOrganogramRequest.builder().originUnit(Integer.valueOf(officeOriginUnitId.intValue())).build());
        /*     */
        /*     */
        /*     */
        /* 329 */
        List<com.istl.database.entity.OfficeOriginUnitOrganogram> officeOriginUnitOrganogramList = BusinessToEntityConvertor.convertOfficeOriginUnitOrganogram(officeOriginUnitOrganograms);
        /*     */
        /* 331 */
        this.officeOriginUnitOrganogramRepo.saveAll(officeOriginUnitOrganogramList);
        /* 332 */
        return officeOriginUnitOrganograms;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void migrateDistrict() {
        /* 337 */
        List<District> districtsB = this.serviceV1.getDistrict(new DistrictRequest());
        /*     */
        /* 339 */
        List<com.istl.database.entity.District> districts = BusinessToEntityConvertor.convertDistrict(districtsB);
        /*     */
        /* 341 */
        this.districtRepo.saveAll(districts);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void migrateUpazilla() {
        /* 347 */
        List<Upazila> listB = this.serviceV1.getUpazila(new UpazilaRequest());
        /*     */
        /* 349 */
        List<com.istl.database.entity.Upazila> list = BusinessToEntityConvertor.convertUpazila(listB);
        /*     */
        /* 351 */
        this.upazilaRepo.saveAll(list);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void migrateThana() {
        /* 356 */
        List<Thana> listB = this.serviceV1.getThana(new ThanaRequest());
        /* 357 */
        List<com.istl.database.entity.Thana> list = BusinessToEntityConvertor.convertThana(listB);
        /* 358 */
        this.thanaRepo.saveAll(list);
        /*     */
    }

    /*     */
    /*     */
    public void migrateCityCorporation() {
        /* 362 */
        List<CityCorporation> listB = this.serviceV1.getCityCorporation(new CityCorporationRequest());
        /* 363 */
        List<com.istl.database.entity.CityCorporation> list = BusinessToEntityConvertor.convertCityCorporation(listB);
        /* 364 */
        this.cityCorporationRepo.saveAll(list);
        /*     */
    }

    /*     */
    /*     */
    public void migrateMunicipality() {
        /* 368 */
        List<Municipality> listB = this.serviceV1.getMunicipality(new MunicipalityRequest());
        /* 369 */
        List<com.istl.database.entity.Municipality> list = BusinessToEntityConvertor.convertMunicipality(listB);
        /* 370 */
        this.municipalityRepo.saveAll(list);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void migrateOffice() {
        /* 375 */
        List<Office> listB = this.serviceV1.getOffice(new OfficeRequest());
        /* 376 */
        List<com.istl.database.entity.Office> list = BusinessToEntityConvertor.convertOffice(listB);
        /*     */
        /* 378 */
        this.officeRepo.saveAll(list);
        /*     */
    }

    /*     */
    /*     */
    public void migrateOffice(List<Office> listB) {
        /* 382 */
        List<com.istl.database.entity.Office> list = BusinessToEntityConvertor.convertOffice(listB);
        /* 383 */
        this.officeRepo.saveAll(list);
        /*     */
    }

    /*     */
    /*     */
    public void migrateOfficeExtension() {
        /* 387 */
        long sum = 0L;
        /* 388 */
        List<com.istl.database.entity.OfficeMinistry> ministries = this.officeMinistryRepo.findAll();
        /* 389 */
        for (com.istl.database.entity.OfficeMinistry ministry : ministries) {
            /* 390 */
            List<Office> listB = this.serviceV1.getOffice(OfficeRequest.builder().ministry(Integer.valueOf(ministry.getId().intValue())).build());
            /* 391 */
            sum += listB.size();
            /* 392 */
            List<com.istl.database.entity.Office> list = BusinessToEntityConvertor.convertOffice(listB);
            /* 393 */
            log.info("migrateOffice: Ministry {} - {} Count: {}", new Object[]{ministry.getId(), ministry.getNameBangla(), Integer.valueOf(list.size())});
            /* 394 */
            this.officeRepo.saveAll(list);
            /*     */
        }
        /*     */
        /*     */
        /* 398 */
        log.info("migrateOffice: SUM {}", Long.valueOf(sum));
        /*     */
    }

    /*     */
    /*     */
    public void migrateOfficeOrigin() {
        /* 402 */
        List<OfficeOrigin> listB = this.serviceV1.getOfficeOrigin(new OfficeOriginRequest());
        /* 403 */
        List<com.istl.database.entity.OfficeOrigin> list = BusinessToEntityConvertor.convertOfficeOrigin(listB);
        /* 404 */
        this.officeOriginRepo.saveAll(list);
        /*     */
    }

    /*     */
    /*     */
    public void migrateOfficeOriginUnit() {
        /* 408 */
        List<OfficeOriginUnit> listB = this.serviceV1.getOfficeoriginUnit(new OfficeOriginUnitRequest());
        /* 409 */
        List<com.istl.database.entity.OfficeOriginUnit> list = BusinessToEntityConvertor.convertOfficeOriginUnit(listB);
        /* 410 */
        this.officeOriginUnitRepo.saveAll(list);
        /*     */
    }

    /*     */
    /*     */
    public void migrateEmployeeRecord() {
        /* 414 */
        List<EmpRecord> listB = this.serviceV1.getEmpRecord(new EmpRecordRequest());
        /* 415 */
        List<com.istl.database.entity.EmployeeRecord> list = BusinessToEntityConvertor.convertEmpRecord(listB);
        /* 416 */
        if (list != null && list.size() > 0) {
            /* 417 */
            this.employeeRecordRepository.saveAll(list);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void migrateEmployeeRecordExtension() {
        /* 424 */
        Long startTime = Long.valueOf(System.currentTimeMillis());
        /* 425 */
        List<Long> employeeRecordIds = this.employeeOfficeRepository.getAllEmployeeRecordIds();
        /*     */
        /* 427 */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(getThreadCount(), (ThreadFactory) new CustomizableThreadFactory("office-EmployeeRecord-"));
        /*     */
        /* 429 */
        List<List<Long>> lists = Utility.spiltArray(employeeRecordIds, this.threadCount);
        /* 430 */
        AtomicInteger finishedCount = new AtomicInteger(0);
        /*     */
        /* 432 */
        for (int i = 0; i < lists.size(); i++) {
            /* 433 */
            AtomicInteger finalI = new AtomicInteger(i);
            /* 434 */
            executor.execute(() -> {
                /*     */
                log.info("==STARTING FOR EmployeeRecord:{}", Integer.valueOf(finalI.get()));
                /*     */
                /*     */
                for (Long employeeRecordId : lists.get(finalI.get())) {
                    /*     */
                    List<EmpRecord> list = migrateEmpRecords(employeeRecordId);
                    /*     */
                }
                /*     */
                /*     */
                log.info("==DONE FOR EmployeeRecord :{}", Integer.valueOf(finalI.get()));
                /*     */
                finishedCount.getAndIncrement();
                /*     */
            });
            /*     */
        }
        /* 445 */
        while (executor.getActiveCount() > 0) {
            /*     */
            try {
                /* 447 */
                Thread.sleep(10000L);
                /* 448 */
            } catch (Exception exception) {
            }
            /*     */
        }
        /*     */
        /*     */
        /* 452 */
        executor.shutdown();
        /* 453 */
        log.info("EmployeeRecord: {} min , thread: {}", Long.valueOf((System.currentTimeMillis() - startTime.longValue()) / 60000L), Integer.valueOf(this.threadCount));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public List<EmpRecord> migrateEmpRecords(Long employeeRecordId) {
        /* 458 */
        List<EmpRecord> listB = this.serviceV1.getEmpRecord(EmpRecordRequest.builder().id(Integer.valueOf(employeeRecordId.intValue())).build());
        /* 459 */
        List<com.istl.database.entity.EmployeeRecord> list = BusinessToEntityConvertor.convertEmpRecord(listB);
        /* 460 */
        if (list != null && list.size() > 0) {
            /* 461 */
            this.employeeRecordRepository.saveAll(list);
            /*     */
        }
        /* 463 */
        return listB;
        /*     */
    }

    /*     */
    /*     */
    public void migrateEmployeeOffice() {
        /* 467 */
        List<EmpOffice> listB = this.serviceV1.getEmployeeOffice(new EmpOfficeRequest());
        /* 468 */
        List<com.istl.database.entity.EmployeeOffice> list = BusinessToEntityConvertor.convertEmpOffice(listB);
        /* 469 */
        if (list != null && list.size() > 0) {
            /* 470 */
            this.employeeOfficeRepository.saveAll(list);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void migrateEmployeeOfficeExtension() {
        /* 476 */
        Long startTime = Long.valueOf(System.currentTimeMillis());
        /*     */
        /* 478 */
        List<Long> officeIds = this.officeRepo.getAllOfficeID();
        /*     */
        /* 480 */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(getThreadCount(), (ThreadFactory) new CustomizableThreadFactory("office-EmployeeOffice-"));
        /*     */
        /* 482 */
        List<List<Long>> lists = Utility.spiltArray(officeIds, this.threadCount);
        /* 483 */
        AtomicInteger finishedCount = new AtomicInteger(0);
        /*     */
        /* 485 */
        for (int i = 0; i < lists.size(); i++) {
            /* 486 */
            AtomicInteger finalI = new AtomicInteger(i);
            /* 487 */
            executor.execute(() -> {
                /*     */
                log.info("==STARTING FOR EmployeeOffice:{}", Integer.valueOf(finalI.get()));
                /*     */
                /*     */
                Jedis jedis = this.redisService.jedisConnection();
                /*     */
                /*     */
                for (Long officeId : lists.get(finalI.get())) {
                    /*     */
                    List<EmpOffice> listB = this.serviceV1.getEmployeeOffice(EmpOfficeRequest.builder().office(Integer.valueOf(officeId.intValue())).build());
                    /*     */
                    /*     */
                    if (listB != null && listB.size() == 1000) {
                        /*     */
                        List<com.istl.database.entity.OfficeUnitOrganogram> orgs = this.officeUnitOrganogramRepository.findAllByOfficeId(Integer.valueOf(officeId.intValue()));
                        /*     */
                        /*     */
                        if (orgs != null && orgs.size() > 0) {
                            /*     */
                            for (com.istl.database.entity.OfficeUnitOrganogram organogram : orgs) {
                                /*     */
                                if (organogram != null) {
                                    /*     */
                                    migrateEmpOffices(officeId, organogram.getId());
                                    /*     */
                                }
                                /*     */
                            }
                            /*     */
                        }
                        /*     */
                    } else if (listB != null) {
                        /*     */
                        migrateEmpOffices(listB);
                        /*     */
                    }
                    /*     */
                    /*     */
                    this.redisService.task(jedis, listB);
                    /*     */
                }
                /*     */
                log.info("==DONE FOR EmployeeOffice :{}", Integer.valueOf(finalI.get()));
                /*     */
                finishedCount.getAndIncrement();
                /*     */
                jedis.close();
                /*     */
            });
            /*     */
        }
        /* 516 */
        while (executor.getActiveCount() > 0) {
            /*     */
            try {
                /* 518 */
                Thread.sleep(10000L);
                /* 519 */
            } catch (Exception exception) {
            }
            /*     */
        }
        /*     */
        /*     */
        /* 523 */
        executor.shutdown();
        /* 524 */
        log.info("EmployeeOffice: {} min , thread: {}", Long.valueOf((System.currentTimeMillis() - startTime.longValue()) / 60000L), Integer.valueOf(this.threadCount));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    private void migrateEmpOffices(Long officeId, Long id) {
        /* 530 */
        List<EmpOffice> listB = this.serviceV1.getEmployeeOffice(EmpOfficeRequest.builder().office(Integer.valueOf(officeId.intValue())).organogram(id + "").build());
        /* 531 */
        List<com.istl.database.entity.EmployeeOffice> list = BusinessToEntityConvertor.convertEmpOffice(listB);
        /* 532 */
        if (list != null && list.size() > 0)
            /*     */ {
            /* 534 */
            this.employeeOfficeRepository.saveAll(list);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    public List<EmpOffice> migrateEmpOffices(List<EmpOffice> listB) {
        /* 539 */
        List<com.istl.database.entity.EmployeeOffice> list = BusinessToEntityConvertor.convertEmpOffice(listB);
        /* 540 */
        if (list != null && list.size() > 0) {
            /* 541 */
            this.employeeOfficeRepository.saveAll(list);
            /*     */
        }
        /* 543 */
        return listB;
        /*     */
    }

    /*     */
    /*     */
    public List<EmpOffice> migrateEmpOffices(Long officeId) {
        /* 547 */
        List<EmpOffice> listB = this.serviceV1.getEmployeeOffice(EmpOfficeRequest.builder().office(Integer.valueOf(officeId.intValue())).build());
        /* 548 */
        List<com.istl.database.entity.EmployeeOffice> list = BusinessToEntityConvertor.convertEmpOffice(listB);
        /* 549 */
        if (list != null && list.size() > 0) {
            /* 550 */
            this.employeeOfficeRepository.saveAll(list);
            /*     */
        }
        /* 552 */
        return listB;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void migrateOfficeUnit() {
        /* 557 */
        List<OfficeUnit> listB = this.serviceV1.getOfficeUnit(new OfficeUnitRequest());
        /* 558 */
        List<com.istl.database.entity.OfficeUnit> list = BusinessToEntityConvertor.convertOfficeUnit(listB);
        /* 559 */
        if (list != null && list.size() > 0) {
            /* 560 */
            this.officeUnitRepository.saveAll(list);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void migrateOfficeUnitExtension() {
        /* 566 */
        Long startTime = Long.valueOf(System.currentTimeMillis());
        /*     */
        /* 568 */
        List<Long> officeIds = this.officeRepo.getAllOfficeID();
        /*     */
        /* 570 */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(getThreadCount(), (ThreadFactory) new CustomizableThreadFactory("office-OfficeUnit-"));
        /*     */
        /* 572 */
        List<List<Long>> lists = Utility.spiltArray(officeIds, this.threadCount);
        /* 573 */
        AtomicInteger finishedCount = new AtomicInteger(0);
        /*     */
        /* 575 */
        for (int i = 0; i < lists.size(); i++) {
            /* 576 */
            AtomicInteger finalI = new AtomicInteger(i);
            /* 577 */
            executor.execute(() -> {
                /*     */
                log.info("==STARTING FOR OfficeUnit:{}", Integer.valueOf(finalI.get()));
                /*     */
                /*     */
                for (Long officeId : lists.get(finalI.get())) {
                    /*     */
                    List<OfficeUnit> list = migrateOfficeUnits(officeId);
                    /*     */
                }
                /*     */
                /*     */
                log.info("==DONE FOR OfficeUnit :{}", Integer.valueOf(finalI.get()));
                /*     */
                finishedCount.getAndIncrement();
                /*     */
            });
            /*     */
        }
        /* 588 */
        while (executor.getActiveCount() > 0) {
            /*     */
            try {
                /* 590 */
                Thread.sleep(10000L);
                /* 591 */
            } catch (Exception exception) {
            }
            /*     */
        }
        /*     */
        /*     */
        /* 595 */
        executor.shutdown();
        /* 596 */
        log.info("migrateOfficeUnit: {} min , thread: {}", Long.valueOf((System.currentTimeMillis() - startTime.longValue()) / 60000L), Integer.valueOf(this.threadCount));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    private int getThreadCount() {
        /* 603 */
        if (Utility.CURRENT_MIGRATION_UNITS.get() == 1L) {
            /* 604 */
            return this.threadCount;
            /*     */
        }
        /* 606 */
        return Math.abs(this.threadCount / 2);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public List<OfficeUnit> migrateOfficeUnits(Long officeId) {
        /* 612 */
        List<OfficeUnit> listB = this.serviceV1.getOfficeUnit(OfficeUnitRequest.builder().office(Integer.valueOf(officeId.intValue())).build());
        /* 613 */
        List<com.istl.database.entity.OfficeUnit> officeUnits = BusinessToEntityConvertor.convertOfficeUnit(listB);
        /*     */
        /* 615 */
        this.officeUnitRepository.saveAll(officeUnits);
        /* 616 */
        return listB;
        /*     */
    }

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
    public void migrateOfficeUnitOrganogramExtension() {
        /* 631 */
        Long startTime = Long.valueOf(System.currentTimeMillis());
        /*     */
        /* 633 */
        List<Long> officeIds = this.officeRepo.getAllOfficeID();
        /*     */
        /* 635 */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(getThreadCount(), (ThreadFactory) new CustomizableThreadFactory("office-OfficeUnitOrganogram-"));
        /*     */
        /* 637 */
        List<List<Long>> lists = Utility.spiltArray(officeIds, this.threadCount);
        /* 638 */
        AtomicInteger finishedCount = new AtomicInteger(0);
        /*     */
        /* 640 */
        for (int i = 0; i < lists.size(); i++) {
            /* 641 */
            AtomicInteger finalI = new AtomicInteger(i);
            /* 642 */
            executor.execute(() -> {
                /*     */
                log.info("==STARTING FOR OfficeUnitOrganogram:{}", Integer.valueOf(finalI.get()));
                /*     */
                /*     */
                /*     */
                for (Long officeId : lists.get(finalI.get())) {
                    /*     */
                    List<OfficeUnitOrganogram> listB = this.serviceV1.getOfficeUnitOrganogram(OfficeUnitOrganoganogramRequest.builder().office(Integer.valueOf(officeId.intValue())).build());
                    /*     */
                    /*     */
                    if (listB.size() == 1000) {
                        /*     */
                        List<com.istl.database.entity.OfficeUnit> officeUnits = this.officeUnitRepository.findAllByOfficeId(Integer.valueOf(officeId.intValue()));
                        /*     */
                        /*     */
                        for (com.istl.database.entity.OfficeUnit officeUnit : officeUnits) {
                            /*     */
                            migrateOfficeUnitOrganograms(officeId, Integer.valueOf(officeUnit.getId().intValue()), Integer.valueOf(1)).size();
                            /*     */
                        }
                        /*     */
                    } else if (listB.size() > 0) {
                        /*     */
                        migrateOfficeUnitOrganograms(officeId).size();
                        /*     */
                    }
                    /*     */
                    /*     */
                    updateIsAdminStatus(officeId);
                    /*     */
                }
                /*     */
                /*     */
                log.info("==DONE FOR OfficeUnitOrganogram :{}", Integer.valueOf(finalI.get()));
                /*     */
                /*     */
                finishedCount.getAndIncrement();
                /*     */
            });
            /*     */
        }
        /*     */
        /* 668 */
        while (executor.getActiveCount() > 0) {
            /*     */
            try {
                /* 670 */
                Thread.sleep(10000L);
                /* 671 */
            } catch (Exception exception) {
            }
            /*     */
        }
        /*     */
        /*     */
        /* 675 */
        executor.shutdown();
        /* 676 */
        log.info("migrateOfficeUnitOrganogram: {} min , thread: {}", Long.valueOf((System.currentTimeMillis() - startTime.longValue()) / 60000L), Integer.valueOf(this.threadCount));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    private void updateIsAdminStatus(Long officeId) {
        /* 682 */
        List<OfficeUnitDesignationMapResponse.Office> officeUnitDesignationMap = this.serviceNew.getOfficeUnitDesignationMap(OfficeUnitDesignationMapRequest.builder()
/* 683 */.office_id(officeId.toString())
/* 684 */.build());
        /* 685 */
        for (OfficeUnitDesignationMapResponse.Office office : officeUnitDesignationMap) {
            /* 686 */
            if (office != null && office.units != null)
                /*     */ {
                /* 688 */
                for (Map.Entry<String, OfficeUnitDesignationMapResponse.Unit> unit : office.units.entrySet()) {
                    /*     */
                    /* 690 */
                    OfficeUnitDesignationMapResponse.Unit unitValue = unit.getValue();
                    /* 691 */
                    if (unitValue != null && unitValue.designations != null) {
                        /* 692 */
                        for (Map.Entry<String, OfficeUnitDesignationMapResponse.Designation> designation : unitValue.designations.entrySet()) {
                            /*     */
                            /* 694 */
                            OfficeUnitDesignationMapResponse.Designation d = designation.getValue();
                            /* 695 */
                            if (d != null && d.is_admin) {
                                /* 696 */
                                Optional<com.istl.database.entity.OfficeUnitOrganogram> officeUnitOrganogram = this.officeUnitOrganogramRepository.findById(new Long(d.designation_id));
                                /* 697 */
                                if (officeUnitOrganogram.isPresent()) {
                                    /* 698 */
                                    com.istl.database.entity.OfficeUnitOrganogram officeUnitOrganogram1 = officeUnitOrganogram.get();
                                    /* 699 */
                                    officeUnitOrganogram1.setIsAdmin(d.is_admin);
                                    /* 700 */
                                    this.officeUnitOrganogramRepository.save(officeUnitOrganogram1);
                                    /*     */
                                }
                                /*     */
                            }
                            /*     */
                        }
                        /*     */
                    }
                    /*     */
                }
                /*     */
            }
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    private List<OfficeUnitOrganogram> migrateOfficeUnitOrganograms(Long officeId, Integer unitId, Integer status) {
        /* 718 */
        List<OfficeUnitOrganogram> listB = this.serviceV1.getOfficeUnitOrganogram(OfficeUnitOrganoganogramRequest.builder()
/* 719 */.office(Integer.valueOf(officeId.intValue()))
/* 720 */.unit(unitId)
/* 721 */.status(status)
/* 722 */.build());
        /*     */
        /* 724 */
        List<com.istl.database.entity.OfficeUnitOrganogram> list = BusinessToEntityConvertor.convertOfficeUnitOrganogram(listB, officeId);
        /* 725 */
        if (list != null && list.size() > 0) {
            /* 726 */
            this.officeUnitOrganogramRepository.saveAll(list);
            /*     */
        }
        /* 728 */
        return listB;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public List<OfficeUnitOrganogram> migrateOfficeUnitOrganograms(Long officeId) {
        /* 735 */
        List<OfficeUnitOrganogram> listB = this.serviceV1.getOfficeUnitOrganogram(OfficeUnitOrganoganogramRequest.builder().office(Integer.valueOf(officeId.intValue())).build());
        /* 736 */
        List<com.istl.database.entity.OfficeUnitOrganogram> list = BusinessToEntityConvertor.convertOfficeUnitOrganogram(listB, officeId);
        /* 737 */
        if (list != null && list.size() > 0) {
            /* 738 */
            this.officeUnitOrganogramRepository.saveAll(list);
            /*     */
        }
        /*     */
        /* 741 */
        return listB;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void migrateOfficeOriginUnitOrganogram() {
        /* 746 */
        List<OfficeOriginUnitOrganogram> listB = this.serviceV1.getOfficeOriginUnitOrganogram(new OfficeOriginUnitOrganogramRequest());
        /* 747 */
        List<com.istl.database.entity.OfficeOriginUnitOrganogram> list = BusinessToEntityConvertor.convertOfficeOriginUnitOrganogram(listB);
        /* 748 */
        if (list != null && list.size() > 0) {
            /* 749 */
            this.officeOriginUnitOrganogramRepo.saveAll(list);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void migrateAll() {
        /* 757 */
        log.info("ALL MIGRATION START:  thread: {}", Integer.valueOf(this.threadCount));
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
        /*     */
        /*     */
        /*     */
        /*     */
        /*     */
        /*     */
        /* 780 */
        Long startTime = Long.valueOf(System.currentTimeMillis());
        /* 781 */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3, (ThreadFactory) new CustomizableThreadFactory("sub-migration-"));
        /*     */
        /*     */
        /* 784 */
        executor.execute(() -> {
            /*     */
            Utility.CURRENT_MIGRATION_UNITS.getAndIncrement();
            /*     */
            log.info("==STARTING migrateOthers");
            /*     */
            migrateOthers();
            /*     */
        });
        /* 789 */
        executor.execute(() -> {
            /*     */
            Utility.CURRENT_MIGRATION_UNITS.getAndIncrement();
            /*     */
            log.info("==STARTING migrateOfficeChain");
            /*     */
            migrateOfficeChain();
            /*     */
        });
        /* 794 */
        executor.execute(() -> {
            /*     */
            Utility.CURRENT_MIGRATION_UNITS.getAndIncrement();
            /*     */
            log.info("==STARTING migrateMinistryChain");
            /*     */
            migrateMinistryChain();
            /*     */
        });
        /* 799 */
        while (executor.getActiveCount() > 0) {
            /* 800 */
            Utility.CURRENT_MIGRATION_UNITS.set(executor.getActiveCount());
            /*     */
            try {
                /* 802 */
                Thread.sleep(10000L);
                /* 803 */
            } catch (Exception exception) {
            }
            /*     */
        }
        /*     */
        /*     */
        /* 807 */
        Utility.CURRENT_MIGRATION_UNITS.set(executor.getActiveCount());
        /* 808 */
        executor.shutdown();
        /* 809 */
        log.info("ALL MIGRATION END: {} min , thread: {}", Long.valueOf((System.currentTimeMillis() - startTime.longValue()) / 60000L), Integer.valueOf(this.threadCount));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void redisUpdateOnStartUp() {
        /* 817 */
        Long startTime = Long.valueOf(System.currentTimeMillis());
        /*     */
        /* 819 */
        List<Long> empOfficeIds = this.employeeOfficeRepository.getAllEmployeeOfficeIds();
        /*     */
        /* 821 */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(getThreadCount(), (ThreadFactory) new CustomizableThreadFactory("redisUpdate-"));
        /*     */
        /* 823 */
        List<List<Long>> lists = Utility.spiltArray(empOfficeIds, this.threadCount);
        /*     */
        /* 825 */
        for (int i = 0; i < lists.size(); i++) {
            /* 826 */
            AtomicInteger finalI = new AtomicInteger(i);
            /* 827 */
            executor.execute(() -> {
                /*     */
                log.info("==STARTING FOR redisUpdateOnStartUp:{}", Integer.valueOf(finalI.get()));
                /*     */
                /*     */
                Jedis jedis = this.redisService.jedisConnection();
                /*     */
                /*     */
                List<Long> empOfcIds = lists.get(finalI.get());
                /*     */
                /*     */
                int len = empOfcIds.size();
                /*     */
                /*     */
                List<List<Long>> sublists = Utility.spiltArrayByMaxSize(empOfcIds, 1000);
                /*     */
                /*     */
                for (int j = 0; j < sublists.size(); j++) {
                    /*     */
                    List<com.istl.database.entity.EmployeeOffice> listB = this.employeeOfficeRepository.findAllByIdIn(sublists.get(j));
                    /*     */
                    this.redisService.taskSync(jedis, listB);
                    /*     */
                }
                /*     */
                log.info("==DONE FOR redisUpdateOnStartUp :{}", Integer.valueOf(finalI.get()));
                /*     */
                jedis.close();
                /*     */
            });
            /*     */
        }
        /* 846 */
        while (executor.getActiveCount() > 0) {
            /*     */
            try {
                /* 848 */
                Thread.sleep(10000L);
                /* 849 */
            } catch (Exception exception) {
            }
            /*     */
        }
        /*     */
        /*     */
        /* 853 */
        executor.shutdown();
        /* 854 */
        log.info("redisUpdateOnStartUp: {} min , thread: {}", Long.valueOf((System.currentTimeMillis() - startTime.longValue()) / 60000L), Integer.valueOf(this.threadCount));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    @Async
    /*     */ public void migrateOfficeChain() {
        /* 862 */
        log.info("updateOfficeStatusToFalse start");
        /* 863 */
        this.officeRepo.updateOfficeStatusToFalse();
        /* 864 */
        log.info("updateOfficeStatusToFalse end");
        /*     */
        /* 866 */
        migrateOffice();
        /* 867 */
        migrateOfficeUnitExtension();
        /* 868 */
        migrateOfficeUnitOrganogramExtension();
        /* 869 */
        log.info("updateEmployeeOfficeStatusToFalse start");
        /* 870 */
        this.employeeOfficeRepository.updateEmployeeOfficeStatusToFalse(Boolean.FALSE);
        /* 871 */
        log.info("updateEmployeeOfficeStatusToFalse end");
        /*     */
        /* 873 */
        migrateEmployeeOfficeExtension();
        /* 874 */
        migrateEmployeeRecordExtension();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    @Async
    /*     */ public void migrateMinistryChain() {
        /* 881 */
        migrateOfficeMinistry();
        /* 882 */
        migrateOfficeLayerExtension();
        /* 883 */
        migrateOfficeOriginExtension();
        /* 884 */
        migrateOfficeOriginUnitExtension();
        /* 885 */
        migrateOfficeOriginUnitOrganogramExtension();
        /*     */
    }

    /*     */
    /*     */
    @Async
    /*     */ public void migrateOthers() {
        /* 890 */
        migrateCustomOfficeLayer();
        /* 891 */
        migrateDivision();
        /* 892 */
        migrateDistrict();
        /* 893 */
        migrateUpazilla();
        /* 894 */
        migrateThana();
        /* 895 */
        migrateCityCorporation();
        /* 896 */
        migrateMunicipality();
        /*     */
    }
    /*     */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\business\manager\MigrationService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */