package com.klaus.interview.springelasticsearch.controller;

import com.klaus.interview.springelasticsearch.anotation.ApiVersion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/{version}/version")
@RestController
@ApiVersion(1)
@Slf4j
public class VersionTestController {
    @GetMapping
    public ResponseEntity v1() {
        log.info("v2 invoked");
        return ResponseEntity.ok("v1");
    }
}
