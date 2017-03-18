package com.theironyard.novauc.services;

import com.theironyard.novauc.entities.Person;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by jerieshasmith on 3/18/17.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
