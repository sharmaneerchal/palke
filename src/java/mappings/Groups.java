package mappings;
// Generated 9 Jul, 2017 4:43:28 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Groups generated by hbm2java
 */
public class Groups  implements java.io.Serializable {


     private Integer groupid;
     private String groupname;
     private int noofmembers;
     private int noofinstallment;
     private Date startdate;
     private Date enddate;
     private double installmentamount;
     private double bonousamount;
     private Date createddate;
     private int createdby;
     private Date actualstartdate;

    public Groups() {
    }

	
    public Groups(String groupname, int noofmembers, int noofinstallment, Date startdate, Date enddate, double installmentamount, double bonousamount, Date createddate, int createdby) {
        this.groupname = groupname;
        this.noofmembers = noofmembers;
        this.noofinstallment = noofinstallment;
        this.startdate = startdate;
        this.enddate = enddate;
        this.installmentamount = installmentamount;
        this.bonousamount = bonousamount;
        this.createddate = createddate;
        this.createdby = createdby;
    }
    public Groups(String groupname, int noofmembers, int noofinstallment, Date startdate, Date enddate, double installmentamount, double bonousamount, Date createddate, int createdby, Date actualstartdate) {
       this.groupname = groupname;
       this.noofmembers = noofmembers;
       this.noofinstallment = noofinstallment;
       this.startdate = startdate;
       this.enddate = enddate;
       this.installmentamount = installmentamount;
       this.bonousamount = bonousamount;
       this.createddate = createddate;
       this.createdby = createdby;
       this.actualstartdate = actualstartdate;
    }
   
    public Integer getGroupid() {
        return this.groupid;
    }
    
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
    public String getGroupname() {
        return this.groupname;
    }
    
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    public int getNoofmembers() {
        return this.noofmembers;
    }
    
    public void setNoofmembers(int noofmembers) {
        this.noofmembers = noofmembers;
    }
    public int getNoofinstallment() {
        return this.noofinstallment;
    }
    
    public void setNoofinstallment(int noofinstallment) {
        this.noofinstallment = noofinstallment;
    }
    public Date getStartdate() {
        return this.startdate;
    }
    
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }
    public Date getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    public double getInstallmentamount() {
        return this.installmentamount;
    }
    
    public void setInstallmentamount(double installmentamount) {
        this.installmentamount = installmentamount;
    }
    public double getBonousamount() {
        return this.bonousamount;
    }
    
    public void setBonousamount(double bonousamount) {
        this.bonousamount = bonousamount;
    }
    public Date getCreateddate() {
        return this.createddate;
    }
    
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }
    public int getCreatedby() {
        return this.createdby;
    }
    
    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }
    public Date getActualstartdate() {
        return this.actualstartdate;
    }
    
    public void setActualstartdate(Date actualstartdate) {
        this.actualstartdate = actualstartdate;
    }




}


