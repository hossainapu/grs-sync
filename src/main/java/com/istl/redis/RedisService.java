/*     */ package com.istl.redis;
/*     */ import com.istl.business.entity.EmpOffice;
/*     */ import com.istl.database.entity.EmployeeOffice;
/*     */ import com.istl.redis.EmpOfficeRedis;
/*     */ import com.istl.utils.BusinessToEntityConvertor;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Service;
/*     */ import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

/*     */
/*     */ @Service
/*     */ public class RedisService {
/*  17 */   private static final Logger log = LoggerFactory.getLogger(com.istl.redis.RedisService.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  22 */   Jedis jedisSave = null;
/*     */   
/*     */   ExecutorService cachingExecutor;
/*     */   
/*     */   ExecutorService migrationExecutor;
/*     */   ExecutorService syncExecutor;
/*     */   ExecutorService migrationUpdateExecutor;
/*     */   @Value("${redis.host}")
/*     */   String redisHost;
/*     */   @Value("${redis.port}")
/*     */   int redisPort;
/*     */   @Value("${redis.timeout}")
/*     */   int timeout;

//            @Value("${redis.password}")
//    /*     */   String redisPassword;
/*     */   @Autowired
/*     */   private EmpOfficeRedisRepository empOfficeRedisRepository;
/*     */   
/*     */   public Jedis jedisConnection() {
/*  41 */     Jedis jedis = null;
/*     */     
/*     */     try {
                JedisShardInfo shardInfo = new JedisShardInfo(this.redisHost, this.redisPort, this.timeout);
//                shardInfo.setPassword(this.redisPassword);

/*  44 */       jedis = new Jedis(shardInfo);
/*  46 */     } catch (Exception e) {
/*  47 */       e.printStackTrace();
/*     */     } 
/*  49 */     return jedis;
/*     */   }
/*     */   
/*     */   Jedis jedisConnectionSave() {
/*     */     try {
                JedisShardInfo shardInfo = new JedisShardInfo(this.redisHost, this.redisPort);
//                shardInfo.setPassword(this.redisPassword);

                return new Jedis(shardInfo);
/*  56 */     } catch (Exception e) {
/*  57 */       e.printStackTrace();
/*     */     } 
/*  59 */     return this.jedisSave;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(Jedis jedis, String name) {
/*  82 */     if (jedis == null) {
/*  83 */       jedis = jedisConnection();
/*     */     }
/*  85 */     String p = jedis.get(name);
/*     */     
/*  87 */     return p;
/*     */   }
/*     */   
/*     */   public String find(Jedis jedis, String name) {
/*  91 */     if (jedis == null) {
/*  92 */       jedis = jedisConnection();
/*     */     }
/*  94 */     String p = jedis.get(name);
/*  95 */     return p;
/*     */   }
/*     */   
/*     */   public String add(Jedis jedis, String name, String value) {
/*  99 */     if (jedis == null) {
/* 100 */       jedis = jedisConnection();
/*     */     }
/* 102 */     jedis.rpush(name, new String[] { value });
/* 103 */     return "SUCCESS";
/*     */   }
/*     */   
/*     */   public String save(String name, String value) {
/* 107 */     if (this.jedisSave == null) {
/* 108 */       this.jedisSave = jedisConnectionSave();
/*     */     }
/* 110 */     this.jedisSave.set(name, value);
/* 111 */     return "SUCCESS";
/*     */   }
/*     */   
/*     */   public String save(Jedis jedis, String name, String value) {
/* 115 */     if (jedis == null) {
/* 116 */       jedis = jedisConnection();
/*     */     }
/*     */     try {
/* 119 */       jedis.set(name, value);
/* 120 */     } catch (Exception e) {
/* 121 */       e.printStackTrace();
/* 122 */       log.info("key: {} value: {}", name, value);
/*     */     } 
/* 124 */     return "SUCCESS";
/*     */   }
/*     */   
/*     */   public Long size(Jedis jedis, String name) {
/* 128 */     if (jedis == null) {
/* 129 */       jedis = jedisConnection();
/*     */     }
/* 131 */     return Long.valueOf(jedis.llen(name));
/*     */   }
/*     */   
/*     */   public List<String> getAllValues(Jedis jedis, String name) {
/* 135 */     return jedis.lrange(name, 0L, Long.MAX_VALUE);
/*     */   }
/*     */ 
/*     */   
/*     */   public void task(Jedis jedis, List<EmpOffice> empOffices) {
/* 140 */     for (EmpOffice empOffice : empOffices) {
/* 141 */       EmpOfficeRedis empOfficeRedisNew = BusinessToEntityConvertor.convertEmpOfficeToEmpOfficeRedis(empOffice);
/*     */       
/* 143 */       String redisValueStr = get(jedis, empOfficeRedisNew.getRedisId());
/* 144 */       log.info("redis value:" + redisValueStr + "(" + empOfficeRedisNew.getRedisId() + ")");
/*     */ 
/*     */       
/* 147 */       if (redisValueStr != null && !redisValueStr.isEmpty() && !redisValueStr.equals("OK")) {
/*     */ 
/*     */         
/* 150 */         EmpOfficeRedis empOfficeRedisOld = EmpOfficeRedis.getEmpOfficeRedis(redisValueStr);
/*     */         
/* 152 */         boolean isSame = empOfficeRedisOld.same(empOfficeRedisNew);
/* 153 */         if (!isSame) {
/* 154 */           empOfficeRedisNew.setPreviousRecord(redisValueStr);
/* 155 */           log.info("Update EmpOffice:" + empOfficeRedisNew.getRedisId() + "");
/* 156 */           this.empOfficeRedisRepository.save(empOfficeRedisNew);
/* 157 */           save(jedis, empOfficeRedisNew.getRedisId(), empOfficeRedisNew.getRedisValue());
/*     */         } 
/*     */         continue;
/*     */       } 
/* 161 */       save(jedis, empOfficeRedisNew.getRedisId(), empOfficeRedisNew.getRedisValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void taskSync(Jedis jedis, List<EmployeeOffice> employeeOffices) {
/* 171 */     for (EmployeeOffice employeeOffice : employeeOffices) {
/* 172 */       EmpOfficeRedis empOfficeRedisNew = BusinessToEntityConvertor.convertEmpOfficeToEmpOfficeRedis(employeeOffice);
/* 173 */       save(jedis, empOfficeRedisNew.getRedisId(), empOfficeRedisNew.getRedisValue());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\redis\RedisService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */