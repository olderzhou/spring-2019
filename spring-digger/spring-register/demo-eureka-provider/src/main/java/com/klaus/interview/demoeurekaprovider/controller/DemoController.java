package com.klaus.interview.demoeurekaprovider.controller;

import com.klaus.interview.demoapi.model.po.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @Autowired
    private ServerProperties serverProperties;

    @GetMapping("/test")
    public ResponseEntity<TestBean> test(@RequestParam("name") String  name) {
        log.info("fetch port is :{}", serverProperties.getPort());

        TestBean testBean = new TestBean();
        testBean.setAge(serverProperties.getPort());
        testBean.setName(name);
        return ResponseEntity.ok().body(testBean);
    }


    @GetMapping("/hello")
    public String hello(@RequestParam("name") String  name) {
        log.info("fetch port is :{}", serverProperties.getPort());
        return "hello, "+name+" from "+ serverProperties.getPort();
    }



    @GetMapping("/testbean")
    public TestBean testBean(@RequestParam("name") String  name) {
        TestBean testBean =  new TestBean();
        testBean.setName(name);
        log.info("fetch port is :{}, name is :{}", serverProperties.getPort(), name);
        return testBean;

    }
}
