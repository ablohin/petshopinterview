package ru.petshop.petshopinterview.ablokhin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.petshop.petshopinterview.ablokhin.dao.AnimalDao;
import ru.petshop.petshopinterview.ablokhin.persistence.Animal;
import ru.petshop.petshopinterview.ablokhin.util.Factory;

import java.util.List;

@RestController
@RequestMapping(value = "/api/animals")
public class CrudAnimalResource {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView root() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/views/index.jsp");
        return mv;
    }

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody Animal animal) {
        System.out.println("Creating the animal object");
        Factory factory = Factory.getInstanse();
        try {
            AnimalDao animalDao = factory.getAnimalDao();
            animalDao.addAnimal(animal);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/{animalId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Animal> read(@PathVariable Long animalId) {
        System.out.println("Getting the animal object by id = : " + animalId);
        if (animalId == null) return ResponseEntity.badRequest().build();
        Factory factory = Factory.getInstanse();
        Animal animal = null;
        try {
            AnimalDao animalDao = factory.getAnimalDao();
            animal = animalDao.getAnimal(animalId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (animal == null) {
            return ResponseEntity.badRequest().header("Failure", "Animal with animalId: " + animalId + " not found").build(); }
        return new ResponseEntity<Animal>(animal, HttpStatus.OK);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Animal animal) {
        System.out.println("Updating the animal object");
        Factory factory = Factory.getInstanse();
        Long animalId = animal.getId();
        try {
            if (animalId == null) {
                return create(animal);
            }
            AnimalDao animalDao = factory.getAnimalDao();
            animalDao.updateAnimal(animal);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/{animalId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Long animalId) {
        if (animalId == null) return ResponseEntity.badRequest().build();
        Factory factory = Factory.getInstanse();
        try {
            AnimalDao animalDao = factory.getAnimalDao();
            animalDao.deleteAnimal(new Animal(animalId));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Animal>> getAll() {
        Factory factory = Factory.getInstanse();
        AnimalDao animalDao = factory.getAnimalDao();
        List<Animal> animals = null;
        try {
            animals = animalDao.getAllAnimal();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Animal>>(animals, HttpStatus.OK);
    }

}
