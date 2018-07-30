package ru.petshop.petshopinterview.ablokhin.dao;

import ru.petshop.petshopinterview.ablokhin.persistence.Animal;

import java.sql.SQLException;
import java.util.List;

public interface AnimalDao {
    void addAnimal(Animal animal) throws SQLException;
    Animal getAnimal(long id) throws SQLException;
    void updateAnimal(Animal animal) throws SQLException;
    void deleteAnimal(Animal animal) throws SQLException;
    List<Animal> getAllAnimal() throws SQLException;
}
