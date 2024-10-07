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
/*    */ public class OthersActor extends UntypedAbstractActor {
/* 11 */   private static final Logger log = LoggerFactory.getLogger(com.istl.actor.OthersActor.class);
/*    */ 
/*    */   
/*    */   private final MigrationService migrationService;
/*    */   
/*    */   private final DoptorConnectorServiceV1 service;
/*    */ 
/*    */   
/*    */   public OthersActor(MigrationService migrationService, DoptorConnectorServiceV1 service) {
/* 20 */     this.migrationService = migrationService;
/* 21 */     this.service = service;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onReceive(Object message) throws Throwable {
/* 28 */     this.migrationService.migrateCustomOfficeLayer();
/* 29 */     this.migrationService.migrateDivision();
/* 30 */     this.migrationService.migrateDistrict();
/* 31 */     this.migrationService.migrateUpazilla();
/* 32 */     this.migrationService.migrateThana();
/* 33 */     this.migrationService.migrateCityCorporation();
/*    */     
/* 35 */     getSender().tell(message, getSelf());
/*    */   }
/*    */ }
