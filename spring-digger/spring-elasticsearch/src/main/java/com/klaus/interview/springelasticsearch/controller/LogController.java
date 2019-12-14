package com.klaus.interview.springelasticsearch.controller;


import com.klaus.interview.springelasticsearch.dto.vo.LogVo;
import com.klaus.interview.springelasticsearch.model.VisitLogPo;
import com.klaus.interview.springelasticsearch.repository.LogEsRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/log")
@AllArgsConstructor
@Api(tags = {"Log-Module"})
@Slf4j
public class LogController {

    private LogEsRepo logEsRepo;




    @GetMapping
    @ApiOperation(value = "save log", notes = "save logs to es")
    public ResponseEntity explore() {
        return ResponseEntity.ok(logEsRepo.findAll(PageRequest.of(0, 10)));
    }




    @PostMapping
    @ApiOperation(value = "save log", notes = "save logs to es")
    public ResponseEntity write(@RequestBody LogVo logVo) {
        VisitLogPo visitLogPo = new VisitLogPo();
        BeanUtils.copyProperties(logVo, visitLogPo);
        VisitLogPo visitLogPoNew = logEsRepo.save(visitLogPo);
        return ResponseEntity.ok(visitLogPoNew.getId());
    }


}
