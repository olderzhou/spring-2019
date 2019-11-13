package com.klaus.interview.springredis.service;

import com.klaus.interview.basemodel.model.school.po.School;
import com.klaus.interview.basemodel.model.school.po.Student;
import com.klaus.interview.springredis.vo.param.SchoolParamForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolService {

    public List<School> findAll();
    public List<School> findAll(SchoolParamForm schoolParamForm, Pageable pageable);
    public School findByName(String name);
    public Page<School> findByNameAndCode(String name, String code);
    public School initSchool(School school);
    public School update(School school);
    public void delete(School school);
    public Boolean recruitingStudents(List<Student> students);
    public Boolean recruitingTeachers(List<Student> students);
    public Boolean recruitingStudent(Student student);
    public Boolean recruitingTeacher(Student student);








}
