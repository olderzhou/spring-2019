package com.klaus.interview.demoeurekaconsumer.service;


import com.klaus.interview.demoapi.model.po.TestBean;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@FeignClient(name = "demo-eureka-provider", fallback = DemoFeign.DemoFeignImpl.class/*, configuration = DemoFeign.FeignMultipartSupportConfig.class*/)
public interface DemoFeign {


//    @Configuration
    public class FeignMultipartSupportConfig {

        @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;

        @Bean
        public Encoder feignFormEncoder () {
            return new SpringFormEncoder(new SpringEncoder(messageConverters));
        }

        @Bean
        @Primary
        public Encoder feignEncoder () {
            return new SpringEncoder(messageConverters);
        }

        @Bean
        public Decoder springDecoder() {
            return new ResponseEntityDecoder(new SpringDecoder(messageConverters));
        }

//        @Bean
//        public feign.Logger.Level multipartLoggerLevel() {
//            return feign.Logger.Level.FULL;
//        }
    }


    @GetMapping(value = "/test", produces = APPLICATION_JSON_UTF8_VALUE, consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<TestBean> test(@RequestParam("name") String name) ;

    @GetMapping(value = "/hello", produces = APPLICATION_JSON_UTF8_VALUE)
    public String hello(@RequestParam("name") String name) ;

    @GetMapping(value = "/testbean", produces = APPLICATION_JSON_UTF8_VALUE)
    TestBean testbean(@RequestParam("name") String name);

    @Slf4j
    public class DemoFeignImpl implements DemoFeign {
        @Override
        public ResponseEntity<TestBean> test(String name) {
            log.error("---------------feign server failed, return default value");
            return ResponseEntity.badRequest().body(new TestBean(name, 100));
        }

        @Override
        public String hello(String name) {
            log.error("------------feign server failed, return default value");
            return "HELLO, FEIGN ERROR";
        }

        @Override
        public TestBean testbean(String name) {
            log.error("----------------testbean failed, return default value");
            return new TestBean("哈哈哈", 10);
        }
    }
}


