package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mappings.Groupdrawpositions;
import mappings.Positions;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PositionsDAO {

    private static final Logger log = Logger.getLogger(PositionsDAO.class);

    public List<Positions> getPositions()
            throws Exception {
        /*  27 */ List<Positions> list_positions = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();

            /*  33 */ Query q = session.createSQLQuery("select * from positions").addEntity(Positions.class);

            /*  35 */ list_positions = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  40 */ return list_positions;
    }

    public static List<Positions> getPositionsforshow(int positionid) throws Exception {
        /*  44 */ List<Positions> list_Positions = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();

            /*  50 */ Query q = session.createSQLQuery("select * from positions where positionid in(select positionid from groupdrawpositions where positionid=" + positionid + ")").addEntity(Positions.class);

            /*  52 */ list_Positions = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  56 */ return list_Positions;
    }

    public HashMap getPositions(int groupdrawdetailsid) throws Exception {
        /*  61 */ HashMap hmPosiotions = new HashMap();
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();

            /*  67 */ Query q = session.createSQLQuery("select * from groupdrawpositions where groupdrawdetailsid=" + groupdrawdetailsid).addEntity(Groupdrawpositions.class);

            /*  69 */ List<Groupdrawpositions> list_groupdrawpositions = q.list();
            /*  70 */ hmPosiotions.put("groupdrawpositions", list_groupdrawpositions);
            /*  71 */ List<Positions> list_Positions = new ArrayList();
            /*  72 */ for (int i = 0; i < list_groupdrawpositions.size(); i++) {
                /*  73 */ Groupdrawpositions groupdrawpositions = (Groupdrawpositions) list_groupdrawpositions.get(i);

                /*  75 */ q = session.createSQLQuery("select * from positions where positionid=" + groupdrawpositions.getPositionid()).addEntity(Positions.class);

                /*  77 */ list_Positions = q.list();
            }
            /*  79 */ hmPosiotions.put("positions", list_Positions);
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  83 */ return hmPosiotions;
    }

    public void savePositions(Positions positions) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /*  92 */ session.save(positions);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void deletePositions(Positions positions) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 106 */ session.delete(positions);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\PositionsDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
