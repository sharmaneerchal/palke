 package mappings;
 
 import java.io.Serializable;
 import java.util.Date;
 import java.util.HashSet;
 import java.util.Set;
 
 
 
 
 public class Members
   implements Serializable
 {
   private Integer memberid;
   private Groups groups;
   private String membername;
   private String memberaddress;
   private String contactno;
   private String emailid;
   private Serializable completed;
   private Date joindate;
   private Integer memberno;
   private String status;
   private String remarks;
/*  25 */   private Set<Drawdetails> drawdetailses = new HashSet(0);
/*  26 */   private Set<Payment> payments = new HashSet(0);
   
   public Members() {}
   
   public Members(Groups groups, String membername, String memberaddress, String contactno, String emailid, Serializable completed, Date joindate, int memberno, String status, String remarks)
   {
/*  32 */     this.groups = groups;
/*  33 */     this.membername = membername;
/*  34 */     this.memberaddress = memberaddress;
/*  35 */     this.contactno = contactno;
/*  36 */     this.emailid = emailid;
/*  37 */     this.completed = completed;
/*  38 */     this.joindate = joindate;
/*  39 */     this.memberno = Integer.valueOf(memberno);
/*  40 */     this.status = status;
/*  41 */     this.remarks = remarks;
   }
   
   public Members(Groups groups, String membername, String memberaddress, String contactno, String emailid, Serializable completed, Date joindate, int memberno, String status, String remarks, Set<Drawdetails> drawdetailses, Set<Payment> payments) {
/*  45 */     this.groups = groups;
/*  46 */     this.membername = membername;
/*  47 */     this.memberaddress = memberaddress;
/*  48 */     this.contactno = contactno;
/*  49 */     this.emailid = emailid;
/*  50 */     this.completed = completed;
/*  51 */     this.joindate = joindate;
/*  52 */     this.memberno = Integer.valueOf(memberno);
/*  53 */     this.status = status;
/*  54 */     this.drawdetailses = drawdetailses;
/*  55 */     this.payments = payments;
/*  56 */     this.remarks = remarks;
   }
   
   public String getRemarks() {
/*  60 */     return this.remarks;
   }
   
   public void setRemarks(String remarks) {
/*  64 */     this.remarks = remarks;
   }
   
   public String getStatus() {
/*  68 */     return this.status;
   }
   
   public void setStatus(String status) {
/*  72 */     this.status = status;
   }
   
   public Integer getMemberno() {
/*  76 */     return this.memberno;
   }
   
   public void setMemberno(Integer memberno) {
/*  80 */     this.memberno = memberno;
   }
   
   public Integer getMemberid() {
/*  84 */     return this.memberid;
   }
   
   public void setMemberid(Integer memberid) {
/*  88 */     this.memberid = memberid;
   }
   
   public Groups getGroups() {
/*  92 */     return this.groups;
   }
   
   public void setGroups(Groups groups) {
/*  96 */     this.groups = groups;
   }
   
   public String getMembername() {
/* 100 */     return this.membername;
   }
   
   public void setMembername(String membername) {
/* 104 */     this.membername = membername;
   }
   
   public String getMemberaddress() {
/* 108 */     return this.memberaddress;
   }
   
   public void setMemberaddress(String memberaddress) {
/* 112 */     this.memberaddress = memberaddress;
   }
   
   public String getContactno() {
/* 116 */     return this.contactno;
   }
   
   public void setContactno(String contactno) {
/* 120 */     this.contactno = contactno;
   }
   
   public String getEmailid() {
/* 124 */     return this.emailid;
   }
   
   public void setEmailid(String emailid) {
/* 128 */     this.emailid = emailid;
   }
   
   public Serializable getCompleted() {
/* 132 */     return this.completed;
   }
   
   public void setCompleted(Serializable completed) {
/* 136 */     this.completed = completed;
   }
   
   public Date getJoindate() {
/* 140 */     return this.joindate;
   }
   
   public void setJoindate(Date joindate) {
/* 144 */     this.joindate = joindate;
   }
   
   public Set<Drawdetails> getDrawdetailses() {
/* 148 */     return this.drawdetailses;
   }
   
   public void setDrawdetailses(Set<Drawdetails> drawdetailses) {
/* 152 */     this.drawdetailses = drawdetailses;
   }
   
   public Set<Payment> getPayments() {
/* 156 */     return this.payments;
   }
   
   public void setPayments(Set<Payment> payments) {
/* 160 */     this.payments = payments;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Members.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */