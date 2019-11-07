package com.klaus.interview.springredis.service;

import com.klaus.interview.basemodel.school.po.School;
import com.klaus.interview.basemodel.school.po.Student;

import java.util.List;

public interface SchoolService {

    public List<School> findAll();
    public School findByName(String name);
    public School initSchool(School school);
    public School update(School school);
    public void delete(School school);
    public Boolean recruitingStudents(List<Student> students);
    public Boolean recruitingTeachers(List<Student> students);
    public Boolean recruitingStudent(Student student);
    public Boolean recruitingTeacher(Student student);








}
