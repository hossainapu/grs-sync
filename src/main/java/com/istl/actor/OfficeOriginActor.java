/*    */ package com.istl.actor;

/*    */ 
/*    */ import akka.actor.ActorRef;
/*    */ import akka.actor.ActorSystem;
/*    */ import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
/*    */ import akka.pattern.Patterns;
/*    */ import akka.util.Timeout;
/*    */ import com.istl.business.entity.OfficeOrigin;
/*    */ import com.istl.business.entity.OfficeOriginUnit;
import com.istl.business.manager.DoptorConnectorServiceV1;
/*    */ import com.istl.business.manager.MigrationService;
/*    */ //import com.istl.config.SpringExtension;
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
/*    */ public class OfficeOriginActor
/*    */   extends UntypedAbstractActor {
/* 25 */   private static final Logger log = LoggerFactory.getLogger(com.istl.actor.OfficeOriginActor.class);
/*    */   
/*    */   private final MigrationService migrationService;
/*    */   
/*    */   private final DoptorConnectorServiceV1 service;
/*    */   
/*    */   private final ActorSystem system;
/*    */   
/*    */   ActorRef officeOriginUnitActorRef;
/*    */   
/*    */   public OfficeOriginActor(MigrationService migrationService, DoptorConnectorServiceV1 service, ActorSystem system) {
/* 36 */     this.migrationService = migrationService;
/* 37 */     this.service = service;
/* 38 */     this.system = system;
/* 39 */     this.officeOriginUnitActorRef = system.actorOf(Props.create(OfficeOriginUnitActor.class), "officeOriginUnit");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onReceive(Object message) throws Throwable {
/* 45 */     if (message instanceof Long) {
/* 46 */       Long ministryId = (Long)message;
/* 47 */       log.info("ministryId: {} ", ministryId);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 52 */       FiniteDuration duration = FiniteDuration.create(1L, TimeUnit.DAYS);
/* 53 */       Timeout timeout = Timeout.durationToTimeout(duration);
/*    */       
/* 55 */       List<OfficeOrigin> officeOrigins = this.migrationService.migrateOfficeOrigins(ministryId);
/*    */ 
/*    */       
/* 58 */       AtomicLong TOTAL_SUM = new AtomicLong(officeOrigins.size());
/* 59 */       AtomicLong currentSum = new AtomicLong(0L);
/* 60 */       for (OfficeOrigin officeOrigin : officeOrigins) {
/* 61 */         long officeOriginId = officeOrigin.getId().longValue();
/* 62 */         log.info("officeOriginId: {} ", Long.valueOf(officeOriginId));
/*    */         
/* 64 */         Patterns.ask(this.officeOriginUnitActorRef, Long.valueOf(officeOriginId), timeout);
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
/* 81 */       getSender().tell(ministryId, getSelf());
/*    */     } else {
/*    */       
/* 84 */       unhandled(message);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\actor\OfficeOriginActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */