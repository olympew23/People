package com.theironyard.novauc.controllers;


import com.theironyard.novauc.entities.PeopleFile;
import com.theironyard.novauc.entities.Person;
import com.theironyard.novauc.services.PeopleFileRepository;
import com.theironyard.novauc.services.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by jerieshasmith on 3/18/17.
 */
@RestController
public class PeopleController {

    @Autowired
    PersonRepository persons;

    @Autowired
    PeopleFileRepository lists;


    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public void upload(MultipartFile file, HttpServletResponse response) throws IOException {
        File dir = new File("public/files");
        dir.mkdirs();
        File f = File.createTempFile("file", file.getOriginalFilename(), dir);
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(file.getBytes());

        PeopleFile peopleFile = new PeopleFile(f.getName(), file.getOriginalFilename());
        lists.save(peopleFile);

        response.sendRedirect("/");
    }

    @RequestMapping(path = "/lists", method = RequestMethod.GET)
    public List<PeopleFile> getFiles() {
        return (List<PeopleFile>)lists.findAll();
    }


    @RequestMapping(path = "/person", method = RequestMethod.GET)
    public List<Person> getPersons() {
        return (List<Person>) persons.findAll();
    }
    @RequestMapping(path = "/person", method = RequestMethod.POST)
    public void addPerson(@RequestBody Person person) {
        persons.save(person);
    }

    @RequestMapping(path = "/person", method = RequestMethod.PUT)
    public void updatePerson(@RequestBody Person person) {
        persons.save(person);
    }
    @RequestMapping(path = "/person/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") int id) {
        persons.delete(id);
    }

    @RequestMapping(path = "/person/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") int id) {
        return persons.findOne(id);
    }

    @PostConstruct
    public void init() {
        if (persons.count() == 0) {
            Person person = new Person();
            person.setName("Terrell");
           person.setAddress("555 MaryLane");
           person.setPhone("773-234-5081");
           person.setBirthDay("12/25/1985");
           person.setEmail("terrell@pickle.com");
            persons.save(person);
        }
    }

}
