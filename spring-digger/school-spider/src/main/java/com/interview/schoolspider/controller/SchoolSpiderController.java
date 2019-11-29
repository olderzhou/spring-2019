package com.interview.schoolspider.controller;

import com.interview.schoolspider.spider.processor.SchoolSpider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
@Api(tags = {"School Module"})
public class SchoolSpiderController {
    @GetMapping
    @ApiOperation(value = "test status", notes = "this is use to test service status")
    public ResponseEntity success() {
        //SchoolSpider.builder().url("http://baidu.com").build().run();
        return ResponseEntity.ok("success");
    }

    @Autowired
    private KafkaTemplate kafkaTemplate;



    @GetMapping("/test")
    @ApiOperation(value = "test kafka status", notes = "this is use to test service status")
    public ResponseEntity testKafka() {
        kafkaTemplate.send("school-topic", "test first message");
        return ResponseEntity.ok(true);
    }





}
