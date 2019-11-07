package com.klaus.interview.springredis.controller;


import com.klaus.interview.basemodel.school.po.School;
import com.klaus.interview.springredis.service.SchoolService;
import com.klaus.interview.springredis.vo.SchoolForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
@Api(tags = "School Module")
public class SchoolController {


    @Autowired
    private SchoolService schoolService;


    @PostMapping
    @ApiOperation(value = "init", notes = "mark a school birth ticket")
    public ResponseEntity init(@RequestBody SchoolForm schoolForm) {
        School school = schoolService.initSchool(schoolForm.toPo(School.class));
        return ResponseEntity.ok().body(school);
    }

    @GetMapping
    @ApiOperation(value = "list", notes = "mark a person list ticket")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(schoolService.findAll());
    }












}
