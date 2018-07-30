package ru.petshop.petshopinterview.ablokhin.dao.daoimplementations;

import org.hibernate.Session;
import ru.petshop.petshopinterview.ablokhin.dao.OwnerAnimalDao;
import ru.petshop.petshopinterview.ablokhin.persistence.OwnerAnimal;
import ru.petshop.petshopinterview.ablokhin.util.HibernateUtil;

import javax.persistence.criteria.CriteriaQuery;
import java.sql.SQLException;
import java.util.List;

public class OwnerAnimalDaoImpl implements OwnerAnimalDao {

    public void addOwnerAnimal(OwnerAnimal ownerAnimal) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ownerAnimal);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public OwnerAnimal getOwnerAnimal(long id) throws SQLException {
        Session session = null;
        OwnerAnimal result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.get(OwnerAnimal.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return result;
    }

    public void updateOwnerAnimal(OwnerAnimal newOwnerAnimal) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            OwnerAnimal oldOwnerAnimal = session.get(OwnerAnimal.class, newOwnerAnimal.getId());
            oldOwnerAnimal.setAnimal(newOwnerAnimal.getAnimal());
            oldOwnerAnimal.setOwner(newOwnerAnimal.getOwner());
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public void deleteOwnerAnimal(OwnerAnimal ownerAnimal) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ownerAnimal);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public List<OwnerAnimal> getAllOwnerAnimal() throws SQLException {
        List<OwnerAnimal> ownerAnimals = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<OwnerAnimal> cq = session.getCriteriaBuilder().createQuery(OwnerAnimal.class);
            cq.from(OwnerAnimal.class);
            ownerAnimals = session.createQuery(cq).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return ownerAnimals;
    }

}
