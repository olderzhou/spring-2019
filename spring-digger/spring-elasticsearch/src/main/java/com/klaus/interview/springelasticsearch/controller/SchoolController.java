package com.klaus.interview.springelasticsearch.controller;

import com.klaus.interview.springelasticsearch.model.SchoolPo;
import com.klaus.interview.springelasticsearch.repository.SchoolEsRepo;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/school")
@AllArgsConstructor
public class SchoolController {
    private SchoolEsRepo schoolEsRepo;
    @PostMapping("/school")
    @ApiOperation(value = "save data school", notes = "save data to es")
    public ResponseEntity save(@RequestBody SchoolPo schoolPo) {
        SchoolPo schoolPoNew = schoolEsRepo.save(schoolPo);
        return ResponseEntity.ok(schoolPoNew.getId());
    }

    @GetMapping("/school/{id}")
    @ApiOperation(value = "get data school", notes = "get data from es by id")
    public ResponseEntity findById(@PathVariable("id")  Long  id) {
        Optional<SchoolPo> optionalSchoolPo = schoolEsRepo.findById(id);
        if (optionalSchoolPo.isPresent()) {
            return ResponseEntity.ok(optionalSchoolPo.get());
        }
        return ResponseEntity.ok(null);
    }
}
