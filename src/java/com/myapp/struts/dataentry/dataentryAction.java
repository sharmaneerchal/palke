 package com.myapp.struts.dataentry;
 
 import com.myapp.struts.Utility.Constants;
 import com.myapp.struts.dao.DrawTypesDAO;
 import com.myapp.struts.dao.PaymentModeDAO;
 import com.myapp.struts.dao.PositionsDAO;
 import java.sql.SQLException;
 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import mappings.Drawtypes;
 import mappings.Paymentmodes;
 import mappings.Positions;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 import org.apache.struts.actions.DispatchAction;
 
 
 
 
 
 
 
 
 public class dataentryAction
   extends DispatchAction
 {
/*  30 */   DrawTypesDAO drawtypes = new DrawTypesDAO();
/*  31 */   PositionsDAO position = new PositionsDAO();
/*  32 */   PaymentModeDAO paymentmode = new PaymentModeDAO();
   
   public ActionForward displayData(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception
   {
/*  36 */     if (Constants.isSessionActive(request)) {
/*  37 */       dataentryForm dataentryForm = (dataentryForm)form;
/*  38 */       dataentryForm.setDrawtypeid(0);
/*  39 */       dataentryForm.setDrawtypes("");
/*  40 */       dataentryForm.setPosition("");
/*  41 */       dataentryForm.setPositionid(0);
/*  42 */       dataentryForm.getLstdrawtypes().clear();
/*  43 */       dataentryForm.getLstPositions().clear();
/*  44 */       dataentryForm.getLstPaymentModes().clear();
       
/*  46 */       HttpSession session = request.getSession();
/*  47 */       boolean admin = ((Boolean)session.getAttribute("admin")).booleanValue();
       
/*  49 */       if (!admin) {
/*  50 */         return mapping.findForward("fail");
       }
       
/*  53 */       DrawTypesDAO dao = new DrawTypesDAO();
/*  54 */       PaymentModeDAO objpm = new PaymentModeDAO();
/*  55 */       PositionsDAO objp = new PositionsDAO();
/*  56 */       dataentryForm.getLstdrawtypes().addAll(dao.getDrawtypes());
/*  57 */       dataentryForm.getLstPositions().addAll(objp.getPositions());
/*  58 */       dataentryForm.getLstPaymentModes().addAll(objpm.getPaymentModes());
       
/*  60 */       return mapping.findForward("display");
     }
/*  62 */     return mapping.findForward("exp");
   }
   
   public ActionForward deleteDrawtypes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/*  68 */     if (Constants.isSessionActive(request)) {
/*  69 */       dataentryForm dataentryForm = (dataentryForm)form;
/*  70 */       DrawTypesDAO dao = new DrawTypesDAO();
       try {
/*  72 */         for (int i = 0; i < dataentryForm.getLstdrawtypes().size(); i++) {
/*  73 */           Drawtypes drawtypes = (Drawtypes)dataentryForm.getLstdrawtypes().get(i);
/*  74 */           if (drawtypes.getDrawtypeid().intValue() == dataentryForm.getDrawtypeid()) {
/*  75 */             dao.deleteDrawtypes(drawtypes);
/*  76 */             break;
           }
         }
/*  79 */         dataentryForm.getLstdrawtypes().clear();
/*  80 */         dataentryForm.getLstdrawtypes().addAll(dao.getDrawtypes());
       }
       catch (Exception e) {}
/*  83 */       return mapping.findForward("display");
     }
/*  85 */     return mapping.findForward("exp");
   }
   
   public ActionForward saveDrawtypes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/*  91 */     if (Constants.isSessionActive(request)) {
/*  92 */       dataentryForm dataentryForm = (dataentryForm)form;
/*  93 */       DrawTypesDAO dao = new DrawTypesDAO();
       try {
/*  95 */         Drawtypes obj = new Drawtypes();
/*  96 */         obj.setDrawtypes(dataentryForm.getDrawtypes());
         
/*  98 */         dao.saveDrawtypes(obj);
         
/* 100 */         dataentryForm.getLstdrawtypes().clear();
/* 101 */         dataentryForm.getLstdrawtypes().addAll(dao.getDrawtypes());
         
/* 103 */         dataentryForm.setMessage("Draw type saved.");
       }
       catch (Exception e) {
/* 106 */         dataentryForm.setMessage("Error while saving.");
       }
       
/* 109 */       return mapping.findForward("display");
     }
/* 111 */     return mapping.findForward("exp");
   }
   
   public ActionForward deletePositions(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/* 117 */     if (Constants.isSessionActive(request)) {
/* 118 */       dataentryForm dataentryForm = (dataentryForm)form;
       try
       {
/* 121 */         for (int i = 0; i < dataentryForm.getLstPositions().size(); i++) {
/* 122 */           Positions positions = (Positions)dataentryForm.getLstPositions().get(i);
/* 123 */           if (positions.getPositionid().intValue() == dataentryForm.getPositionid()) {
/* 124 */             this.position.deletePositions(positions);
/* 125 */             break;
           }
         }
/* 128 */         dataentryForm.getLstPositions().clear();
/* 129 */         dataentryForm.getLstPositions().addAll(this.position.getPositions());
       }
       catch (Exception e) {}
       
/* 133 */       return mapping.findForward("display");
     }
/* 135 */     return mapping.findForward("exp");
   }
   
   public ActionForward savePositions(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/* 141 */     if (Constants.isSessionActive(request)) {
/* 142 */       dataentryForm dataentryForm = (dataentryForm)form;
/* 143 */       DrawTypesDAO dao = new DrawTypesDAO();
       try {
/* 145 */         Positions obj = new Positions();
/* 146 */         obj.setPosition(dataentryForm.getPosition());
         
/* 148 */         this.position.savePositions(obj);
         
/* 150 */         dataentryForm.getLstPositions().clear();
/* 151 */         dataentryForm.getLstPositions().addAll(this.position.getPositions());
/* 152 */         dataentryForm.setMessage("Draw Position saved.");
       }
       catch (Exception e) {
/* 155 */         dataentryForm.setMessage("Error while saving.");
       }
       
/* 158 */       return mapping.findForward("display");
     }
/* 160 */     return mapping.findForward("exp");
   }
   
   public ActionForward deletePaymentmode(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/* 166 */     if (Constants.isSessionActive(request)) {
/* 167 */       dataentryForm dataentryForm = (dataentryForm)form;
       try
       {
/* 170 */         for (int i = 0; i < dataentryForm.getLstPaymentModes().size(); i++) {
/* 171 */           Paymentmodes paymentmodes = (Paymentmodes)dataentryForm.getLstPaymentModes().get(i);
/* 172 */           if (paymentmodes.getPaymentmodeid().intValue() == dataentryForm.getPaymentmodeid()) {
/* 173 */             this.paymentmode.deletePaymentmodes(paymentmodes);
/* 174 */             break;
           }
         }
/* 177 */         dataentryForm.getLstPaymentModes().clear();
/* 178 */         dataentryForm.getLstPaymentModes().addAll(this.paymentmode.getPaymentModes());
       }
       catch (Exception e) {}
       
/* 182 */       return mapping.findForward("display");
     }
/* 184 */     return mapping.findForward("exp");
   }
   
   public ActionForward savePaymentmode(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/* 190 */     if (Constants.isSessionActive(request)) {
/* 191 */       dataentryForm dataentryForm = (dataentryForm)form;
/* 192 */       DrawTypesDAO dao = new DrawTypesDAO();
       try {
/* 194 */         Paymentmodes obj = new Paymentmodes();
/* 195 */         obj.setPaymentmode(dataentryForm.getPaymentmode());
         
/* 197 */         this.paymentmode.savePaymentmodes(obj);
         
/* 199 */         dataentryForm.getLstPaymentModes().clear();
/* 200 */         dataentryForm.getLstPaymentModes().addAll(this.paymentmode.getPaymentModes());
/* 201 */         dataentryForm.setMessage("Payment mode saved.");
       }
       catch (Exception e) {
/* 204 */         dataentryForm.setMessage("Error while saving.");
       }
       
/* 207 */       return mapping.findForward("display");
     }
/* 209 */     return mapping.findForward("exp");
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dataentry\dataentryAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */