package com.interview.schoolspider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
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
        return ResponseEntity.ok("success");
    }


}