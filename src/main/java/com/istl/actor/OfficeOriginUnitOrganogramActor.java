/*    */ package com.istl.actor;

/*    */ import akka.actor.UntypedAbstractActor;
/*    */ import com.istl.business.manager.DoptorConnectorServiceV1;
/*    */ import com.istl.business.manager.MigrationService;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*    */
/*    */ @Component
/*    */ @Scope("prototype")
/*    */ public class OfficeOriginUnitOrganogramActor extends UntypedAbstractActor {
/* 11 */   private static final Logger log = LoggerFactory.getLogger(com.istl.actor.OfficeOriginUnitOrganogramActor.class);
/*    */ 
/*    */   
/*    */   private final MigrationService migrationService;
/*    */   
/*    */   private final DoptorConnectorServiceV1 service;
/*    */ 
/*    */   
/*    */   public OfficeOriginUnitOrganogramActor(MigrationService migrationService, DoptorConnectorServiceV1 service) {
/* 20 */     this.migrationService = migrationService;
/* 21 */     this.service = service;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onReceive(Object message) throws Throwable {
/* 26 */     if (message instanceof Long) {
/* 27 */       Long officeOriginUnitId = (Long)message;
/* 28 */       log.info("officeOriginUnitId: {} ", officeOriginUnitId);
/*    */       
/* 30 */       this.migrationService.migrateOfficeOriginUnitOrganograms(officeOriginUnitId);
/*    */       
/* 32 */       getSender().tell(officeOriginUnitId, getSelf());
/*    */     } else {
/* 34 */       unhandled(message);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\actor\OfficeOriginUnitOrganogramActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */