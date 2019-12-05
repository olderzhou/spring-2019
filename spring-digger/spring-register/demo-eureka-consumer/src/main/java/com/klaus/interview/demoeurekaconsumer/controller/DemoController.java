package com.klaus.interview.demoeurekaconsumer.controller;


import com.klaus.interview.demoeurekaconsumer.service.DemoFeign;
import feign.Headers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
@Slf4j
public class DemoController {

    @Autowired
    //@LoadBalanced
    private RestTemplate restTemplate;


    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam("name") String  name) {
        ResponseEntity<String> data = restTemplate.getForEntity("http://demo-eureka-provider/test?name="+name, String.class);
        log.info("data is :{}", data.getBody());
        log.info("name is :{}", name);
        return data;
    }



    @Autowired
    private DemoFeign demoFeign;

    @GetMapping("/testFeign")
    @Headers("Content-Type: application/json")
    public ResponseEntity<String> testFeign(@RequestParam("name") String  name) {
        ResponseEntity<String>  data = demoFeign.test(name);
        log.info("name is:{}, data is :{}", name, data.getBody());
        return data;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String  name) {
        String  data = demoFeign.hello(name);
        log.info("name is:{}, data is :{}", name, data.getBytes());
        return data;
    }




}
