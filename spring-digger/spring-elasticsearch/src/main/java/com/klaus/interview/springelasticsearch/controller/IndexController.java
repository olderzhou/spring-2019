package com.klaus.interview.springelasticsearch.controller;

import com.klaus.interview.springelasticsearch.model.SchoolPo;
import com.klaus.interview.springelasticsearch.repository.SchoolEsRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsRequest;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/index")
@AllArgsConstructor
@Api(tags = {"elastic-search-best-test"})
@Slf4j
public class IndexController {

    private ElasticsearchOperations elasticsearchOperations;
    private ElasticsearchTemplate elasticsearchTemplate;
    private SchoolEsRepo schoolEsRepo;
    private RestHighLevelClient highLevelClient;
    private static final String INDEX_PREFIX = "com.klaus.interview.springelasticsearch.model";

    @GetMapping
    @ApiOperation(value = "list index", notes = "show all indices")
    private ResponseEntity listIndex() throws IOException {
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest();
        getSettingsRequest.indices("spring-elastic-test");
        GetSettingsResponse getSettingsResponse = highLevelClient.indices().getSettings(getSettingsRequest, RequestOptions.DEFAULT);
        return ResponseEntity.ok(getSettingsResponse.getIndexToSettings());
    }

    @DeleteMapping
    @ApiOperation(value = "delete index", notes = "delete indices")
    private ResponseEntity deleteIndex(String index) {
        elasticsearchTemplate.deleteIndex(SchoolPo.class);
        return ResponseEntity.ok(true);
    }


    @PostMapping
    @ApiOperation(value = "create index", notes = "create indices")
    private ResponseEntity createIndex(@RequestParam(name = "index") String index) {
        try {
            log.info("className is :{}", INDEX_PREFIX+"."+index);
            Class className = Class.forName(INDEX_PREFIX+"."+index);
            log.info("className === :{}", className);
            elasticsearchTemplate.createIndex(className);
            elasticsearchTemplate.putMapping(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(elasticsearchTemplate.getSetting(SchoolPo.class));
    }

}