package com.klaus.interview.springredis.repo;

import com.klaus.interview.basemodel.school.po.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School, Long> {
    public School findByName(String name);
    public School findSchoolBySchoolCode(String schoolCode);











}
