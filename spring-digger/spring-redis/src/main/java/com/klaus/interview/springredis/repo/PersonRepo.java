package com.klaus.interview.springredis.repo;

import com.klaus.interview.basemodel.po.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    public List<Person> findByName(String name);











}
