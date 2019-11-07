package com.klaus.interview.springredis.service.impl;

import com.klaus.interview.basemodel.school.po.School;
import com.klaus.interview.basemodel.school.po.Student;
import com.klaus.interview.springredis.repo.SchoolRepo;
import com.klaus.interview.springredis.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@AllArgsConstructor
@CacheConfig(cacheNames = "school-test")
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepo schoolRepo;

    @Override
    public List<School> findAll() {
        return schoolRepo.findAll();
    }

    @Override
    public School findByName(String name) {
        return schoolRepo.findByName(name);
    }

    @Override
    @CachePut(key = "#result.schoolCode",condition = "#result!=null")
    public School initSchool(School school) {
        return schoolRepo.save(school);
    }

    @Override
    @CachePut(key = "#result.schoolCode",condition = "#result!=null")
    public School update(School school) {
        return schoolRepo.save(school);
    }

    @Override
    @CacheEvict(key="school.schoolCode")
    //@CacheEvict(value="school",allEntries = true) //清楚所有缓
     //@CacheEvict(value="school",allEntries = true,beforeInvocation = true) //清楚所有缓存
    public void delete(School school) {
        schoolRepo.delete(school);
    }

    @Override
    public Boolean recruitingStudents(List<Student> students) {
        return null;
    }

    @Override
    public Boolean recruitingTeachers(List<Student> students) {
        return null;
    }

    @Override
    public Boolean recruitingStudent(Student student) {
        return null;
    }

    @Override
    public Boolean recruitingTeacher(Student student) {
        return null;
    }
}
