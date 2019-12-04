package com.klaus.interview.springredis.service;

import com.klaus.interview.basemodel.model.school.po.Person;


import java.util.List;

public interface PersonService {

    Person birth(Person person);
    void die();
    List<Person> findAll();
    Person findByName(String name);
    Person findByMobile(String mobile);
    Person findByOpenID(String openID);

}
