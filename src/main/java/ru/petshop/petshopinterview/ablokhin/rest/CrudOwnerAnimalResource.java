package ru.petshop.petshopinterview.ablokhin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.petshop.petshopinterview.ablokhin.dao.OwnerAnimalDao;
import ru.petshop.petshopinterview.ablokhin.dao.OwnerDao;
import ru.petshop.petshopinterview.ablokhin.persistence.Owner;
import ru.petshop.petshopinterview.ablokhin.persistence.OwnerAnimal;
import ru.petshop.petshopinterview.ablokhin.util.Factory;

import java.util.List;

@RestController
@RequestMapping(value = "/api/owneranimals")
public class CrudOwnerAnimalResource {

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody OwnerAnimal ownerAnimal) {
        System.out.println("Creating the ownerAnimal object");
        Factory factory = Factory.getInstanse();
        try {
            OwnerAnimalDao ownerAnimalDao = factory.getOwnerAnimalDao();
            ownerAnimalDao.addOwnerAnimal(ownerAnimal);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/{ownerAnimalId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OwnerAnimal> read(@PathVariable Long ownerAnimalId) {
        System.out.println("Getting the ownerAnimal object by id = : " + ownerAnimalId);
        if (ownerAnimalId == null) return ResponseEntity.badRequest().build();
        Factory factory = Factory.getInstanse();
        OwnerAnimal ownerAnimal = null;
        try {
            OwnerAnimalDao ownerAnimalDao = factory.getOwnerAnimalDao();
            ownerAnimal = ownerAnimalDao.getOwnerAnimal(ownerAnimalId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<OwnerAnimal>(ownerAnimal, HttpStatus.OK);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody OwnerAnimal ownerAnimal) {
        System.out.println("Updating the ownerAnimal object");
        Factory factory = Factory.getInstanse();
        Long ownerAnimalId = ownerAnimal.getId();
        try {
            if (ownerAnimalId == null) {
                return create(ownerAnimal);
            }
            OwnerAnimalDao ownerAnimalDao = factory.getOwnerAnimalDao();
            ownerAnimalDao.updateOwnerAnimal(ownerAnimal);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/{ownerAnimalId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long ownerAnimalId) {
        if (ownerAnimalId == null) return ResponseEntity.badRequest().build();
        Factory factory = Factory.getInstanse();
        try {
            OwnerAnimalDao ownerAnimalDao = factory.getOwnerAnimalDao();
            ownerAnimalDao.deleteOwnerAnimal(new OwnerAnimal(ownerAnimalId));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OwnerAnimal>> getAll() {
        Factory factory = Factory.getInstanse();
        OwnerAnimalDao ownerAnimalDao = factory.getOwnerAnimalDao();
        List<OwnerAnimal> ownerAnimals = null;
        try {
            float f = (float) (1.0 + 1.1f);
            ownerAnimals = ownerAnimalDao.getAllOwnerAnimal();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<List<OwnerAnimal>>(ownerAnimals, HttpStatus.OK);
    }

}
