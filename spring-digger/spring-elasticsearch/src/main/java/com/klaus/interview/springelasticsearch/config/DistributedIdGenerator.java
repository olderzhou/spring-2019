package com.klaus.interview.springelasticsearch.config;


import com.klaus.interview.commonbase.util.SnowFlake;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Data
public class DistributedIdGenerator {

    @Value("${distributed.work.id:0}")
    private long workerId;
    @Value("${distributed.data.center.id:0}")
    private long dataCenterId;
    private SnowFlake snowFlake;
    @PostConstruct
    private void init() {
        this.snowFlake =  new SnowFlake(dataCenterId, workerId);
    }



}
