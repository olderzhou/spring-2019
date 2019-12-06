package com.klaus.interview.springelasticsearch.controller;

import com.klaus.interview.springelasticsearch.model.SchoolPo;
import com.klaus.interview.springelasticsearch.repository.EsRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsRequest;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@Api(tags = {"elastic-search-best-test"})
public class TestController {

    private ElasticsearchOperations elasticsearchOperations;
    private ElasticsearchTemplate elasticsearchTemplate;
    private EsRepo esRepo;
    private RestHighLevelClient highLevelClient;

    @GetMapping("/index")
    @ApiOperation(value = "list index", notes = "show all indices")
    private ResponseEntity listIndex() throws IOException {
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest();
        getSettingsRequest.indices("spring-elastic-test");
        GetSettingsResponse getSettingsResponse = highLevelClient.indices().getSettings(getSettingsRequest, RequestOptions.DEFAULT);
        return ResponseEntity.ok(getSettingsResponse.getIndexToSettings());
    }

    @DeleteMapping("/index")
    @ApiOperation(value = "delete index", notes = "delete indices")
    private ResponseEntity deleteIndex() {
        elasticsearchTemplate.deleteIndex(SchoolPo.class);
        return ResponseEntity.ok(true);
    }


    @PostMapping("/index")
    @ApiOperation(value = "create index", notes = "create indices")
    private ResponseEntity createIndex() {
        elasticsearchTemplate.createIndex(SchoolPo.class);
        elasticsearchTemplate.putMapping(SchoolPo.class);

        return ResponseEntity.ok(elasticsearchTemplate.getSetting(SchoolPo.class));
    }

    @PostMapping("/school")
    @ApiOperation(value = "save data school", notes = "save data to es")
    public String save(@RequestBody SchoolPo schoolPo) {

        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(schoolPo.getName())
                .withObject(schoolPo)
                .build();
        String documentId = elasticsearchOperations.index(indexQuery);
        return documentId;
    }

    @GetMapping("/school/{id}")
    @ApiOperation(value = "get data school", notes = "get data from es by id")
    public SchoolPo findById(@PathVariable("id")  Long  id) {
        GetQuery getQuery = new GetQuery();
        getQuery.setId(id.toString());
        SchoolPo schoolPo = elasticsearchOperations
                .queryForObject(getQuery, SchoolPo.class);
        return schoolPo;
    }
}