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
/*    */ public class EmployeeOfficeActor extends UntypedAbstractActor {
/* 11 */   private static final Logger log = LoggerFactory.getLogger(com.istl.actor.EmployeeOfficeActor.class);
/*    */ 
/*    */   
/*    */   private final MigrationService migrationService;
/*    */ 
/*    */   
/*    */   private final DoptorConnectorServiceV1 service;
/*    */ 
/*    */   
/*    */   public EmployeeOfficeActor(MigrationService migrationService, DoptorConnectorServiceV1 service) {
/* 21 */     this.migrationService = migrationService;
/* 22 */     this.service = service;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onReceive(Object message) throws Throwable {
/* 27 */     if (message instanceof Long) {
/* 28 */       Long officeId = (Long)message;
/*    */       
/* 30 */       log.info("officeId: {} ", officeId);
/* 31 */       this.migrationService.migrateEmpOffices(officeId);
/* 32 */       getSender().tell(officeId, getSelf());
/*    */     }
/*    */     else {
/*    */       
/* 36 */       unhandled(message);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\actor\EmployeeOfficeActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */