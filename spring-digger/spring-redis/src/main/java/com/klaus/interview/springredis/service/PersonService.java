package com.klaus.interview.springredis.service;

import com.klaus.interview.basemodel.po.Person;

import java.util.List;

public interface PersonService {

    public Person birth(Person person);
    public void die();

    public List<Person> findAll();





}
