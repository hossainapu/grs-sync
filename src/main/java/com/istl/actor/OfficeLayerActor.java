/*    */ package com.istl.actor;

/*    */ import akka.actor.UntypedAbstractActor;
/*    */ import com.istl.business.entity.OfficeLayer;
import com.istl.business.manager.DoptorConnectorServiceV1;
/*    */ import com.istl.business.manager.MigrationService;
/*    */ import java.util.List;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ @Scope("prototype")
/*    */ public class OfficeLayerActor extends UntypedAbstractActor {
/* 14 */   private static final Logger log = LoggerFactory.getLogger(com.istl.actor.OfficeLayerActor.class);
/*    */ 
/*    */   
/*    */   private final MigrationService migrationService;
/*    */   
/*    */   private final DoptorConnectorServiceV1 service;
/*    */ 
/*    */   
/*    */   public OfficeLayerActor(MigrationService migrationService, DoptorConnectorServiceV1 service) {
/* 23 */     this.migrationService = migrationService;
/* 24 */     this.service = service;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onReceive(Object message) throws Throwable {
/* 29 */     if (message instanceof Long) {
/* 30 */       Long ministryId = (Long)message;
/* 31 */       log.info("ministryId: {} ", ministryId);
/*    */       
/* 33 */       List<OfficeLayer> officeLayerB = this.migrationService.migrateOfficeLayers(ministryId);
/*    */       
/* 35 */       getSender().tell(ministryId, getSelf());
/*    */     } else {
/* 37 */       unhandled(message);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\actor\OfficeLayerActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */