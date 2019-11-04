package com.klaus.interview.springredis.service.impl;

import com.klaus.interview.basemodel.po.Person;
import com.klaus.interview.springredis.repo.PersonRepo;
import com.klaus.interview.springredis.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
//@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public Person birth(Person person) {
        person.setOpenID(UUID.randomUUID().toString().replace("-","").toLowerCase());
        return personRepo.save(person);
    }

    @Override
    public void die() {

    }

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }
}
