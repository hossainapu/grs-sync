/*     */ package com.istl.actor;

/*     */ import akka.actor.ActorRef;
/*     */ import akka.actor.ActorSystem;
/*     */ import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
/*     */ import akka.pattern.Patterns;
/*     */ import akka.util.Timeout;
/*     */ import com.istl.business.entity.Office;
/*     */ import com.istl.business.manager.DoptorConnectorServiceV1;
/*     */ import com.istl.business.manager.MigrationService;
/*     */ import com.istl.business.request.OfficeRequest;
/*     */ import com.istl.database.repository.EmployeeOfficeRepository;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*     */ import scala.Function1;
/*     */ import scala.concurrent.Future;
/*     */ import scala.concurrent.duration.FiniteDuration;
/*     */ 
/*     */ @Component
/*     */ @Scope("prototype")
/*     */ public class OfficeActor extends UntypedAbstractActor {
/*  27 */   private static final Logger log = LoggerFactory.getLogger(com.istl.actor.OfficeActor.class);
/*     */ 
/*     */   
/*     */   private final ActorSystem system;
/*     */   
/*     */   private final MigrationService migrationService;
/*     */   
/*     */   private final DoptorConnectorServiceV1 service;
/*     */   
/*     */   private final EmployeeOfficeRepository employeeOfficeRepository;
/*     */ 
/*     */   
/*     */   public OfficeActor(ActorSystem system, MigrationService migrationService, DoptorConnectorServiceV1 service, EmployeeOfficeRepository employeeOfficeRepository) {
/*  40 */     this.system = system;
/*  41 */     this.migrationService = migrationService;
/*  42 */     this.service = service;
/*  43 */     this.employeeOfficeRepository = employeeOfficeRepository;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onReceive(Object o) throws Throwable {
/*  50 */     log.info("message: {} ", o);
/*  51 */     ActorRef officeUnitActorRef = this.system.actorOf(Props.create(OfficeUnitActor.class), "officeUnit");
/*  52 */     ActorRef officeUnitOrganogramActorRef = this.system.actorOf(Props.create(OfficeUnitOrganogramActor.class), "officeUnitOrganogram");
/*  53 */     ActorRef employeeOfficeActorRef = this.system.actorOf(Props.create(EmployeeOfficeActor.class), "employeeOffice");
/*  54 */     ActorRef employeeRecordActorRef = this.system.actorOf(Props.create(EmployeeRecordActor.class), "employeeRecord");
/*  55 */     List<Office> listB = this.service.getOffice(new OfficeRequest());
/*  56 */     this.migrationService.migrateOffice(listB);
/*     */ 
/*     */     
/*  59 */     FiniteDuration duration = FiniteDuration.create(1L, TimeUnit.DAYS);
/*  60 */     Timeout timeout = Timeout.durationToTimeout(duration);
/*  61 */     Long officeId;
/*  62 */     AtomicLong OFFICE_SUM = new AtomicLong(listB.size());
/*  63 */     AtomicLong OfficeCount = new AtomicLong(0L);
/*     */     
/*  65 */     for (Office office : listB) {
/*  66 */       officeId = Long.valueOf(office.getId().longValue());
/*  67 */       log.info("officeId: {} ", officeId);
/*     */       
/*  69 */       Future<Object> officeUnitOrganogramActorResult = Patterns.ask(officeUnitOrganogramActorRef, officeId, timeout);
/*  70 */       officeUnitOrganogramActorResult.onComplete((Function1)new Object(), this.system
/*     */ 
/*     */ 
/*     */           
/*  74 */           .dispatcher());
/*     */ 
/*     */       
/*  77 */       Future<Object> officeUnitResult = Patterns.ask(officeUnitActorRef, officeId, timeout);
/*  78 */       officeUnitResult.onComplete((Function1)new Object(), this.system
/*     */ 
/*     */ 
/*     */           
/*  82 */           .dispatcher());
/*     */       
/*  84 */       Future<Object> employeeOfficeResult = Patterns.ask(employeeOfficeActorRef, officeId, timeout);
/*     */       
/*  86 */       employeeOfficeResult.onComplete((Function1)new Object(), this.system
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  91 */           .dispatcher());
/*     */     } 
/*     */     
/*  94 */     while (OfficeCount.get() != OFFICE_SUM.get()) {
/*  95 */       log.info("migrating Emp Office...", o);
/*  96 */       Thread.sleep(300000L);
/*     */     } 
/*  98 */     log.info("employeeOffice end {}", OfficeCount);
/*     */ 
/*     */     
/* 101 */     List<Long> employeeRecordIds = this.employeeOfficeRepository.getAllEmployeeRecordIds();
/* 102 */     OfficeCount.set(0L);
/* 103 */     OFFICE_SUM.set(employeeRecordIds.size());
/*     */ 
/*     */     
/* 106 */     for (Long employeeRecordId : employeeRecordIds) {
/*     */       
/* 108 */       Future<Object> employeeRecordAResult = Patterns.ask(employeeRecordActorRef, employeeRecordId, timeout);
/* 109 */       employeeRecordAResult.onComplete((Function1)new Object(), this.system
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 114 */           .dispatcher());
/*     */     } 
/*     */ 
/*     */     
/* 118 */     while (OfficeCount.get() != OFFICE_SUM.get()) {
/* 119 */       log.info("migrating employeeRecord...", o);
/* 120 */       Thread.sleep(300000L);
/*     */     } 
/*     */     
/* 123 */     getSender().tell(Long.valueOf(1L), getSelf());
/*     */   }
/*     */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\actor\OfficeActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */