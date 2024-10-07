/*    */ package com.istl.redis;
/*    */ import java.text.DateFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.*;
/*    */
/*    */
/*    */
/*    */

/*    */
/*    */ public class Utils {
/* 12 */   public static String NAME = "EO";
/* 13 */   public static String SEPARATOR = "|";
/* 14 */   public static String SEPARATOR_REGEX = "\\|";
/*    */ 
/*    */   
/*    */   public static boolean isEmpty(String string) {
/* 18 */     if (string == null) {
/* 19 */       return true;
/*    */     }
/* 21 */     return string.equals("");
/*    */   }
/*    */   
/* 24 */   public static final LinkedHashMap<String, LinkedHashSet<String>> pk = new LinkedHashMap<>();
/* 25 */   public static final LinkedHashMap<String, LinkedHashMap<String, String>> tableColumnMap = new LinkedHashMap<>();
/*    */   
/*    */   public static boolean validDateFormat(String s) {
/* 28 */     boolean bool = true;
/*    */     try {
/* 30 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
/* 31 */       sdf.parse(s);
/* 32 */     } catch (ParseException ex) {
/* 33 */       ex.printStackTrace();
/* 34 */       bool = false;
/*    */     } 
/* 36 */     return bool;
/*    */   }
/*    */   
/*    */   public static boolean validDateFormatMulti(String s) {
/* 40 */     boolean bool = true;
/*    */     
/* 42 */     List<SimpleDateFormat> knownPatterns = new ArrayList<>();
/*    */     
/* 44 */     knownPatterns.add(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"));
/* 45 */     knownPatterns.add(new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH));
/*    */     
/* 47 */     for (SimpleDateFormat pattern : knownPatterns) {
/*    */       try {
/* 49 */         pattern.parse(s);
/* 50 */         return true;
/* 51 */       } catch (ParseException parseException) {}
/*    */     } 
/*    */ 
/*    */     
/* 55 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isDateFormatDD_MMM_YY(String s) {
/*    */     try {
/* 62 */       SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
/* 63 */       sdf.parse(s);
/* 64 */       return true;
/*    */     }
/* 66 */     catch (ParseException ex) {
/*    */       
/* 68 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isValidFormat(String format, String value) {
/* 74 */     Date date = null;
/*    */     try {
/* 76 */       SimpleDateFormat sdf = new SimpleDateFormat(format);
/* 77 */       date = sdf.parse(value);
/* 78 */     } catch (ParseException ex) {
/* 79 */       ex.printStackTrace();
/*    */     } 
/* 81 */     return (date != null);
/*    */   }
/*    */   
/*    */   public static String convertDateToOtherFormat(String originalFormat, String otherFormat, String value) {
/* 85 */     DateFormat original = new SimpleDateFormat(originalFormat);
/* 86 */     DateFormat target = new SimpleDateFormat(otherFormat);
/* 87 */     String formattedDate = null;
/*    */     try {
/* 89 */       Date date = original.parse(value);
/* 90 */       formattedDate = target.format(date);
/* 91 */     } catch (ParseException e) {
/* 92 */       e.printStackTrace();
/*    */     } 
/*    */     
/* 95 */     return formattedDate;
/*    */   }
/*    */ }


/* Location:              D:\GRS Sync\grs-migrator-prod.jar!\BOOT-INF\classes\com\istl\redis\Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */