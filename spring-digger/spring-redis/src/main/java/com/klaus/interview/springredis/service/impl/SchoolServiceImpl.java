package com.klaus.interview.springredis.service.impl;

import com.klaus.interview.basemodel.model.school.po.School;
import com.klaus.interview.basemodel.model.school.po.Student;
import com.klaus.interview.springredis.repo.SchoolRepo;
import com.klaus.interview.springredis.service.JpaBaseService;
import com.klaus.interview.springredis.service.SchoolService;
import com.klaus.interview.springredis.vo.param.SchoolParamForm;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.print.attribute.HashAttributeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.klaus.interview.basemodel.model.school.po.QSchool.school;

@Service
@CacheConfig(cacheNames = "school-test")
public class SchoolServiceImpl extends JpaBaseService implements SchoolService {

    @Autowired
    private SchoolRepo schoolRepo;

    @Override
    public List<School> findAll() {
        return schoolRepo.findAll();
    }

    @Override
    public List<School> findAll(SchoolParamForm schoolParamForm, Pageable pageable) {
//         predicate = school.
        List<Predicate> predicates = new ArrayList<>();
        if (schoolParamForm!=null) {
            if (!StringUtils.isEmpty(schoolParamForm.getName())) {
                predicates.add(school.name.like("%"+schoolParamForm.getName()+"%"));
            }
            if (!StringUtils.isEmpty(schoolParamForm.getSchoolCode())) {
                predicates.add(school.name.eq(schoolParamForm.getSchoolCode()));
            }

        }
        jpaQueryFactory.select(school).
                where(predicates.toArray(new Predicate[predicates.size()]))
                .fetchAll();
        return null;
    }

    @Override
    public School findByName(String name) {
        //单表动态查询
        Predicate predicate = school.name.eq(name);
        schoolRepo.findOne(predicate);
        return schoolRepo.findByName(name);
    }

    @Override
    public Page<School> findByNameAndCode(String name, String code) {
        Predicate predicate = school.name.eq(name).and(school.schoolCode.eq(code));
        Pageable pageable = PageRequest.of(0,10, Sort.by(Direction.ASC, "id"));
        return (Page<School>) schoolRepo.findAll(predicate,pageable);
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
