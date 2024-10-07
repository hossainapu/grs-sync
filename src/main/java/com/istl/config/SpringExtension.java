//
///*    */ package com.istl.config;
///*    */
///*    */ import akka.actor.AbstractExtensionId;
///*    */ import akka.actor.ExtendedActorSystem;
///*    */ import akka.actor.Extension;
///*    */ import com.istl.config.SpringExtension;
///*    */
///*    */ public class SpringExtension
///*    */   extends AbstractExtensionId<SpringExtension.SpringExt>
///*    */ {
///* 11 */   public static final SpringExtension SPRING_EXTENSION_PROVIDER = new SpringExtension();
///*    */
///*    */
///*    */   public SpringExt createExtension(ExtendedActorSystem system) {
///* 15 */     return new SpringExt();
///*    */   }
///*    */ }
//
//
///* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\config\SpringExtension.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       1.1.3
// */