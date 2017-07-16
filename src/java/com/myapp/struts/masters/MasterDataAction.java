 package com.myapp.struts.masters;
 
 import com.myapp.struts.Utility.Constants;
 import com.myapp.struts.dao.BalanceDAO;
 import com.myapp.struts.dao.EmployeesDAO;
 import com.myapp.struts.dao.ItemsDAO;
 import java.sql.SQLException;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import mappings.Employees;
 import mappings.Items;
 import org.apache.struts.action.ActionForm;
 import org.apache.struts.action.ActionForward;
 import org.apache.struts.action.ActionMapping;
 import org.apache.struts.actions.DispatchAction;
 
 
 
 
 
 
 
 
 public class MasterDataAction
   extends DispatchAction
 {
   public ActionForward loadMasterDataPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/*  33 */     if (Constants.isSessionActive(request)) {
/*  34 */       MasterDataForm masterData = (MasterDataForm)form;
/*  35 */       masterData.getLstEmp().clear();
/*  36 */       masterData.getLstItems().clear();
       
/*  38 */       HashMap hmMap = new EmployeesDAO().getEmployee();
/*  39 */       masterData.setLstEmp((List)hmMap.get("list"));
       
/*  41 */       masterData.setLstItems(new ItemsDAO().getItems());
       
/*  43 */       masterData.setItemid(0);
/*  44 */       masterData.setEmployeeid(0);
/*  45 */       masterData.setEmployee(new Employees());
/*  46 */       masterData.setItem(new Items());
/*  47 */       return mapping.findForward("display");
     }
/*  49 */     return mapping.findForward("exp");
   }
   
   public ActionForward editEmployee(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/*  55 */     if (Constants.isSessionActive(request)) {
/*  56 */       MasterDataForm masterData = (MasterDataForm)form;
       
/*  58 */       for (int i = 0; i < masterData.getLstEmp().size(); i++) {
/*  59 */         Employees object = (Employees)masterData.getLstEmp().get(i);
/*  60 */         if (object.getEmployeeid().intValue() == masterData.getEmployeeid()) {
/*  61 */           masterData.setEmployee(object);
/*  62 */           break;
         }
       }
/*  65 */       return mapping.findForward("display");
     }
/*  67 */     return mapping.findForward("exp");
   }
   
   public ActionForward editItem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/*  73 */     if (Constants.isSessionActive(request)) {
/*  74 */       MasterDataForm masterData = (MasterDataForm)form;
       
/*  76 */       for (int i = 0; i < masterData.getLstItems().size(); i++) {
/*  77 */         Items object = (Items)masterData.getLstItems().get(i);
/*  78 */         if (object.getItemid().intValue() == masterData.getItemid()) {
/*  79 */           masterData.setItem(object);
/*  80 */           break;
         }
       }
/*  83 */       return mapping.findForward("display");
     }
/*  85 */     return mapping.findForward("exp");
   }
   
   public ActionForward saveEmployee(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/*  91 */     if (Constants.isSessionActive(request)) {
/*  92 */       MasterDataForm masterData = (MasterDataForm)form;
       
/*  94 */       if (masterData.getEmployeeid() == 0) {
/*  95 */         masterData.getEmployee().setCfeateddate(new Date());
/*  96 */         masterData.getEmployee().setJoindate(new Date());
/*  97 */         new EmployeesDAO().saveEmpoyee(masterData.getEmployee(), false);
       } else {
/*  99 */         masterData.getEmployee().setEmployeeid(Integer.valueOf(masterData.getEmployeeid()));
/* 100 */         new EmployeesDAO().saveEmpoyee(masterData.getEmployee(), true);
       }
       
/* 103 */       masterData.setEmployeeid(0);
/* 104 */       loadMasterDataPage(mapping, form, request, response);
/* 105 */       return mapping.findForward("display");
     }
/* 107 */     return mapping.findForward("exp");
   }
   
   public ActionForward saveItem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/* 113 */     if (Constants.isSessionActive(request)) {
/* 114 */       MasterDataForm masterData = (MasterDataForm)form;
       
/* 116 */       if (masterData.getItemid() == 0) {
/* 117 */         new ItemsDAO().saveItem(masterData.getItem(), false);
       } else {
/* 119 */         masterData.getItem().setItemid(Integer.valueOf(masterData.getItemid()));
/* 120 */         new ItemsDAO().saveItem(masterData.getItem(), true);
       }
       
/* 123 */       masterData.setItemid(0);
/* 124 */       loadMasterDataPage(mapping, form, request, response);
/* 125 */       return mapping.findForward("display");
     }
/* 127 */     return mapping.findForward("exp");
   }
   
   public ActionForward resetBalance(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
     throws SQLException, Exception
   {
/* 133 */     if (Constants.isSessionActive(request)) {
/* 134 */       MasterDataForm masterData = (MasterDataForm)form;
/* 135 */       new BalanceDAO().resetBalance();
/* 136 */       masterData.setMessage("Data resetted.");
/* 137 */       return mapping.findForward("display");
     }
/* 139 */     return mapping.findForward("exp");
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\masters\MasterDataAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */