/*    */ package com.istl.utils;
/*    */ 
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ import org.springframework.util.LinkedMultiValueMap;
/*    */ import org.springframework.util.MultiValueMap;
/*    */ 
/*    */ 
/*    */ public class Utility
/*    */ {
/* 15 */   public static String authToken = "";
/* 16 */   public static Long expirationTime = null;
/* 17 */   public static AtomicLong OUO_CALL_COUNT = new AtomicLong(0L);
/* 18 */   public static AtomicLong CURRENT_MIGRATION_UNITS = new AtomicLong(0L);
/*    */   
/*    */   public static MultiValueMap<String, String> getParams(Object value) {
/* 21 */     LinkedMultiValueMap map = new LinkedMultiValueMap();
/* 22 */     ObjectMapper objectMapper = new ObjectMapper();
/*    */     try {
/* 24 */       Map<String, Object> params = (Map<String, Object>)objectMapper.convertValue(value, Map.class);
/* 25 */       if (params != null && params.size() > 0) {
/* 26 */         params.forEach((k, v) -> {
/*    */               if (v != null) {
/*    */                 map.put(k, Arrays.asList(new String[] { v + "" }));
/*    */               }
/*    */             });
/*    */       }
/* 32 */     } catch (Exception e) {
/* 33 */       e.printStackTrace();
/*    */     } 
/* 35 */     return (MultiValueMap<String, String>)map;
/*    */   }
/*    */   public static <T> List<List<T>> spiltArray(List<T> values, int size) {
/*    */     float s;
/* 39 */     List<List<T>> results = new ArrayList<>();
/*    */     
/* 41 */     if (values.size() <= size) {
/* 42 */       s = values.size();
/*    */     } else {
/* 44 */       s = size;
/*    */     } 
/*    */     
/* 47 */     int perArray = (int)Math.ceil(Double.parseDouble(values.size() + "") / Double.parseDouble(s + ""));
/* 48 */     int counter = 0;
/* 49 */     List<T> list = new ArrayList<>();
/* 50 */     for (int i = 0; i < values.size(); i++) {
/* 51 */       list.add(values.get(i));
/* 52 */       counter++;
/* 53 */       if (counter == perArray) {
/* 54 */         results.add(list);
/* 55 */         counter = 0;
/* 56 */         list = new ArrayList<>();
/*    */       } 
/*    */     } 
/* 59 */     results.add(list);
/*    */     
/* 61 */     return results;
/*    */   }
/*    */   
/*    */   public static <T> List<List<T>> spiltArrayByMaxSize(List<T> values, int size) {
/* 65 */     List<List<T>> results = new ArrayList<>();
/*    */     
/* 67 */     List<T> temList = new ArrayList<>();
/* 68 */     int len = values.size();
/* 69 */     for (int i = 0; i < len; i++) {
/* 70 */       temList.add(values.get(i));
/* 71 */       if ((i + 1) % size == 0) {
/* 72 */         results.add(temList);
/* 73 */         temList = new ArrayList<>();
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 78 */     if (temList.size() > 0) {
/* 79 */       results.add(temList);
/*    */     }
/* 81 */     return results;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\ist\\utils\Utility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */