/*    */ package mappings;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Users
/*    */   implements Serializable
/*    */ {
/*    */   private Integer userid;
/*    */   private String username;
/*    */   private String password;
/*    */   private boolean admin;
/*    */   
/*    */   public Users() {}
/*    */   
/*    */   public Users(String username, String password, boolean admin)
/*    */   {
/* 20 */     this.username = username;
/* 21 */     this.password = password;
/* 22 */     this.admin = admin;
/*    */   }
/*    */   
/*    */   public Integer getUserid() {
/* 26 */     return this.userid;
/*    */   }
/*    */   
/*    */   public void setUserid(Integer userid) {
/* 30 */     this.userid = userid;
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 34 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 38 */     this.username = username;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 42 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 46 */     this.password = password;
/*    */   }
/*    */   
/*    */   public boolean isAdmin() {
/* 50 */     return this.admin;
/*    */   }
/*    */   
/*    */   public void setAdmin(boolean admin) {
/* 54 */     this.admin = admin;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Users.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */