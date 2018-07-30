package ru.petshop.petshopinterview.ablokhin.dao;

import ru.petshop.petshopinterview.ablokhin.persistence.OwnerAnimal;

import java.sql.SQLException;
import java.util.List;

public interface OwnerAnimalDao {
    void addOwnerAnimal(OwnerAnimal ownerAnimal) throws SQLException;
    OwnerAnimal getOwnerAnimal(long id) throws SQLException;
    void updateOwnerAnimal(OwnerAnimal ownerAnimal) throws SQLException;
    void deleteOwnerAnimal(OwnerAnimal ownerAnimal) throws SQLException;
    List<OwnerAnimal> getAllOwnerAnimal() throws SQLException;
}
