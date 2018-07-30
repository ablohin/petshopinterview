package ru.petshop.petshopinterview.ablokhin.dao.daoimplementations;

import org.hibernate.Session;
import ru.petshop.petshopinterview.ablokhin.dao.AnimalDao;
import ru.petshop.petshopinterview.ablokhin.persistence.Animal;
import ru.petshop.petshopinterview.ablokhin.util.HibernateUtil;

import javax.persistence.criteria.CriteriaQuery;
import java.sql.SQLException;
import java.util.List;

public class AnimalDaoImpl implements AnimalDao {

    public void addAnimal(Animal animal) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(animal);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public void updateAnimal(Animal newAnimal) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Animal oldAnimal = session.get(Animal.class, newAnimal.getId());
            oldAnimal.setName(newAnimal.getName());
            oldAnimal.setType(newAnimal.getType());
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public void deleteAnimal(Animal animal) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(animal);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public Animal getAnimal(long id) throws SQLException {
        Animal result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Animal) session.get(Animal.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return result;
    }

    public List<Animal> getAllAnimal() throws SQLException {
        List<Animal> animals = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Animal> cq = session.getCriteriaBuilder().createQuery (Animal.class);
            cq.from(Animal.class);
            animals = session.createQuery(cq).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return animals;
    }

}
