 package com.myapp.struts.dataentry;
 
 import java.util.ArrayList;
 import java.util.List;
 import mappings.Drawtypes;
 import mappings.Paymentmodes;
 import mappings.Positions;
 import org.apache.struts.action.ActionForm;
 
 public class dataentryForm extends ActionForm
 {
   private int drawtypeid;
   private String drawtypes;
   private int positionid;
   private String position;
   private int paymentmodeid;
   private String paymentmode;
   private List<Drawtypes> lstdrawtypes;
   private List<Positions> lstPositions;
   private List<Paymentmodes> lstPaymentModes;
   private String message;
   
   public dataentryForm()
   {
/*  25 */     this.lstdrawtypes = new ArrayList();
/*  26 */     this.lstPositions = new ArrayList();
/*  27 */     this.lstPaymentModes = new ArrayList();
   }
   
   public dataentryForm(int drawtypeid, String drawtypes, int positionid, String position, int paymentmodeid, String paymentmode, List<Drawtypes> lstdrawtypes, List<Positions> lstPositions, List<Paymentmodes> lstPaymentModes, String message) {
/*  31 */     this.drawtypeid = drawtypeid;
/*  32 */     this.drawtypes = drawtypes;
/*  33 */     this.positionid = positionid;
/*  34 */     this.position = position;
/*  35 */     this.paymentmodeid = paymentmodeid;
/*  36 */     this.paymentmode = paymentmode;
/*  37 */     this.lstdrawtypes = lstdrawtypes;
/*  38 */     this.lstPositions = lstPositions;
/*  39 */     this.lstPaymentModes = lstPaymentModes;
/*  40 */     this.message = message;
   }
   
   public String getMessage() {
/*  44 */     return this.message;
   }
   
   public void setMessage(String message) {
/*  48 */     this.message = message;
   }
   
   public int getPaymentmodeid() {
/*  52 */     return this.paymentmodeid;
   }
   
   public void setPaymentmodeid(int paymentmodeid) {
/*  56 */     this.paymentmodeid = paymentmodeid;
   }
   
   public String getPaymentmode() {
/*  60 */     return this.paymentmode;
   }
   
   public void setPaymentmode(String paymentmode) {
/*  64 */     this.paymentmode = paymentmode;
   }
   
   public List<Paymentmodes> getLstPaymentModes() {
/*  68 */     return this.lstPaymentModes;
   }
   
   public void setLstPaymentModes(List<Paymentmodes> lstPaymentModes) {
/*  72 */     this.lstPaymentModes = lstPaymentModes;
   }
   
   public int getPositionid() {
/*  76 */     return this.positionid;
   }
   
   public void setPositionid(int positionid) {
/*  80 */     this.positionid = positionid;
   }
   
   public String getPosition() {
/*  84 */     return this.position;
   }
   
   public void setPosition(String position) {
/*  88 */     this.position = position;
   }
   
   public List<Positions> getLstPositions() {
/*  92 */     return this.lstPositions;
   }
   
   public void setLstPositions(List<Positions> lstPositions) {
/*  96 */     this.lstPositions = lstPositions;
   }
   
   public List<Drawtypes> getLstdrawtypes() {
/* 100 */     return this.lstdrawtypes;
   }
   
   public void setLstdrawtypes(List<Drawtypes> lstdrawtypes) {
/* 104 */     this.lstdrawtypes = lstdrawtypes;
   }
   
   public int getDrawtypeid() {
/* 108 */     return this.drawtypeid;
   }
   
   public void setDrawtypeid(int drawtypeid) {
/* 112 */     this.drawtypeid = drawtypeid;
   }
   
   public String getDrawtypes() {
/* 116 */     return this.drawtypes;
   }
   
   public void setDrawtypes(String drawtypes) {
/* 120 */     this.drawtypes = drawtypes;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dataentry\dataentryForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */