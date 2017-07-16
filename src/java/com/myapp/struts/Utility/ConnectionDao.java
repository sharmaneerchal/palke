package com.myapp.struts.Utility;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ConnectionDao {

    /* 25 */ private static final Logger log = Logger.getLogger(ConnectionDao.class);

    public ConnectionDao() {
        /* 28 */ PropertyConfigurator.configure("log4j.Properties");
    }

    public static Connection getConnection()
            throws Exception {
        /* 43 */ String url = "jdbc:mysql://localhost:3306/jewellery";
        /* 44 */ Class.forName("com.mysql.jdbc.Driver").newInstance();
        /* 45 */ Connection connect = DriverManager.getConnection(url, "root", "root");
        /* 46 */ return connect;
    }

    public static void closeResources(Connection conn, Statement st, ResultSet rs) {
        try {
            /* 51 */ System.out.print("now closing statement -------------");
            /* 52 */ log.info("now closing statement -------------");
            /* 53 */ st.close();
            /* 54 */ st = null;
            /* 55 */ System.out.print("now closing ResultSet -------------");
            /* 56 */ log.info("now closing ResultSet -------------");
            /* 57 */ rs.close();
            /* 58 */ rs = null;
            /* 59 */ System.out.println("now closing Connection ------------");
            /* 60 */ log.info("now closing Connection ------------");
            /* 61 */ conn.close();
            /* 62 */ conn = null;
        } catch (Exception e) {
            /* 64 */ System.out.println("Some exception closing resources ---------\n" + e.getMessage());
            /* 65 */ log.info("Some exception closing resources ---------\n" + e.getMessage());
        }
    }

    public static void closeResources(Connection conn, Statement st) {
        try {
            /* 71 */ System.out.print("now closing statement -------------");
            /* 72 */ log.info("now closing statement -------------");
            /* 73 */ st.close();
            /* 74 */ st = null;
            /* 75 */ System.out.println("now closing Connection ------------");
            /* 76 */ log.info("now closing Connection ------------");
            /* 77 */ conn.close();
            /* 78 */ conn = null;
        } catch (Exception e) {
            /* 80 */ System.out.println("Some exception closing resources ---------\n" + e.getMessage());
            /* 81 */ log.info("Some exception closing resources ---------\n" + e.getMessage());
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\Utility\ConnectionDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
