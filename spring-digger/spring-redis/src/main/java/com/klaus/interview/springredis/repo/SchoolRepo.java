package com.klaus.interview.springredis.repo;

import com.klaus.interview.basemodel.model.school.po.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SchoolRepo extends JpaRepository<School, Long>, QuerydslPredicateExecutor<School> {
    public School findByName(String name);
    public School findSchoolBySchoolCode(String schoolCode);











}
