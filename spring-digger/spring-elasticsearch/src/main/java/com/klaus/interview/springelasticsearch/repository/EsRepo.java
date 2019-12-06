package com.klaus.interview.springelasticsearch.repository;

import com.klaus.interview.springelasticsearch.model.SchoolPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsRepo extends ElasticsearchRepository<SchoolPo, Long> {



}
