 package com.myapp.struts.member;
 
 import com.myapp.struts.beans.MemberDetails;
 import java.util.ArrayList;
 import java.util.List;
 import org.apache.struts.action.ActionForm;
 
 
 
 
 
 
 
 
 public class AddMemberForm
   extends ActionForm
 {
   private int memberid;
   private int memberno;
   private int group;
   private List groups;
   private String membername;
   private String address;
   private String contactno;
   private String email;
   private String message;
   private List<MemberDetails> lstMembers;
   private String selectedmember;
   boolean edit;
   
   public AddMemberForm()
   {
/*  33 */     this.groups = new ArrayList();
/*  34 */     this.lstMembers = new ArrayList();
/*  35 */     this.edit = false;
   }
   
   public AddMemberForm(int memberid, int group, List groups, String membername, String address, String contactno, String email, String message, List<MemberDetails> lstMembers, boolean edit) {
/*  39 */     this.memberid = memberid;
/*  40 */     this.group = group;
/*  41 */     this.groups = groups;
/*  42 */     this.membername = membername;
/*  43 */     this.address = address;
/*  44 */     this.contactno = contactno;
/*  45 */     this.email = email;
/*  46 */     this.message = message;
/*  47 */     this.lstMembers = lstMembers;
/*  48 */     this.edit = edit;
   }
   
   public String getSelectedmember() {
/*  52 */     return this.selectedmember;
   }
   
   public void setSelectedmember(String selectedmember) {
/*  56 */     this.selectedmember = selectedmember;
   }
   
   public int getMemberid() {
/*  60 */     return this.memberid;
   }
   
   public void setMemberid(int memberid) {
/*  64 */     this.memberid = memberid;
   }
   
   public int getMemberno() {
/*  68 */     return this.memberno;
   }
   
   public void setMemberno(int memberno) {
/*  72 */     this.memberno = memberno;
   }
   
   public int getGroup() {
/*  76 */     return this.group;
   }
   
   public void setGroup(int group) {
/*  80 */     this.group = group;
   }
   
   public List getGroups() {
/*  84 */     return this.groups;
   }
   
   public void setGroups(List groups) {
/*  88 */     this.groups = groups;
   }
   
   public String getMembername() {
/*  92 */     return this.membername;
   }
   
   public void setMembername(String membername) {
/*  96 */     this.membername = membername;
   }
   
   public String getAddress() {
/* 100 */     return this.address;
   }
   
   public void setAddress(String address) {
/* 104 */     this.address = address;
   }
   
   public String getContactno() {
/* 108 */     return this.contactno;
   }
   
   public void setContactno(String contactno) {
/* 112 */     this.contactno = contactno;
   }
   
   public String getEmail() {
/* 116 */     return this.email;
   }
   
   public void setEmail(String email) {
/* 120 */     this.email = email;
   }
   
   public String getMessage() {
/* 124 */     return this.message;
   }
   
   public void setMessage(String message) {
/* 128 */     this.message = message;
   }
   
   public List<MemberDetails> getLstMembers() {
/* 132 */     return this.lstMembers;
   }
   
   public void setLstMembers(List<MemberDetails> lstMembers) {
/* 136 */     this.lstMembers = lstMembers;
   }
   
   public boolean isEdit() {
/* 140 */     return this.edit;
   }
   
   public void setEdit(boolean edit) {
/* 144 */     this.edit = edit;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\member\AddMemberForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */