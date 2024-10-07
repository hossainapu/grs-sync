 package com.istl;


 import com.istl.business.manager.MigrationManager;
 import com.istl.business.manager.MigrationService;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.CommandLineRunner;
 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.cache.annotation.EnableCaching;
 import org.springframework.scheduling.annotation.EnableScheduling;
 import org.springframework.transaction.annotation.Transactional;
 
 @SpringBootApplication
 @EnableScheduling
 @EnableCaching
 public class Application
   implements CommandLineRunner {
   private static final Logger logger = LoggerFactory.getLogger(com.istl.Application.class);
   
   @Autowired
   private MigrationService migrationService;
   @Autowired
   private MigrationManager migrationManager;
   
   public static void main(String[] args) {
     logger.info("APPLICATION EXECUTION - INITIATED");
     SpringApplication.run(com.istl.Application.class, args);
     logger.info("APPLICATION EXECUTION - COMPLETED");
   }
 
 
   
   @Transactional
   public void run(String... args) throws Exception {
     this.migrationManager.redisSync();
     this.migrationManager.cronJobSch();
     this.migrationService.migrateAll();
   }
 }