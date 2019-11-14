package com.klaus.interview.springredis.controller;


import com.klaus.interview.basemodel.model.school.po.School;
import com.klaus.interview.springredis.service.SchoolService;
import com.klaus.interview.springredis.vo.SchoolForm;
import com.klaus.interview.springredis.vo.param.SchoolParamForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
@Api(tags = "School Module")
@Slf4j
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


    @GetMapping("/name/{name}")
    @ApiOperation(value = "list", notes = "mark a person list ticket")
    public ResponseEntity findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(schoolService.findByName(name));
    }



    @GetMapping("/findByNameAndCode")
    @ApiOperation(value = "list", notes = "mark a person list ticket")
    public ResponseEntity findByNameAndCode(@RequestParam String name, @RequestParam String code) {
        return ResponseEntity.ok().body(schoolService.findByNameAndCode(name, code));
    }

    @PostMapping("/expore")
    @ApiOperation(value = "expore", notes = "expore school with muti params" )
    public ResponseEntity expore(@PageableDefault(page = 0, size = 20) @SortDefault.SortDefaults({
                                         @SortDefault(sort = "name", direction = Sort.Direction.DESC),
                                         @SortDefault(sort = "id", direction = Sort.Direction.ASC)
                                 }) Pageable pageable,
                                 @RequestBody SchoolParamForm schoolParamForm) {
        log.info("school is :{}, pageable is :{}", schoolParamForm, pageable);
        return ResponseEntity.ok(schoolService.findAll(schoolParamForm, pageable));
    }












}
