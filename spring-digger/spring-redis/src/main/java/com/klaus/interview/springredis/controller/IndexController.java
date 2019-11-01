package com.klaus.interview.springredis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/index")
@Api
public class IndexController {



    @GetMapping
    @ApiOperation(value = "index", notes = "index options", httpMethod = "GET")
    public ResponseEntity index() {
        HashMap<String, String> indexMap = new HashMap<>();
        indexMap.put("links","http://baidu.com");
        return ResponseEntity.ok().body(indexMap);
    }



}
