 package com.myapp.struts.group;
 
 import com.myapp.struts.beans.DrawDetailsData;
 import com.myapp.struts.beans.GroupDetails;
 import java.util.ArrayList;
 import java.util.List;
 import org.apache.struts.action.ActionForm;
 
 
 
 
 
 
 
 
 public class GroupCreationForm
   extends ActionForm
 {
   private String groupName;
   private int noofmembers;
   private String startDate;
   private String endDate;
   private int noofinstallment;
   private double installmentamount;
   private double bonusamount;
   private int drawtype;
   private List drawtypes;
   private int position;
   private List positions;
   private double placeamount;
   private String message;
   private ArrayList<DrawDetailsData> drawDetailsList;
   private boolean edit;
   private ArrayList<GroupDetails> groupDetails;
   private ArrayList<DrawDetailsData> drawDetails;
   private int rowid;
   private boolean withmember;
   
   public GroupCreationForm()
   {
/*  41 */     this.drawDetailsList = new ArrayList();
/*  42 */     this.positions = new ArrayList();
/*  43 */     this.drawtypes = new ArrayList();
/*  44 */     this.groupDetails = new ArrayList();
/*  45 */     this.drawDetails = new ArrayList();
   }
   
   public GroupCreationForm(String groupName, int noofmembers, String startDate, String endDate, int noofinstallment, double installmentamount, double bonusamount, int drawtype, List drawtypes, int position, List positions, double placeamount, String message, ArrayList<DrawDetailsData> drawDetailsList, boolean edit, ArrayList<GroupDetails> groupDetails, ArrayList<DrawDetailsData> drawDetails, int rowid, boolean withmember) {
/*  49 */     this.groupName = groupName;
/*  50 */     this.noofmembers = noofmembers;
/*  51 */     this.startDate = startDate;
/*  52 */     this.endDate = endDate;
/*  53 */     this.noofinstallment = noofinstallment;
/*  54 */     this.installmentamount = installmentamount;
/*  55 */     this.bonusamount = bonusamount;
/*  56 */     this.drawtype = drawtype;
/*  57 */     this.drawtypes = drawtypes;
/*  58 */     this.position = position;
/*  59 */     this.positions = positions;
/*  60 */     this.placeamount = placeamount;
/*  61 */     this.message = message;
/*  62 */     this.drawDetailsList = drawDetailsList;
/*  63 */     this.edit = edit;
/*  64 */     this.groupDetails = groupDetails;
/*  65 */     this.drawDetails = drawDetails;
/*  66 */     this.rowid = rowid;
/*  67 */     this.withmember = withmember;
   }
   
   public boolean isWithmember() {
/*  71 */     return this.withmember;
   }
   
   public void setWithmember(boolean withmember) {
/*  75 */     this.withmember = withmember;
   }
   
   public ArrayList<DrawDetailsData> getDrawDetails() {
/*  79 */     return this.drawDetails;
   }
   
   public void setDrawDetails(ArrayList<DrawDetailsData> drawDetails) {
/*  83 */     this.drawDetails = drawDetails;
   }
   
   public int getRowid() {
/*  87 */     return this.rowid;
   }
   
   public void setRowid(int rowid) {
/*  91 */     this.rowid = rowid;
   }
   
   public boolean isEdit() {
/*  95 */     return this.edit;
   }
   
   public void setEdit(boolean edit) {
/*  99 */     this.edit = edit;
   }
   
   public ArrayList<GroupDetails> getGroupDetails() {
/* 103 */     return this.groupDetails;
   }
   
   public void setGroupDetails(ArrayList<GroupDetails> groupDetails) {
/* 107 */     this.groupDetails = groupDetails;
   }
   
   public String getMessage() {
/* 111 */     return this.message;
   }
   
   public void setMessage(String message) {
/* 115 */     this.message = message;
   }
   
   public double getBonusamount() {
/* 119 */     return this.bonusamount;
   }
   
   public void setBonusamount(double bonusamount) {
/* 123 */     this.bonusamount = bonusamount;
   }
   
   public ArrayList<DrawDetailsData> getDrawDetailsList() {
/* 127 */     return this.drawDetailsList;
   }
   
   public void setDrawDetailsList(ArrayList<DrawDetailsData> drawDetailsList) {
/* 131 */     this.drawDetailsList = drawDetailsList;
   }
   
   public String getGroupName() {
/* 135 */     return this.groupName;
   }
   
   public void setGroupName(String groupName) {
/* 139 */     this.groupName = groupName;
   }
   
   public int getNoofmembers() {
/* 143 */     return this.noofmembers;
   }
   
   public void setNoofmembers(int noofmembers) {
/* 147 */     this.noofmembers = noofmembers;
   }
   
   public String getStartDate() {
/* 151 */     return this.startDate;
   }
   
   public void setStartDate(String startDate) {
/* 155 */     this.startDate = startDate;
   }
   
   public String getEndDate() {
/* 159 */     return this.endDate;
   }
   
   public void setEndDate(String endDate) {
/* 163 */     this.endDate = endDate;
   }
   
   public int getNoofinstallment() {
/* 167 */     return this.noofinstallment;
   }
   
   public void setNoofinstallment(int noofinstallment) {
/* 171 */     this.noofinstallment = noofinstallment;
   }
   
   public double getInstallmentamount() {
/* 175 */     return this.installmentamount;
   }
   
   public void setInstallmentamount(double installmentamount) {
/* 179 */     this.installmentamount = installmentamount;
   }
   
   public int getDrawtype() {
/* 183 */     return this.drawtype;
   }
   
   public void setDrawtype(int drawtype) {
/* 187 */     this.drawtype = drawtype;
   }
   
   public List getDrawtypes() {
/* 191 */     return this.drawtypes;
   }
   
   public void setDrawtypes(List drawtypes) {
/* 195 */     this.drawtypes = drawtypes;
   }
   
   public int getPosition() {
/* 199 */     return this.position;
   }
   
   public void setPosition(int position) {
/* 203 */     this.position = position;
   }
   
   public List getPositions() {
/* 207 */     return this.positions;
   }
   
   public void setPositions(List positions) {
/* 211 */     this.positions = positions;
   }
   
   public double getPlaceamount() {
/* 215 */     return this.placeamount;
   }
   
   public void setPlaceamount(double placeamount) {
/* 219 */     this.placeamount = placeamount;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\group\GroupCreationForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */