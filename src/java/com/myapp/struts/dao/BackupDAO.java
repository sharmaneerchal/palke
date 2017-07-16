package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import mappings.Backup;
import mappings.Items;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BackupDAO {

    private static final Logger log = Logger.getLogger(BackupDAO.class);

    public boolean isBackupdone(Date date)
            throws Exception {
        Session session = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Backup> backup = new ArrayList<Backup>();
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 30 */ Query q = session.createSQLQuery("select * from backup where DATE_FORMAT(date,'%d-%m-%Y')='" + sdf.format(date) + "'").addEntity(Backup.class);

            /* 32 */ backup = (List<Backup>) q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 38 */ return !backup.isEmpty();
    }

    public void saveItem(Backup obj) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            /* 70 */ session.save(obj);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\ItemsDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
