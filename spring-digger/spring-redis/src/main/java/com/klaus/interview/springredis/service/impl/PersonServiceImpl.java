package com.klaus.interview.springredis.service.impl;

import com.klaus.interview.basemodel.model.school.po.Person;
import com.klaus.interview.springredis.repo.PersonRepo;
import com.klaus.interview.springredis.service.JpaBaseService;
import com.klaus.interview.springredis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.klaus.interview.basemodel.model.school.po.QPerson.person;

@Service
public class PersonServiceImpl extends JpaBaseService implements PersonService {


    @Autowired
    private PersonRepo personRepo;

    @Override
    public Person birth(Person person) {
        person.setOpenID(UUID.randomUUID().toString().replace("-","").toLowerCase());
        return personRepo.save(person);
    }

    @Override
    public void die() {
        jpaQueryFactory.select(person).from(person).where(person.name.eq("klaus")).fetch();
    }

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }

    @Override
    public Person findByName(String name) {
        return personRepo.findPersonByName(name);
    }

    @Override
    public Person findByMobile(String mobile) {
        return personRepo.findPersonByMobile(mobile);
    }

    @Override
//    @Cacheable(cacheNames="content",key="#user.userId",condition="#user.age<40")
    public Person findByOpenID(String openID) {
        return personRepo.findPersonByOpenID(openID);
    }

}
