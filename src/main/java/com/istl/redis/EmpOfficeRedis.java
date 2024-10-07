/*     */ package com.istl.redis;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.istl.redis.Utils;
/*     */ import java.io.Serializable;
import java.util.Date;
/*     */ import javax.persistence.*;
/*     */
/*     */
/*     */ import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */
@Builder
/*     */ @Entity
/*     */ @Table(name = "employee_offices_redis")
/*     */ public class EmpOfficeRedis implements Serializable {
/*  16 */   public void setTableId(Long tableId) { this.tableId = tableId; } public void setId(Long id) { this.id = id; } public void setOfficeId(Integer officeId) { this.officeId = officeId; } public void setOfficeUnitId(Integer officeUnitId) { this.officeUnitId = officeUnitId; } public void setOfficeUnitOrganogramId(Integer officeUnitOrganogramId) { this.officeUnitOrganogramId = officeUnitOrganogramId; } public void setEmployeeRecordId(Integer employeeRecordId) { this.employeeRecordId = employeeRecordId; } public void setPreviousRecord(String previousRecord) { this.previousRecord = previousRecord; } public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; } @JsonIgnore public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
/*     */    public EmpOfficeRedis() {}
/*  18 */   public EmpOfficeRedis(Long tableId, Long id, Integer officeId, Integer officeUnitId, Integer officeUnitOrganogramId, Integer employeeRecordId, String previousRecord, Date updatedAt, Date createdAt) { this.tableId = tableId; this.id = id; this.officeId = officeId; this.officeUnitId = officeUnitId; this.officeUnitOrganogramId = officeUnitOrganogramId; this.employeeRecordId = employeeRecordId; this.previousRecord = previousRecord; this.updatedAt = updatedAt; this.createdAt = createdAt; } public static EmpOfficeRedisBuilder builder() {
/*  19 */     return new EmpOfficeRedisBuilder();
/*  20 */   } private static final Logger log = LoggerFactory.getLogger(com.istl.redis.EmpOfficeRedis.class);
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name = "table_id")
/*     */   private Long tableId; @Column(name = "id")
/*     */   private Long id;
/*     */   @Column(name = "office_id")
/*     */   private Integer officeId;
/*     */   @Column(name = "office_unit_id")
/*     */   private Integer officeUnitId;
/*     */   
/*  31 */   public Long getTableId() { return this.tableId; } @Column(name = "office_unit_organogram_id") private Integer officeUnitOrganogramId; @Column(name = "employee_record_id") private Integer employeeRecordId; @Column(length = 255, name = "previous_record") private String previousRecord; @Column(name = "updated_at") @UpdateTimestamp
/*     */   private Date updatedAt; @JsonIgnore
/*     */   @CreationTimestamp
/*     */   @Column(name = "created_at")
/*  35 */   private Date createdAt; public Long getId() { return this.id; }
/*     */   
/*     */   public Integer getOfficeId() {
/*  38 */     return this.officeId;
/*     */   }
/*     */   public Integer getOfficeUnitId() {
/*  41 */     return this.officeUnitId;
/*     */   }
/*     */   public Integer getOfficeUnitOrganogramId() {
/*  44 */     return this.officeUnitOrganogramId;
/*     */   }
/*     */   public Integer getEmployeeRecordId() {
/*  47 */     return this.employeeRecordId;
/*     */   }
/*     */   public String getPreviousRecord() {
/*  50 */     return this.previousRecord;
/*     */   }
/*     */   
/*     */   public Date getUpdatedAt() {
/*  54 */     return this.updatedAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getCreatedAt() {
/*  59 */     return this.createdAt;
/*     */   }
/*     */   public static com.istl.redis.EmpOfficeRedis getEmpOfficeRedis(String redisValue) {
/*  62 */     String[] eo = redisValue.split(Utils.SEPARATOR_REGEX);
/*     */     
/*     */     try {
/*  65 */       return builder()
/*  66 */         .id(new Long(eo[1]))
/*  67 */         .officeId(Integer.valueOf(Integer.parseInt(eo[2])))
/*  68 */         .officeUnitId(Integer.valueOf(Integer.parseInt(eo[3])))
/*  69 */         .officeUnitOrganogramId(Integer.valueOf(Integer.parseInt(eo[4])))
/*  70 */         .employeeRecordId(Integer.valueOf(Integer.parseInt(eo[5])))
/*     */         
/*  72 */         .build();
/*  73 */     } catch (Exception e) {
/*  74 */       e.printStackTrace();
/*  75 */       log.info(">>" + redisValue);
/*     */       
/*  77 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  84 */     return "EmpOfficeRedis{id=" + this.id + ", officeId=" + this.officeId + ", officeUnitId=" + this.officeUnitId + ", officeUnitOrganogramId=" + this.officeUnitOrganogramId + ", employeeRecordId=" + this.employeeRecordId + '}';
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRedisId() {
/*  95 */     return Utils.NAME + Utils.SEPARATOR + this.officeId + Utils.SEPARATOR + this.officeUnitOrganogramId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRedisValue() {
/* 105 */     return Utils.NAME + Utils.SEPARATOR + this.id + Utils.SEPARATOR + this.officeId + Utils.SEPARATOR + this.officeUnitId + Utils.SEPARATOR + this.officeUnitOrganogramId + Utils.SEPARATOR + this.employeeRecordId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean same(com.istl.redis.EmpOfficeRedis e) {
/* 114 */     return (this.officeUnitId.equals(e.getOfficeUnitId()) && this.officeUnitOrganogramId
/* 115 */       .equals(e.getOfficeUnitOrganogramId()) && this.employeeRecordId
/* 116 */       .equals(e.getEmployeeRecordId()));
/*     */   }
/*     */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\redis\EmpOfficeRedis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */