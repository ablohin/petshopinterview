package ru.petshop.petshopinterview.ablokhin.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.petshop.petshopinterview.ablokhin.persistence.Animal;
import ru.petshop.petshopinterview.ablokhin.persistence.Owner;
import ru.petshop.petshopinterview.ablokhin.persistence.OwnerAnimal;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {

            Properties configProperty = new Properties();
            configProperty.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            configProperty.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//            Development
            configProperty.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/WorldPet?currentSchema=public");
//            Production
//            configProperty.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/production?currentSchema=public");
            configProperty.setProperty("hibernate.connection.username", "postgre");
            configProperty.setProperty("hibernate.connection.password", "root");
            configProperty.setProperty("hibernate.connection.pool_size", "5");
            configProperty.setProperty("hibernate.hbm2ddl.auto", "create-drop");
            configProperty.setProperty("hibernate.show_sql", "true");
            configProperty.setProperty("hibernate.format_sql", "true");
            configProperty.setProperty("hibernate.hbm2ddl.import_files", "initial_data.sql");


            sessionFactory = new Configuration()
                    .addPackage("ru.petshop.petshopinterview.ablokhin.persistence")
                    .addAnnotatedClass(Animal.class)
                    .addAnnotatedClass(Owner.class)
                    .addAnnotatedClass(OwnerAnimal.class)
                    .addProperties(configProperty)
                    .addAnnotatedClass(Animal.class).buildSessionFactory();

        } catch (Throwable throwable) {
            System.err.println("Initial SessionFactory creation failed." + throwable);
            throw new ExceptionInInitializerError(throwable);
        }
    }

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
