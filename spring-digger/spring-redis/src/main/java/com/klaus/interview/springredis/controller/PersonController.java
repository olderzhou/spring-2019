package com.klaus.interview.springredis.controller;


import com.klaus.interview.basemodel.po.Person;
import com.klaus.interview.springredis.service.PersonService;
import com.klaus.interview.springredis.vo.PersonBirthForm;
import com.klaus.interview.springredis.vo.PersonForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@Api(tags = "Person Module")
public class PersonController {


    @Autowired
    private PersonService personService;


    @PostMapping
    @ApiOperation(value = "create", notes = "mark a person birth ticket")
    public ResponseEntity create(@RequestBody PersonForm personForm) {
        Person person = personService.birth(personForm.toPo(Person.class));
        return ResponseEntity.ok().body(person);
    }

    @GetMapping
    @ApiOperation(value = "list", notes = "mark a person list ticket")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(personService.findAll());
    }












}
