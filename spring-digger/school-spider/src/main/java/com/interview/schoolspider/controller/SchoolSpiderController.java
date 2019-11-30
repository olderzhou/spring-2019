package com.interview.schoolspider.controller;

import com.interview.schoolspider.spider.model.SchoolVo;
import com.interview.schoolspider.spider.processor.SchoolSpider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
@Api(tags = {"School Module"})
@Slf4j
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
    public ResponseEntity testKafka(@RequestParam(name = "message") String message) {
        log.info("kafkaTemplate.metrics() is :{}", kafkaTemplate.metrics());
        //kafkaTemplate.send("school-topic", message);

        SchoolVo schoolVo = new SchoolVo();
        schoolVo.setChuzhongzaixiaorenshu("111");
        schoolVo.setDianhua("22");
        schoolVo.setDiqu("33");
        schoolVo.setTitle(message);
//        kafkaTemplate.send("school-topic-1", schoolVo);
        kafkaTemplate.send("school-topic-2", schoolVo);
//        kafkaTemplate.send("school-topic", schoolVo);
        return ResponseEntity.ok(true);
    }





}
