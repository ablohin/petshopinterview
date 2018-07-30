package ru.petshop.petshopinterview.ablokhin.util;

import ru.petshop.petshopinterview.ablokhin.dao.AnimalDao;
import ru.petshop.petshopinterview.ablokhin.dao.OwnerAnimalDao;
import ru.petshop.petshopinterview.ablokhin.dao.OwnerDao;
import ru.petshop.petshopinterview.ablokhin.dao.daoimplementations.AnimalDaoImpl;
import ru.petshop.petshopinterview.ablokhin.dao.daoimplementations.OwnerAnimalDaoImpl;
import ru.petshop.petshopinterview.ablokhin.dao.daoimplementations.OwnerDaoImpl;

public class Factory {
    public static Factory instanse = new Factory();
    public AnimalDao animalDaoImpl;
    public OwnerDao ownerDaoImpl;
    public OwnerAnimalDao ownerAnimalDaoImpl;

    private Factory() {
    }

    public static Factory getInstanse() {
        return instanse;
    }

    public AnimalDao getAnimalDao() {
        if (animalDaoImpl == null) {
            animalDaoImpl = new AnimalDaoImpl();
        }
        return animalDaoImpl;
    }

    public OwnerDao getOwnerDao() {
        if (ownerDaoImpl == null) {
            ownerDaoImpl = new OwnerDaoImpl();
        }
        return ownerDaoImpl;
    }

    public OwnerAnimalDao getOwnerAnimalDao() {
        if (ownerAnimalDaoImpl == null) {
            ownerAnimalDaoImpl = new OwnerAnimalDaoImpl();
        }
        return ownerAnimalDaoImpl;
    }
}
