package com.klaus.interview.springelasticsearch.controller;

import com.klaus.interview.springelasticsearch.anotation.ApiVersion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/{version}/version")
@RestController
@ApiVersion(2)
@Slf4j
public class VersionTest2Controller {


    @GetMapping
    public ResponseEntity v2() {
        log.info("v2 invoked");
        return ResponseEntity.ok("v2");
    }
}
