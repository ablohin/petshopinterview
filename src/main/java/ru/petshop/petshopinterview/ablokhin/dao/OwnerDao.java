package ru.petshop.petshopinterview.ablokhin.dao;

import ru.petshop.petshopinterview.ablokhin.persistence.Owner;

import java.sql.SQLException;
import java.util.List;

public interface OwnerDao {
    void addOwner(Owner owner) throws SQLException;
    Owner getOwner(long id) throws SQLException;
    void updateOwner(Owner owner) throws SQLException;
    void deleteOwner(Owner owner) throws SQLException;
    List<Owner> getAllOwner() throws SQLException;
}
