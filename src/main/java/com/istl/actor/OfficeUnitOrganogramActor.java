/*    */ package com.istl.actor;

/*    */ import akka.actor.UntypedAbstractActor;
/*    */ import com.istl.business.manager.DoptorConnectorServiceV1;
/*    */ import com.istl.business.manager.MigrationService;
/*    */ import com.istl.utils.Utility;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*    */
/*    */ @Component
/*    */ @Scope("prototype")
/*    */ public class OfficeUnitOrganogramActor extends UntypedAbstractActor {
/* 12 */   private static final Logger log = LoggerFactory.getLogger(com.istl.actor.OfficeUnitOrganogramActor.class);
/*    */ 
/*    */   
/*    */   private final MigrationService migrationService;
/*    */ 
/*    */   
/*    */   private final DoptorConnectorServiceV1 service;
/*    */ 
/*    */ 
/*    */   
/*    */   public OfficeUnitOrganogramActor(MigrationService migrationService, DoptorConnectorServiceV1 service) {
/* 23 */     this.migrationService = migrationService;
/* 24 */     this.service = service;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onReceive(Object message) throws Throwable {
/* 30 */     Utility.OUO_CALL_COUNT.getAndIncrement();
/* 31 */     if (message instanceof Long) {
/* 32 */       Long OfficeId = (Long)message;
/* 33 */       log.info("OfficeId: {} ", OfficeId);
/*    */       
/* 35 */       this.migrationService.migrateOfficeUnitOrganograms(OfficeId);
/*    */       
/* 37 */       getSender().tell(OfficeId, getSelf());
/*    */     } else {
/* 39 */       unhandled(message);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\actor\OfficeUnitOrganogramActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */