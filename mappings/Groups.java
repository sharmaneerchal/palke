 package mappings;
 
 import java.io.Serializable;
 import java.util.Date;
 import java.util.HashSet;
 import java.util.Set;
 
 
 
 public class Groups
   implements Serializable
 {
   private Integer groupid;
   private String groupname;
   private int noofmembers;
   private int noofinstallment;
   private Date startdate;
   private Date enddate;
   private Date actualstartdate;
   private double installmentamount;
   private double bonousamount;
   private Date createddate;
   private int createdby;
/*  24 */   private Set<Groupdrawdetails> groupdrawdetailses = new HashSet(0);
/*  25 */   private Set<Members> memberses = new HashSet(0);
   
   public Groups() {}
   
   public Groups(Integer groupid, String groupname, int noofmembers, int noofinstallment, Date startdate, Date enddate, Date actualstartdate, double installmentamount, double bonousamount, Date createddate, int createdby)
   {
/*  31 */     this.groupid = groupid;
/*  32 */     this.groupname = groupname;
/*  33 */     this.noofmembers = noofmembers;
/*  34 */     this.noofinstallment = noofinstallment;
/*  35 */     this.startdate = startdate;
/*  36 */     this.enddate = enddate;
/*  37 */     this.actualstartdate = actualstartdate;
/*  38 */     this.installmentamount = installmentamount;
/*  39 */     this.bonousamount = bonousamount;
/*  40 */     this.createddate = createddate;
/*  41 */     this.createdby = createdby;
   }
   
   public Date getActualstartdate() {
/*  45 */     return this.actualstartdate;
   }
   
   public void setActualstartdate(Date actualstartdate) {
/*  49 */     this.actualstartdate = actualstartdate;
   }
   
   public Integer getGroupid() {
/*  53 */     return this.groupid;
   }
   
   public void setGroupid(Integer groupid) {
/*  57 */     this.groupid = groupid;
   }
   
   public String getGroupname() {
/*  61 */     return this.groupname;
   }
   
   public void setGroupname(String groupname) {
/*  65 */     this.groupname = groupname;
   }
   
   public int getNoofmembers() {
/*  69 */     return this.noofmembers;
   }
   
   public void setNoofmembers(int noofmembers) {
/*  73 */     this.noofmembers = noofmembers;
   }
   
   public int getNoofinstallment() {
/*  77 */     return this.noofinstallment;
   }
   
   public void setNoofinstallment(int noofinstallment) {
/*  81 */     this.noofinstallment = noofinstallment;
   }
   
   public Date getStartdate() {
/*  85 */     return this.startdate;
   }
   
   public void setStartdate(Date startdate) {
/*  89 */     this.startdate = startdate;
   }
   
   public Date getEnddate() {
/*  93 */     return this.enddate;
   }
   
   public void setEnddate(Date enddate) {
/*  97 */     this.enddate = enddate;
   }
   
   public double getInstallmentamount() {
/* 101 */     return this.installmentamount;
   }
   
   public void setInstallmentamount(double installmentamount) {
/* 105 */     this.installmentamount = installmentamount;
   }
   
   public double getBonousamount() {
/* 109 */     return this.bonousamount;
   }
   
   public void setBonousamount(double bonousamount) {
/* 113 */     this.bonousamount = bonousamount;
   }
   
   public Date getCreateddate() {
/* 117 */     return this.createddate;
   }
   
   public void setCreateddate(Date createddate) {
/* 121 */     this.createddate = createddate;
   }
   
   public int getCreatedby() {
/* 125 */     return this.createdby;
   }
   
   public void setCreatedby(int createdby) {
/* 129 */     this.createdby = createdby;
   }
   
   public Set<Groupdrawdetails> getGroupdrawdetailses() {
/* 133 */     return this.groupdrawdetailses;
   }
   
   public void setGroupdrawdetailses(Set<Groupdrawdetails> groupdrawdetailses) {
/* 137 */     this.groupdrawdetailses = groupdrawdetailses;
   }
   
   public Set<Members> getMemberses() {
/* 141 */     return this.memberses;
   }
   
   public void setMemberses(Set<Members> memberses) {
/* 145 */     this.memberses = memberses;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Groups.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */