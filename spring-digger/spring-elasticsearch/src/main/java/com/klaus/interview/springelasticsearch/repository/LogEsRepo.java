package com.klaus.interview.springelasticsearch.repository;

import com.klaus.interview.springelasticsearch.model.VisitLogPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LogEsRepo extends ElasticsearchRepository<VisitLogPo, Long> {



}
