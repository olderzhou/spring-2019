package com.klaus.interview.demoeurekaconsumer.service;


import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@FeignClient(name = "demo-eureka-provider", fallback = DemoFeign.DemoFeignImpl.class)
public interface DemoFeign {

//    @Configuration
    public class FeignMultipartSupportConfig {

        @Bean
        @Primary
        @Scope("prototype")
        public Encoder multipartFormEncoder() {
            return new SpringFormEncoder();
        }

        @Bean
        public Encoder jacksonEncoder() {
            return new JacksonEncoder();
        }

        @Bean
        public Decoder jacksonDecoder() {
            return new JacksonDecoder();
        }

        @Bean
        public feign.Logger.Level multipartLoggerLevel() {
            return feign.Logger.Level.FULL;
        }
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = APPLICATION_JSON_UTF8_VALUE, consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity test(@RequestParam("name") String name) ;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public String hello(@RequestParam("name") String name) ;


    @Slf4j
    public class DemoFeignImpl implements DemoFeign {
        @Override
        public ResponseEntity test(String name) {
            log.error("feign server failed, return default value");
            return ResponseEntity.badRequest().body("FEIGN ERROR");
        }

        @Override
        public String hello(String name) {
            log.error("feign server failed, return default value");
            return "HELLO, FEIGN ERROR";
        }
    }
}


