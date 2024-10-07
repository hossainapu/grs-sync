/*    */ package com.istl.actor;

/*    */ 
/*    */ import akka.actor.ActorRef;
/*    */ import akka.actor.ActorSystem;
/*    */ import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
/*    */ import akka.pattern.Patterns;
/*    */ import akka.util.Timeout;
/*    */ import com.istl.business.entity.OfficeMinistry;
/*    */ import com.istl.business.manager.DoptorConnectorServiceV1;
/*    */ import com.istl.business.manager.MigrationService;
/*    */ import com.istl.business.request.OfficeMinistryRequest;
/*    */ //import com.istl.config.SpringExtension;
/*    */ import com.istl.database.repository.EmployeeOfficeRepository;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Component;
/*    */ import scala.concurrent.duration.FiniteDuration;
/*    */ 
/*    */ @Component
/*    */ @Scope("prototype")
/*    */ public class OfficeMinistryActor
/*    */   extends UntypedAbstractActor {
/* 27 */   private static final Logger log = LoggerFactory.getLogger(com.istl.actor.OfficeMinistryActor.class);
/*    */ 
/*    */   
/*    */   private final ActorSystem system;
/*    */   
/*    */   private final MigrationService migrationService;
/*    */   
/*    */   private final DoptorConnectorServiceV1 service;
/*    */   
/*    */   private final EmployeeOfficeRepository employeeOfficeRepository;
/*    */ 
/*    */   
/*    */   public OfficeMinistryActor(ActorSystem system, MigrationService migrationService, DoptorConnectorServiceV1 service, EmployeeOfficeRepository employeeOfficeRepository) {
/* 40 */     this.system = system;
/* 41 */     this.migrationService = migrationService;
/* 42 */     this.service = service;
/* 43 */     this.employeeOfficeRepository = employeeOfficeRepository;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onReceive(Object o) throws Throwable {
/* 50 */     log.info("message: {} ", o);
/* 51 */     ActorRef officeLayerActorRef = this.system.actorOf(Props.create(OfficeLayerActor.class), "officeLayer");
/* 52 */     ActorRef officeOriginActorRef = this.system.actorOf(Props.create(OfficeOriginActor.class), "officeOrigin");
/*    */     
/* 54 */     List<OfficeMinistry> listB = this.service.getOfficeMinistry(new OfficeMinistryRequest());
/* 55 */     this.migrationService.migrateOfficeMinistry(listB);
/*    */ 
/*    */     
/* 58 */     FiniteDuration duration = FiniteDuration.create(1L, TimeUnit.DAYS);
/* 59 */     Timeout timeout = Timeout.durationToTimeout(duration);
/*    */     
/* 61 */     AtomicLong OFFICE_SUM = new AtomicLong(listB.size());
/* 62 */     AtomicLong OfficeCount = new AtomicLong(0L);
/*    */     
/* 64 */     for (OfficeMinistry officeMinistry : listB) {
/* 65 */       Long officeMinistryId = Long.valueOf(officeMinistry.getId().longValue());
/* 66 */       log.info("officeMinistryId: {} ", officeMinistryId);
/*    */       
/* 68 */       Patterns.ask(officeOriginActorRef, officeMinistryId, timeout);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 76 */       Patterns.ask(officeLayerActorRef, officeMinistryId, timeout);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 94 */     getSender().tell(Long.valueOf(1L), getSelf());
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\actor\OfficeMinistryActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */