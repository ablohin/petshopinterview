package ru.petshop.petshopinterview.ablokhin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.petshop.petshopinterview.ablokhin.dao.OwnerDao;
import ru.petshop.petshopinterview.ablokhin.persistence.Owner;
import ru.petshop.petshopinterview.ablokhin.util.Factory;

import java.util.List;

@RestController
@RequestMapping(value = "/api/owners")
public class CrudOwnerResource {

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody Owner owner) {
        System.out.println("Creating the owner object");
        Factory factory = Factory.getInstanse();
        try {
            OwnerDao ownerDao = factory.getOwnerDao();
            ownerDao.addOwner(owner);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/{ownerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Owner> read(@PathVariable Long ownerId) {
        System.out.println("Getting the animal object by id = : " + ownerId);
        if (ownerId == null) return ResponseEntity.badRequest().build();
        Factory factory = Factory.getInstanse();
        Owner owner = null;
        try {
            OwnerDao ownerDao = factory.getOwnerDao();
            owner = ownerDao.getOwner(ownerId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Owner>(owner, HttpStatus.OK);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Owner owner) {
        System.out.println("Updating the owner object");
        Factory factory = Factory.getInstanse();
        try {
            if (owner.getId() == null) {
                return create(owner);
            }
            OwnerDao ownerDao = factory.getOwnerDao();
            ownerDao.updateOwner(owner);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/{ownerId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long ownerId) {
        if (ownerId == null) return ResponseEntity.badRequest().build();
        Factory factory = Factory.getInstanse();
        try {
            OwnerDao ownerDao = factory.getOwnerDao();
            ownerDao.deleteOwner(new Owner(ownerId));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Owner>> getAll() {
        Factory factory = Factory.getInstanse();
        OwnerDao ownerDao = factory.getOwnerDao();
        List<Owner> owners = null;
        try {
            owners = ownerDao.getAllOwner();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Owner>>(owners, HttpStatus.OK);
    }

}
