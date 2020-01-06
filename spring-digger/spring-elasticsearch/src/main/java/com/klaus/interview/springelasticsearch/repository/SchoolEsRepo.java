package com.klaus.interview.springelasticsearch.repository;

import com.klaus.interview.springelasticsearch.model.SchoolPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SchoolEsRepo extends ElasticsearchRepository<SchoolPo, Long> {

    List<SchoolPo> existsByName(String name);


}
