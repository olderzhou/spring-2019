package com.klaus.interview.springredis.service;

import com.klaus.interview.basemodel.model.school.po.Person;

import java.util.List;

public interface PersonService {

    public Person birth(Person person);
    public void die();
    public List<Person> findAll();
    public Person findByName(String name);
    public Person findByMobile(String mobile);
    public Person findByOpenID(String openID);



}
