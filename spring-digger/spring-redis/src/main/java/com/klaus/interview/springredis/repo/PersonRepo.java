package com.klaus.interview.springredis.repo;

import com.klaus.interview.basemodel.model.school.po.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    Person findPersonByName(String name);
    Person findPersonByMobile(String mobile);
    Person findPersonByOpenID(String openID);

}
