package com.myapp.struts.member;

import com.myapp.struts.Utility.Constants;
import com.myapp.struts.Utility.DropDownFill;
import com.myapp.struts.beans.MemberDetails;
import com.myapp.struts.dao.DrawDetailsDAO;
import com.myapp.struts.dao.GroupsDAO;
import com.myapp.struts.dao.MembersDAO;
import com.myapp.struts.dao.PaymentDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mappings.Drawdetails;
import mappings.Groups;
import mappings.Members;
import mappings.Payment;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class AddMemberAction
        extends DispatchAction {

    /*  39 */ MembersDAO objDAO = new MembersDAO();
    /*  40 */    GroupsDAO groupsdao = new GroupsDAO();
    /*  41 */    int nextMemberNo = 0;

    public ActionForward displayGroups(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /*  45 */ if (Constants.isSessionActive(request)) {
            /*  46 */ AddMemberForm addMemberForm = (AddMemberForm) form;
            /*  47 */ addMemberForm.setGroup(0);
            /*  48 */ addMemberForm.setMemberid(0);
            /*  49 */ addMemberForm.setAddress("");
            /*  50 */ addMemberForm.setMembername("");
            /*  51 */ addMemberForm.setMemberno(0);
            /*  52 */ addMemberForm.setContactno("");
            /*  53 */ addMemberForm.setEmail("");
            /*  54 */ addMemberForm.getLstMembers().clear();

            /*  58 */ List<DropDownFill> dropDowListDT = new ArrayList();
            /*  59 */ List<Groups> lstGroups = this.groupsdao.getGroup();

            /*  61 */ for (int i = 0; i < lstGroups.size(); i++) {
                /*  62 */ Groups groups = (Groups) lstGroups.get(i);
                /*  63 */ dropDowListDT.add(new DropDownFill(groups.getGroupid(), groups.getGroupname()));
            }
            /*  65 */ addMemberForm.setGroups(dropDowListDT);
            /*  66 */ addMemberForm.setMessage("");
            /*  67 */ addMemberForm.setEdit(false);
            /*  68 */ return mapping.findForward("display");
        }
        /*  70 */ return mapping.findForward("exp");
    }

    public ActionForward saveMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  76 */ if (Constants.isSessionActive(request)) {
            /*  77 */ AddMemberForm addMemberForm = (AddMemberForm) form;

            /*  79 */ MembersDAO dao = new MembersDAO();
            try {
                /*  82 */ if (addMemberForm.isEdit()) {
                    /*  83 */ Members members = new Members();
                    /*  84 */ members.setCompleted(false);
                    /*  85 */ members.setContactno(addMemberForm.getContactno());
                    /*  86 */ members.setEmailid(addMemberForm.getEmail());
                    /*  87 */ members.setMemberaddress(addMemberForm.getAddress());
                    /*  88 */ members.setMembername(addMemberForm.getMembername());
                    /*  89 */ members.setJoindate(new Date());

                    /*  91 */ members.setMemberno(addMemberForm.getMemberno());
                    /*  92 */ members.setMemberid(addMemberForm.getMemberid());
                    /*  95 */ members.setGroupid(addMemberForm.getGroup());
                    /*  96 */ members.setRemarks("");
                    /*  97 */ members.setStatus("In Progress");
                    /*  98 */ dao.saveMember(members, true);
                } else {
                    /* 100 */ Members members = new Members();
                    /* 101 */ members.setCompleted(false);
                    /* 102 */ members.setContactno(addMemberForm.getContactno());
                    /* 103 */ members.setEmailid(addMemberForm.getEmail());
                    /* 104 */ members.setMemberaddress(addMemberForm.getAddress());
                    /* 105 */ members.setMembername(addMemberForm.getMembername());
                    /* 106 */ members.setJoindate(new Date());
                    /* 107 */ int nextMemberno = this.objDAO.getNextMemberNo(addMemberForm.getGroup());
                    /* 108 */ members.setMemberno(nextMemberno);
                    /* 109 */ members.setMemberid(addMemberForm.getMemberid());
                    /* 112 */ members.setGroupid(addMemberForm.getGroup());
                    /* 113 */ members.setStatus("In Progress");
                    /* 114 */ members.setRemarks("");
                    /* 115 */ dao.saveMember(members, false);
                }

                /* 118 */ addMemberForm.setMemberid(0);
                /* 119 */ addMemberForm.setAddress("");
                /* 120 */ addMemberForm.setMembername("");
                /* 121 */ addMemberForm.setContactno("");
                /* 122 */ addMemberForm.setEmail("");
                /* 123 */ addMemberForm.setMemberno(0);

                /* 125 */ addMemberForm.getLstMembers().clear();
                /* 126 */ setMembers(addMemberForm);
                /* 127 */ addMemberForm.setEdit(false);
                /* 128 */ addMemberForm.setMessage("Saved successfully.");
            } catch (Exception e) {
                /* 131 */ addMemberForm.setMessage("Errot while saving Member(s).");
            }
            /* 133 */ return mapping.findForward("display");
        }
        /* 135 */ return mapping.findForward("exp");
    }

    public ActionForward clear(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 141 */ if (Constants.isSessionActive(request)) {
            /* 142 */ AddMemberForm addMemberForm = (AddMemberForm) form;
            /* 143 */ addMemberForm.setMemberid(0);
            /* 144 */ addMemberForm.setAddress("");
            /* 145 */ addMemberForm.setMembername("");
            /* 146 */ addMemberForm.setContactno("");
            /* 147 */ addMemberForm.setEmail("");
            /* 148 */ addMemberForm.setMemberno(0);
            /* 149 */ return mapping.findForward("display");
        }
        /* 151 */ return mapping.findForward("exp");
    }

    public ActionForward getMemberDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 157 */ if (Constants.isSessionActive(request)) {
            /* 158 */ AddMemberForm addMemberForm = (AddMemberForm) form;
            /* 159 */ addMemberForm.getLstMembers().clear();
            /* 160 */ this.nextMemberNo = 0;

            /* 162 */ setMembers(addMemberForm);
            /* 163 */ addMemberForm.setEdit(false);

            /* 165 */ HttpSession session = request.getSession();

            /* 167 */ return mapping.findForward("display");
        }
        /* 169 */ return mapping.findForward("exp");
    }

    public ActionForward getMemberDetailsbymemberid(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 175 */ if (Constants.isSessionActive(request)) {
            /* 176 */ AddMemberForm addMemberForm = (AddMemberForm) form;
            /* 177 */ addMemberForm.getLstMembers().clear();
            /* 178 */ this.nextMemberNo = 0;

            /* 180 */ setMembersbymemberid(addMemberForm);
            /* 181 */ addMemberForm.setEdit(false);
            /* 182 */ return mapping.findForward("display");
        }
        /* 184 */ return mapping.findForward("exp");
    }

    public void setMembers(AddMemberForm addMemberForm) {
        /* 190 */ MembersDAO dao = new MembersDAO();
        try {
            /* 193 */ List<Members> lstMember = dao.getMemberDetails(addMemberForm.getGroup());
            /* 194 */ addMemberForm.getLstMembers().clear();

            /* 196 */ for (int i = 0; i < lstMember.size(); i++) {
                /* 197 */ Members members = (Members) lstMember.get(i);

                /* 199 */ MemberDetails temp = new MemberDetails();

                /* 201 */ temp.setGroupid(members.getGroupid());
                /* 202 */ temp.setMembername(members.getMembername());
                /* 203 */ temp.setMemberaddress(members.getMemberaddress());
                /* 204 */ temp.setContactno(members.getContactno());
                /* 205 */ temp.setEmail(members.getEmailid());
                /* 206 */ temp.setMemberid(members.getMemberid());
                /* 207 */ SimpleDateFormat dat = new SimpleDateFormat("dd-MM-yyyy");
                /* 208 */ String joindate = dat.format(members.getJoindate());
                /* 209 */ temp.setJoinDate(joindate);
                /* 210 */ temp.setDate(members.getJoindate());
                /* 211 */ temp.setMemberno(members.getMemberno());
                /* 212 */ addMemberForm.getLstMembers().add(temp);
            }
        } catch (Exception e) {
        }
    }

    public void setMembersbymemberid(AddMemberForm addMemberForm) {
        /* 222 */ MembersDAO dao = new MembersDAO();
        try {
            /* 224 */ List<Members> lstMember = new MembersDAO().getMembers(addMemberForm.getGroup(), addMemberForm.getSelectedmember());
            /* 225 */ addMemberForm.getLstMembers().clear();

            /* 227 */ for (int i = 0; i < lstMember.size(); i++) {
                /* 228 */ Members members = (Members) lstMember.get(i);

                /* 230 */ MemberDetails temp = new MemberDetails();

                /* 232 */ temp.setGroupid(members.getGroupid());
                /* 233 */ temp.setMembername(members.getMembername());
                /* 234 */ temp.setMemberaddress(members.getMemberaddress());
                /* 235 */ temp.setContactno(members.getContactno());
                /* 236 */ temp.setEmail(members.getEmailid());
                /* 237 */ temp.setMemberid(members.getMemberid());
                /* 238 */ SimpleDateFormat dat = new SimpleDateFormat("dd-MM-yyyy");
                /* 239 */ String joindate = dat.format(members.getJoindate());
                /* 240 */ temp.setJoinDate(joindate);
                /* 241 */ temp.setDate(members.getJoindate());
                /* 242 */ temp.setMemberno(members.getMemberno());
                /* 243 */ addMemberForm.getLstMembers().add(temp);
            }
        } catch (Exception e) {
        }
    }

    public ActionForward removeMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        /* 253 */ if (Constants.isSessionActive(request)) {
            /* 254 */ AddMemberForm addMemberForm = (AddMemberForm) form;
            /* 255 */ MembersDAO dao = new MembersDAO();

            /* 257 */ HttpSession session = request.getSession();
            /* 258 */ boolean admin = ((Boolean) session.getAttribute("admin"));

            /* 260 */ if (!admin) {
                /* 261 */ addMemberForm.setMessage("You are not authorized to do this action.");
                /* 262 */ return mapping.findForward("display");
            }

            /* 265 */ for (int i = 0; i < addMemberForm.getLstMembers().size(); i++) {
                /* 266 */ if (addMemberForm.getMemberid() == ((MemberDetails) addMemberForm.getLstMembers().get(i)).getMemberid()) {
                    /* 268 */ List<Payment> lstpayment = new PaymentDAO().getPaymentData(((MemberDetails) addMemberForm.getLstMembers().get(i)).getMemberid());
                    /* 269 */ if (lstpayment.size() <= 0) {
                        /* 270 */ List<Drawdetails> lstDrawDetails = new DrawDetailsDAO().getDrawData(((MemberDetails) addMemberForm.getLstMembers().get(i)).getMemberid());
                        /* 271 */ if (lstDrawDetails.size() <= 0) {
                            /* 272 */ Members obj = new Members();
                            /* 273 */ obj.setMemberid(((MemberDetails) addMemberForm.getLstMembers().get(i)).getMemberid());
                            /* 274 */ obj.setStatus("");
                            /* 275 */ obj.setRemarks("");
                            /* 276 */ dao.removeMember(obj);
                            /* 277 */ addMemberForm.setMessage("Member " + ((MemberDetails) addMemberForm.getLstMembers().get(i)).getMembername() + " (" + ((MemberDetails) addMemberForm.getLstMembers().get(i)).getMemberno() + ") is deleted.");
                            /* 278 */ addMemberForm.setEdit(false);
                        } else {
                            /* 280 */ addMemberForm.setMessage("Draw entry found for member. Member cannot be deleted");
                        }
                        /* 282 */ break;
                    }
                    /* 283 */ addMemberForm.setMessage("Payment details found. Member cannot be deleted");

                    /* 286 */ break;
                }
            }

            /* 290 */ setMembers(addMemberForm);
            /* 291 */ addMemberForm.setMemberid(0);
            /* 292 */ return mapping.findForward("display");
        }
        /* 294 */ return mapping.findForward("exp");
    }

    public ActionForward editMembers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        /* 300 */ if (Constants.isSessionActive(request)) {
            /* 301 */ AddMemberForm addMemberForm = (AddMemberForm) form;

            /* 303 */ HttpSession session = request.getSession();
            /* 304 */ boolean admin = ((Boolean) session.getAttribute("admin"));

            /* 306 */ if (!admin) {
                /* 307 */ addMemberForm.setMessage("You are not authorized to do this action.");
                /* 308 */ return mapping.findForward("display");
            }

            /* 311 */ for (int i = 0; i < addMemberForm.getLstMembers().size(); i++) {
                /* 312 */ if (addMemberForm.getMemberid() == ((MemberDetails) addMemberForm.getLstMembers().get(i)).getMemberid()) {
                    /* 314 */ addMemberForm.setMemberno(((MemberDetails) addMemberForm.getLstMembers().get(i)).getMemberno());
                    /* 315 */ addMemberForm.setMemberid(((MemberDetails) addMemberForm.getLstMembers().get(i)).getMemberid());
                    /* 316 */ addMemberForm.setEmail(((MemberDetails) addMemberForm.getLstMembers().get(i)).getEmail());
                    /* 317 */ addMemberForm.setAddress(((MemberDetails) addMemberForm.getLstMembers().get(i)).getMemberaddress());
                    /* 318 */ addMemberForm.setMembername(((MemberDetails) addMemberForm.getLstMembers().get(i)).getMembername());
                    /* 319 */ addMemberForm.setContactno(((MemberDetails) addMemberForm.getLstMembers().get(i)).getContactno());
                    /* 320 */ addMemberForm.setGroup(((MemberDetails) addMemberForm.getLstMembers().get(i)).getGroupid());

                    /* 322 */ addMemberForm.setEdit(true);
                    /* 323 */ break;
                }
            }
            /* 326 */ return mapping.findForward("display");
        }
        /* 328 */ return mapping.findForward("exp");
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\member\AddMemberAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
