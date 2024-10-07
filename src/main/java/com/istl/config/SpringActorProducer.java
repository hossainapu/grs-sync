
/*    */
package com.istl.config;
/*    */
/*    */

import akka.actor.Actor;
/*    */ import akka.actor.IndirectActorProducer;
/*    */ import org.springframework.context.ApplicationContext;

/*    */
/*    */ public class SpringActorProducer
        /*    */ implements IndirectActorProducer
        /*    */ {
    /*    */   private ApplicationContext applicationContext;
    /*    */   private String beanActorName;

    /*    */
    /*    */
    public SpringActorProducer(ApplicationContext applicationContext, String beanActorName) {
        /* 14 */
        this.applicationContext = applicationContext;
        /* 15 */
        this.beanActorName = beanActorName;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public Actor produce() {
        /* 20 */
        return (Actor) this.applicationContext.getBean(this.beanActorName);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public Class<? extends Actor> actorClass() {
        /* 25 */
        return (Class<? extends Actor>) this.applicationContext.getType(this.beanActorName);
        /*    */
    }
    /*    */
}


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\config\SpringActorProducer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */