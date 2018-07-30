package ru.petshop.petshopinterview.ablokhin.dao.daoimplementations;

import org.hibernate.Session;
import ru.petshop.petshopinterview.ablokhin.dao.OwnerDao;
import ru.petshop.petshopinterview.ablokhin.persistence.Owner;
import ru.petshop.petshopinterview.ablokhin.util.HibernateUtil;

import javax.persistence.criteria.CriteriaQuery;
import java.sql.SQLException;
import java.util.List;

public class OwnerDaoImpl implements OwnerDao {

    public void addOwner(Owner owner) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(owner);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public Owner getOwner(long id) throws SQLException {
        Owner result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.get(Owner.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return result;
    }

    public void updateOwner(Owner newOwner) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Owner oldOwner = session.get(Owner.class, newOwner.getId());
            oldOwner.setFirstName(newOwner.getFirstName());
            oldOwner.setLastName(newOwner.getLastName());
            oldOwner.setMiddleName(newOwner.getMiddleName());
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public void deleteOwner(Owner owner) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(owner);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public List<Owner> getAllOwner() throws SQLException {
        List<Owner> owners = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Owner> cq = session.getCriteriaBuilder().createQuery(Owner.class);
            cq.from(Owner.class);
            owners = session.createQuery(cq).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return owners;
    }

}
