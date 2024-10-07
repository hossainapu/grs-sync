/*    */ package com.istl.actor;

/*    */ import akka.actor.ActorRef;
/*    */ import akka.actor.ActorSystem;
/*    */ import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
/*    */ import akka.pattern.Patterns;
/*    */ import akka.util.Timeout;
/*    */ import com.istl.business.entity.OfficeOriginUnit;
/*    */ import com.istl.business.manager.DoptorConnectorServiceV1;
/*    */ import com.istl.business.manager.MigrationService;
/*    */ //import com.istl.config.SpringExtension;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Component;
/*    */ import scala.concurrent.duration.FiniteDuration;
/*    */ 
/*    */ @Component
/*    */ @Scope("prototype")
/*    */ public class OfficeOriginUnitActor extends UntypedAbstractActor {
/* 22 */   private static final Logger log = LoggerFactory.getLogger(com.istl.actor.OfficeOriginUnitActor.class);
/*    */   
/*    */   private final MigrationService migrationService;
/*    */   
/*    */   private final DoptorConnectorServiceV1 service;
/*    */   
/*    */   private final ActorSystem system;
/*    */   
/*    */   private ActorRef officeOriginUnitOrganogramActorRef;
/*    */   
/*    */   public OfficeOriginUnitActor(MigrationService migrationService, DoptorConnectorServiceV1 service, ActorSystem system) {
/* 33 */     this.migrationService = migrationService;
/* 34 */     this.service = service;
/* 35 */     this.system = system;
/* 36 */     this.officeOriginUnitOrganogramActorRef = system.actorOf(Props.create(OfficeOriginUnitOrganogramActor.class), "officeOriginUnitOrganogram");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onReceive(Object message) throws Throwable {
/* 42 */     if (message instanceof Long) {
/* 43 */       Long officeOriginId = (Long)message;
/* 44 */       log.info("officeOriginId: {} ", officeOriginId);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 49 */       FiniteDuration duration = FiniteDuration.create(1L, TimeUnit.DAYS);
/* 50 */       Timeout timeout = Timeout.durationToTimeout(duration);
/*    */       
/* 52 */       List<OfficeOriginUnit> officeOriginUnits = this.migrationService.migrateOfficeOriginUnits(officeOriginId);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 57 */       for (OfficeOriginUnit officeOriginUnit : officeOriginUnits) {
/* 58 */         long officeOriginUnitId = officeOriginUnit.getId().longValue();
/* 59 */         log.info("officeOriginUnitId: {} ", Long.valueOf(officeOriginUnitId));
/* 60 */         Patterns.ask(this.officeOriginUnitOrganogramActorRef, Long.valueOf(officeOriginUnitId), timeout);
/*    */       } 
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
/* 78 */       getSender().tell(officeOriginId, getSelf());
/*    */     } else {
/* 80 */       unhandled(message);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\actor\OfficeOriginUnitActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */