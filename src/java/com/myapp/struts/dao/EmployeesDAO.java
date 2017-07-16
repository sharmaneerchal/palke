package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mappings.Employees;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeesDAO {

    private static final Logger log = Logger.getLogger(EmployeesDAO.class);

    public Employees getEmployee(int empid) {
        Session session = null;
        Transaction transaction = null;
        /* 28 */ List<Employees> listemp = new ArrayList();
        try {
            session = HibernateConnector.getInstance().getSession();


            /* 30 */ Query q = session.createSQLQuery("select * from employees where employeeid=?").addEntity(Employees.class);

            /* 32 */ q.setInteger(1, empid);

            /* 34 */ listemp = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        return (Employees) listemp.get(0);
    }

    public Employees getEmployee(String emp) {
        Session session = null;
        Transaction transaction = null;
        /* 28 */ List<Employees> listemp = new ArrayList();
        try {
            session = HibernateConnector.getInstance().getSession();


            /* 30 */ Query q = session.createSQLQuery("select * from employees where name='" + emp + "'").addEntity(Employees.class);


            /* 34 */ listemp = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        return (Employees) listemp.get(0);
    }

    public HashMap getEmployee() {
        Session session = null;
        Transaction transaction = null;

        /* 48 */ HashMap hmMap = new HashMap();
        /* 49 */ HashMap hmEmp = new HashMap();
        /* 50 */ List<Employees> listemp = new ArrayList();
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 52 */ Query q = session.createSQLQuery("select * from employees").addEntity(Employees.class);

            /* 55 */ listemp = q.list();
            /* 56 */ for (int i = 0; i < listemp.size(); i++) {
                /* 57 */ Employees employees = (Employees) listemp.get(i);
                /* 58 */ hmEmp.put(employees.getEmployeeid() + "", employees);
            }
            /* 60 */ hmMap.put("map", hmEmp);
            /* 61 */ hmMap.put("list", listemp);

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 66 */ return hmMap;
    }

    public List<Employees> getEmployees() {
        Session session = null;

        List<Employees> listemp = new ArrayList();
        try {
            session = HibernateConnector.getInstance().getSession();

            Query q = session.createSQLQuery("select * from employees").addEntity(Employees.class);

            listemp = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        return listemp;
    }

    public void saveEmpoyee(Employees obj, boolean edit) throws Exception {

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 74 */ if (edit) {
                /* 75 */ session.update(obj);
            } else {
                /* 77 */ session.save(obj);
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\EmployeesDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
