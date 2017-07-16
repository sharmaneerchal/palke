package com.myapp.struts.group;

import com.myapp.struts.Utility.Constants;
import com.myapp.struts.Utility.DropDownFill;
import com.myapp.struts.beans.DrawDetailsData;
import com.myapp.struts.beans.GroupDetails;
import com.myapp.struts.dao.GroupsDAO;
import com.myapp.struts.dao.MembersDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mappings.Drawtypes;
import mappings.Groups;
import mappings.Members;
import mappings.Positions;
import mappings.Users;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class GroupCreationAction
        extends DispatchAction {

    /*  39 */ GroupsDAO objDAO = new GroupsDAO();
    /*  40 */    MembersDAO membersdao = new MembersDAO();
    List<Drawtypes> lstDrawtypes;
    List<Positions> lstPositions;

    public ActionForward displayGroups(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /*  46 */ if (Constants.isSessionActive(request)) {
            /*  47 */ GroupCreationForm groupcreationForm = (GroupCreationForm) form;
            /*  48 */ reset(groupcreationForm);

            /*  73 */ groupcreationForm.getDrawDetailsList().clear();
            /*  74 */ groupcreationForm.setMessage("");
            /*  75 */ List<GroupDetails> lstGroupDetailses = displaygroupdetails();
            /*  76 */ groupcreationForm.getGroupDetails().clear();
            /*  77 */ groupcreationForm.getGroupDetails().addAll(lstGroupDetailses);

            /*  79 */ return mapping.findForward("display");
        }
        /*  81 */ return mapping.findForward("exp");
    }

    private List<GroupDetails> displaygroupdetails() {
        /*  86 */ List<GroupDetails> lstgroupdetails = new ArrayList();
        try {
            /*  88 */ List<Groups> lstgroups = this.objDAO.getGroupDetails();
            /*  89 */ lstgroupdetails.clear();
            /*  90 */ for (int i = 0; i < lstgroups.size(); i++) {
                /*  91 */ Groups groups = (Groups) lstgroups.get(i);

                /*  93 */ GroupDetails groupDetails = new GroupDetails();
                /*  94 */ groupDetails.setBonousamount((int) groups.getBonousamount());
                /*  95 */ SimpleDateFormat dat = new SimpleDateFormat("dd/MM/yyyy");

                /*  97 */ groupDetails.setGroupid(groups.getGroupid());
                /*  98 */ List<Members> lstmembers = this.membersdao.getMemebersInfo(groups.getGroupid());
                /*  99 */ groupDetails.setNoofexistmembers(lstmembers.size());
                /* 100 */ groupDetails.setGroupname(groups.getGroupname());
                /* 101 */ groupDetails.setInstallmentamount((int) groups.getInstallmentamount());
                /* 102 */ groupDetails.setNoofinstallments(groups.getNoofinstallment());
                /* 103 */ groupDetails.setNoofmembers(groups.getNoofmembers());
                /* 104 */ groupDetails.setRowid(i + 1);
                /* 105 */ String strDate = dat.format(groups.getStartdate());
                /* 106 */ groupDetails.setStartdate(strDate);
                /* 107 */ String enddate = dat.format(groups.getEnddate());
                /* 108 */ groupDetails.setEnddate(enddate);

                /* 110 */ groupDetails.setCreatedby(groups.getCreatedby());
                /* 111 */ groupDetails.setCreateddate(groups.getCreateddate());

                /* 136 */ int isComplete = new MembersDAO().checkGroupStatus(groups.getGroupid());
                switch (isComplete) {
                    case 0:
                        groupDetails.setStatus("Created");
                        break;
                    case 1:
                        groupDetails.setStatus("Running");
                        break;
                    case 2:
                        groupDetails.setStatus("Terminated");
                        break;
                    default:
                        break;
                }
                lstgroupdetails.add(groupDetails);
            }
        } catch (Exception e) {
        }

        /* 199 */ return lstgroupdetails;
    }

    public ActionForward OK(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException {
        /* 223 */ if (Constants.isSessionActive(request)) {
            /* 224 */ GroupCreationForm groupcreationForm = (GroupCreationForm) form;

            /* 226 */ DrawDetailsData temp = new DrawDetailsData();

            /* 228 */ for (int i = 0; i < groupcreationForm.getDrawtypes().size(); i++) {
                /* 229 */ int drawtypeid = ((DropDownFill) groupcreationForm.getDrawtypes().get(i)).getId();
                /* 230 */ if (drawtypeid == groupcreationForm.getDrawtype()) {
                    /* 232 */ temp.setDrawtype(((DropDownFill) groupcreationForm.getDrawtypes().get(i)).getLabel());
                    /* 233 */ temp.setDrawtypeid(drawtypeid);
                    /* 234 */ break;
                }
            }

            /* 238 */ temp.setAmount(groupcreationForm.getPlaceamount());

            /* 240 */ for (int i = 0; i < groupcreationForm.getPositions().size(); i++) {
                /* 241 */ int positionid = ((DropDownFill) groupcreationForm.getPositions().get(i)).getId();
                /* 242 */ if (positionid == groupcreationForm.getPosition()) {
                    /* 244 */ temp.setPosition(((DropDownFill) groupcreationForm.getPositions().get(i)).getLabel());
                    /* 245 */ temp.setPositionid(positionid);
                    /* 246 */ break;
                }
            }
            /* 249 */ groupcreationForm.getDrawDetailsList().add(temp);

            /* 251 */ groupcreationForm.setDrawtype(0);
            /* 252 */ groupcreationForm.setPosition(0);
            /* 253 */ groupcreationForm.setPlaceamount(0.0D);

            /* 255 */ return mapping.findForward("display");
        }
        /* 257 */ return mapping.findForward("exp");
    }

    public ActionForward deleteDrawDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        /* 263 */ if (Constants.isSessionActive(request)) {
            /* 264 */ GroupCreationForm groupcreationForm = (GroupCreationForm) form;

            /* 266 */ for (int i = 0; i < groupcreationForm.getDrawDetailsList().size(); i++) {
                /* 267 */ if (groupcreationForm.getDrawtype() == ((DrawDetailsData) groupcreationForm.getDrawDetailsList().get(i)).getDrawtypeid()) {
                    /* 268 */ groupcreationForm.getDrawDetailsList().remove(i);
                    /* 269 */ break;
                }
            }

            /* 273 */ groupcreationForm.setDrawtype(0);
            /* 274 */ return mapping.findForward("display");
        }

        /* 277 */ return mapping.findForward("exp");
    }

    public ActionForward resetPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        /* 283 */ if (Constants.isSessionActive(request)) {
            /* 284 */ GroupCreationForm groupcreationForm = (GroupCreationForm) form;
            /* 285 */ reset(groupcreationForm);
            /* 286 */ return mapping.findForward("display");
        }

        /* 289 */ return mapping.findForward("exp");
    }

    private void reset(GroupCreationForm groupcreationForm) {
        /* 294 */ groupcreationForm.setDrawtype(0);
        /* 295 */ groupcreationForm.setEndDate(null);
        /* 296 */ groupcreationForm.setGroupName("");
        /* 297 */ groupcreationForm.setInstallmentamount(0.0D);
        /* 298 */ groupcreationForm.setNoofinstallment(0);
        /* 299 */ groupcreationForm.setNoofmembers(0);
        /* 300 */ groupcreationForm.setPlaceamount(0.0D);
        /* 301 */ groupcreationForm.setPosition(0);
        /* 302 */ groupcreationForm.setStartDate(null);
        /* 303 */ groupcreationForm.setBonusamount(0.0D);
        /* 304 */ groupcreationForm.getDrawDetailsList().clear();
        /* 305 */ groupcreationForm.setMessage("");
        /* 306 */ groupcreationForm.setEdit(false);
    }

    public ActionForward saveGroup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /* 311 */ if (Constants.isSessionActive(request)) {
            /* 312 */ GroupCreationForm groupcreationForm = (GroupCreationForm) form;
            try {
                /* 315 */ HttpSession session = request.getSession();
                /* 316 */ Users userId = (Users) session.getAttribute("user");
                /* 328 */ SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

                /* 321 */ if (groupcreationForm.isEdit()) {
                    /* 323 */ Groups groups = new Groups();
                    /* 324 */ groups.setGroupid(groupcreationForm.getRowid());

                    /* 326 */ groups.setCreatedby(userId.getUserid());
                    /* 327 */ groups.setCreateddate(new Date());

                    /* 330 */ groups.setEnddate(date.parse(groupcreationForm.getEndDate()));
                    /* 331 */ groups.setStartdate(date.parse(groupcreationForm.getStartDate()));
                    /* 332 */ groups.setGroupname(groupcreationForm.getGroupName());
                    /* 333 */ groups.setInstallmentamount(groupcreationForm.getInstallmentamount());
                    /* 334 */ groups.setNoofinstallment(groupcreationForm.getNoofinstallment());
                    /* 335 */ groups.setNoofmembers(groupcreationForm.getNoofmembers());

                    /* 392 */ new GroupsDAO().saveGroup(groups, groupcreationForm.isEdit());

                    /* 394 */ reset(groupcreationForm);
                    /* 395 */ groupcreationForm.setMessage("Group details updated successfully.");
                } else {
                    /* 399 */ Groups groups = new Groups();
                    /* 400 */ groups.setBonousamount(groupcreationForm.getBonusamount());
                    /* 401 */ groups.setCreatedby(userId.getUserid());
                    /* 402 */ groups.setCreateddate(new Date());
                    /* 330 */ groups.setEnddate(date.parse(groupcreationForm.getEndDate()));
                    /* 331 */ groups.setStartdate(date.parse(groupcreationForm.getStartDate()));
                    /* 434 */ groups.setGroupname(groupcreationForm.getGroupName());
                    /* 435 */ groups.setInstallmentamount(groupcreationForm.getInstallmentamount());
                    /* 436 */ groups.setNoofinstallment(groupcreationForm.getNoofinstallment());
                    /* 437 */ groups.setNoofmembers(groupcreationForm.getNoofmembers());

                    /* 493 */ new GroupsDAO().saveGroup(groups, groupcreationForm.isEdit());

                    /* 495 */ reset(groupcreationForm);
                    /* 496 */ groupcreationForm.setMessage("Group created successfully.");
                }
                /* 499 */ List<GroupDetails> lstGroupDetailses = displaygroupdetails();
                /* 500 */ groupcreationForm.getGroupDetails().clear();
                /* 501 */ groupcreationForm.getGroupDetails().addAll(lstGroupDetailses);
            } catch (Exception ex) {
                /* 504 */ groupcreationForm.setMessage("Error while creating group.");
            } finally {
                /* 506 */ return mapping.findForward("display");
            }
        }
        /* 509 */ return mapping.findForward("exp");
    }

    public ActionForward deleteGroup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 537 */ if (Constants.isSessionActive(request)) {
            /* 538 */ GroupCreationForm groupcreationForm = (GroupCreationForm) form;
            /* 539 */ GroupsDAO dao = new GroupsDAO();
            try {
                /* 542 */ HttpSession session = request.getSession();
                /* 543 */ boolean admin = ((Boolean) session.getAttribute("admin")).booleanValue();

                /* 545 */ if (!admin) {
                    /* 546 */ groupcreationForm.setMessage("You are not authorized to do this action.");
                    /* 547 */ ActionForward localActionForward = mapping.findForward("display");
                    return localActionForward;
                }
                /* 549 */ if (groupcreationForm.isWithmember()) {
                    /* 550 */ for (int i = 0; i < groupcreationForm.getGroupDetails().size(); i++) {
                        /* 551 */ if (((GroupDetails) groupcreationForm.getGroupDetails().get(i)).getGroupid() == groupcreationForm.getRowid()) {
                            /* 553 */ groupcreationForm.setMessage("Group " + ((GroupDetails) groupcreationForm.getGroupDetails().get(i)).getGroupname() + " is deleted.");
                            /* 554 */ dao.deleteGroupwithMember(groupcreationForm.getRowid());
                            /* 555 */ groupcreationForm.getGroupDetails().remove(i);
                            /* 556 */ groupcreationForm.setEdit(false);
                            /* 557 */ reset(groupcreationForm);

                            /* 559 */ List<GroupDetails> lstGroupDetailses = displaygroupdetails();
                            /* 560 */ groupcreationForm.getGroupDetails().clear();
                            /* 561 */ groupcreationForm.getGroupDetails().addAll(lstGroupDetailses);

                            /* 563 */ break;
                        }
                    }
                } else {
                    /* 567 */ Object lstmembers = this.membersdao.getMemebersInfo(groupcreationForm.getRowid());
                    /* 568 */ if (((List) lstmembers).size() <= 0) {

                        /* 571 */ for (int i = 0; i < groupcreationForm.getGroupDetails().size(); i++) {
                            /* 572 */ if (((GroupDetails) groupcreationForm.getGroupDetails().get(i)).getGroupid() == groupcreationForm.getRowid()) {
                                /* 574 */ dao.deleteGroup(groupcreationForm.getRowid());
                                /* 575 */ groupcreationForm.setEdit(false);
                                /* 576 */ reset(groupcreationForm);
                                /* 577 */ groupcreationForm.setMessage("Group " + ((GroupDetails) groupcreationForm.getGroupDetails().get(i)).getGroupname() + " is deleted.");
                                /* 578 */ groupcreationForm.getGroupDetails().remove(i);

                                /* 580 */ List<GroupDetails> lstGroupDetailses = displaygroupdetails();
                                /* 581 */ groupcreationForm.getGroupDetails().clear();
                                /* 582 */ groupcreationForm.getGroupDetails().addAll(lstGroupDetailses);

                                /* 584 */ break;
                            }

                        }
                    } else {
                        /* 589 */ groupcreationForm.setMessage("Memebers found under this group.");
                    }
                }
            } catch (Exception ex) {
                /* 593 */ ex
                        = /* 597 */ ex;
                throw ex;
            } finally {
            }
            /* 598 */ return mapping.findForward("display");
        }
        /* 600 */ return mapping.findForward("exp");
    }

    public ActionForward editGroup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 606 */ if (Constants.isSessionActive(request)) {
            /* 607 */ GroupCreationForm groupcreationForm = (GroupCreationForm) form;
            groupcreationForm.setMessage("");
            try {
                /* 610 */ HttpSession session = request.getSession();
                /* 611 */ boolean admin = ((Boolean) session.getAttribute("admin"));

                /* 613 */ if (!admin) {
                    /* 614 */ groupcreationForm.setMessage("You are not authorized to do this action.");
                    /* 615 */ ActionForward localActionForward = mapping.findForward("display");

                    /* 654 */ return mapping.findForward("display");
                }
                /* 618 */ for (int i = 0; i < groupcreationForm.getGroupDetails().size(); i++) {
                    /* 619 */ if (((GroupDetails) groupcreationForm.getGroupDetails().get(i)).getGroupid() == groupcreationForm.getRowid()) {
                        /* 620 */ GroupDetails groupDetails = (GroupDetails) groupcreationForm.getGroupDetails().get(i);
                        /* 621 */ groupcreationForm.setEdit(true);
                        /* 622 */ groupcreationForm.setBonusamount(groupDetails.getBonousamount());
                        /* 623 */ groupcreationForm.setEndDate(groupDetails.getEnddate());
                        /* 624 */ groupcreationForm.setStartDate(groupDetails.getStartdate());
                        /* 625 */ groupcreationForm.setGroupName(groupDetails.getGroupname());
                        /* 626 */ groupcreationForm.setInstallmentamount(groupDetails.getInstallmentamount());
                        /* 627 */ groupcreationForm.setNoofinstallment(groupDetails.getNoofinstallments());
                        /* 628 */ groupcreationForm.setNoofmembers(groupDetails.getNoofmembers());

                        /* 645 */ groupcreationForm.setEdit(true);
                        /* 646 */ break;
                    }
                }
            } catch (Exception ex) {
                /* 651 */ throw ex;
            } finally {
                /* 654 */ return mapping.findForward("display");
            }
        }
        /* 657 */ return mapping.findForward("exp");
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\group\GroupCreationAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
