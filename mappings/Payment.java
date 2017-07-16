 package mappings;
 
 import java.io.Serializable;
 import java.util.Date;
 import java.util.HashSet;
 import java.util.Set;
 
 
 
 public class Payment
   implements Serializable
 {
   private Integer paymentid;
   private Members members;
   private Paymentmodes paymentmodes;
   private Double paidamount;
   private Date paiddate;
   private String attachments;
   private String remarks;
   private boolean canceled;
/*  21 */   private Set<Paymentdetails> paymentdetailses = new HashSet(0);
   
   public Payment() {}
   
   public Payment(Integer paymentid, Members members, Paymentmodes paymentmodes, Double paidamount, Date paiddate, String attachments, String remarks, boolean canceled)
   {
/*  27 */     this.paymentid = paymentid;
/*  28 */     this.members = members;
/*  29 */     this.paymentmodes = paymentmodes;
/*  30 */     this.paidamount = paidamount;
/*  31 */     this.paiddate = paiddate;
/*  32 */     this.attachments = attachments;
/*  33 */     this.remarks = remarks;
/*  34 */     this.canceled = canceled;
   }
   
   public boolean isCanceled() {
/*  38 */     return this.canceled;
   }
   
   public void setCanceled(boolean canceled) {
/*  42 */     this.canceled = canceled;
   }
   
   public Integer getPaymentid() {
/*  46 */     return this.paymentid;
   }
   
   public void setPaymentid(Integer paymentid) {
/*  50 */     this.paymentid = paymentid;
   }
   
   public Members getMembers() {
/*  54 */     return this.members;
   }
   
   public void setMembers(Members members) {
/*  58 */     this.members = members;
   }
   
   public Paymentmodes getPaymentmodes() {
/*  62 */     return this.paymentmodes;
   }
   
   public void setPaymentmodes(Paymentmodes paymentmodes) {
/*  66 */     this.paymentmodes = paymentmodes;
   }
   
   public Double getPaidamount() {
/*  70 */     return this.paidamount;
   }
   
   public void setPaidamount(Double paidamount) {
/*  74 */     this.paidamount = paidamount;
   }
   
   public Date getPaiddate() {
/*  78 */     return this.paiddate;
   }
   
   public void setPaiddate(Date paiddate) {
/*  82 */     this.paiddate = paiddate;
   }
   
   public String getAttachments() {
/*  86 */     return this.attachments;
   }
   
   public void setAttachments(String attachments) {
/*  90 */     this.attachments = attachments;
   }
   
   public String getRemarks() {
/*  94 */     return this.remarks;
   }
   
   public void setRemarks(String remarks) {
/*  98 */     this.remarks = remarks;
   }
   
   public Set<Paymentdetails> getPaymentdetailses() {
/* 102 */     return this.paymentdetailses;
   }
   
   public void setPaymentdetailses(Set<Paymentdetails> paymentdetailses) {
/* 106 */     this.paymentdetailses = paymentdetailses;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Payment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */