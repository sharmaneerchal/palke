/*    */ package mappings;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Balance
/*    */   implements Serializable
/*    */ {
/*    */   private int id;
/*    */   private int year;
/*    */   private Double balance;
/*    */   private Date insertdate;
/*    */   private String type;
/*    */   
/*    */   public Balance() {}
/*    */   
/*    */   public Balance(int id, int year, Double balance, Date insertdate, String type)
/*    */   {
/* 21 */     this.id = id;
/* 22 */     this.year = year;
/* 23 */     this.balance = balance;
/* 24 */     this.insertdate = insertdate;
/* 25 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 29 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 33 */     this.type = type;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 37 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 41 */     this.id = id;
/*    */   }
/*    */   
/*    */   public int getYear() {
/* 45 */     return this.year;
/*    */   }
/*    */   
/*    */   public void setYear(int year) {
/* 49 */     this.year = year;
/*    */   }
/*    */   
/*    */   public Double getBalance() {
/* 53 */     return this.balance;
/*    */   }
/*    */   
/*    */   public void setBalance(Double balance) {
/* 57 */     this.balance = balance;
/*    */   }
/*    */   
/*    */   public Date getInsertdate() {
/* 61 */     return this.insertdate;
/*    */   }
/*    */   
/*    */   public void setInsertdate(Date insertdate) {
/* 65 */     this.insertdate = insertdate;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Balance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */