/*    */ package mappings;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Employees
/*    */   implements Serializable
/*    */ {
/*    */   private Integer employeeid;
/*    */   private String employeeno;
/*    */   private String name;
/*    */   private String contactno;
/*    */   private String address;
/*    */   private Date joindate;
/*    */   private Date cfeateddate;
/*    */   
/*    */   public Employees() {}
/*    */   
/*    */   public Employees(String employeeno, String name, String contactno, String address, Date joindate, Date cfeateddate)
/*    */   {
/* 25 */     this.employeeno = employeeno;
/* 26 */     this.name = name;
/* 27 */     this.contactno = contactno;
/* 28 */     this.address = address;
/* 29 */     this.joindate = joindate;
/* 30 */     this.cfeateddate = cfeateddate;
/*    */   }
/*    */   
/*    */   public Integer getEmployeeid() {
/* 34 */     return this.employeeid;
/*    */   }
/*    */   
/*    */   public void setEmployeeid(Integer employeeid) {
/* 38 */     this.employeeid = employeeid;
/*    */   }
/*    */   
/* 41 */   public String getEmployeeno() { return this.employeeno; }
/*    */   
/*    */   public void setEmployeeno(String employeeno)
/*    */   {
/* 45 */     this.employeeno = employeeno;
/*    */   }
/*    */   
/* 48 */   public String getName() { return this.name; }
/*    */   
/*    */   public void setName(String name)
/*    */   {
/* 52 */     this.name = name;
/*    */   }
/*    */   
/* 55 */   public String getContactno() { return this.contactno; }
/*    */   
/*    */   public void setContactno(String contactno)
/*    */   {
/* 59 */     this.contactno = contactno;
/*    */   }
/*    */   
/* 62 */   public String getAddress() { return this.address; }
/*    */   
/*    */   public void setAddress(String address)
/*    */   {
/* 66 */     this.address = address;
/*    */   }
/*    */   
/* 69 */   public Date getJoindate() { return this.joindate; }
/*    */   
/*    */   public void setJoindate(Date joindate)
/*    */   {
/* 73 */     this.joindate = joindate;
/*    */   }
/*    */   
/* 76 */   public Date getCfeateddate() { return this.cfeateddate; }
/*    */   
/*    */   public void setCfeateddate(Date cfeateddate)
/*    */   {
/* 80 */     this.cfeateddate = cfeateddate;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Employees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */