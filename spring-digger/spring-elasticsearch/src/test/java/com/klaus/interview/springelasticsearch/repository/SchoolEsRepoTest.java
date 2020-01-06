package com.klaus.interview.springelasticsearch.repository;

import com.klaus.interview.springelasticsearch.SpringElasticsearchApplication;
import com.klaus.interview.springelasticsearch.model.SchoolPo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest(classes = SpringElasticsearchApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class SchoolEsRepoTest {

    @Autowired
    private SchoolEsRepo schoolEsRepo;

    @Test
    public void testExists() {
        List<SchoolPo> flag = schoolEsRepo.existsByName("klaus");
        log.info("result is :{}", flag);
    }

}