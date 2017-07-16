/*    */ package com.myapp.struts.Utility;

/*    */
 /*    */ import java.math.BigDecimal;
/*    */ import java.math.RoundingMode;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;

/*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */ public class Constants /*    */ {

    /*    */ public static final String GOLD = "Gold";
    /*    */    public static final String Silver = "Silver";
    /*    */    public static final String Stone = "Stone, Pearls etc";
    /*    */    public static final String Diamonds = "Diamonds";
    /*    */    public static final String Copper = "Copper";
    /*    */    public static final String PURCHASEVOUCHER = "Purchase Voucher";
    /*    */    public static final String RECEIPTVOUCHER = "Receipt Voucher";
    /*    */    public static final String WORKERSMEMO = "Workers Memo";

    /*    */
 /*    */ public static String getVoucherType(String VocuherType) /*    */ {
        /* 31 */ if (VocuherType.equalsIgnoreCase("P")) /* 32 */ {
            return "Purchase Voucher";
        }
        /* 33 */ if (VocuherType.equalsIgnoreCase("R")) /* 34 */ {
            return "Receipt Voucher";
        }
        /* 35 */ if (VocuherType.equalsIgnoreCase("R")) {
            /* 36 */ return "Receipt Voucher";
            /*    */        }
        /* 38 */ return "";
        /*    */    }

    /*    */
 /*    */
 /*    */ public static double amountRounding(double d) /*    */ {
        /* 44 */ BigDecimal bd = new BigDecimal(d).setScale(3, RoundingMode.HALF_EVEN);
        /* 45 */ d = bd.doubleValue();
        /*    */
 /* 47 */ return d;
        /*    */    }

    /*    */
 /*    */ public static boolean isSessionActive(HttpServletRequest request) {
        /* 51 */ String chk = GetUserid(request);
        /* 52 */ if (chk != null) {
            /* 53 */ return true;
            /*    */        }
        /* 55 */ return false;
        /*    */    }

    /*    */
 /*    */
 /*    */ public static String GetUserid(HttpServletRequest request) /*    */ {
        /* 61 */ HttpSession session = request.getSession();
        /* 62 */ String x = (String) session.getAttribute("userName");
        /* 63 */ return x;
        /*    */    }
    /*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\Utility\Constants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
