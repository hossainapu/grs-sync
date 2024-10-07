/*    */ package com.istl.database.manager;
/*    */ 
/*    */ import javax.persistence.EntityManager;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class BaseEntityManager
/*    */ {
/*    */   private final EntityManager em;
/*    */   
/*    */   public BaseEntityManager(EntityManager em) {
/* 13 */     this.em = em;
/*    */   }
/*    */   
/*    */   public <T> T save(T entity) {
/* 17 */     this.em.persist(entity);
/* 18 */     this.em.flush();
/* 19 */     return entity;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\database\manager\BaseEntityManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */