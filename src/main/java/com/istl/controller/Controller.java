/*    */ package com.istl.controller;
/*    */
/*    */ import com.istl.business.manager.MigrationService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMethod;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class Controller
/*    */ {
/*    */   @Autowired
/*    */   private MigrationService migrationService;
/*    */   
/*    */   @RequestMapping(value = {"/api/grievance"}, method = {RequestMethod.GET})
/*    */   public String callMigration() {
/* 29 */     this.migrationService.migrateAll();
/* 31 */     return "ok";
/*    */   }
/*    */ }
