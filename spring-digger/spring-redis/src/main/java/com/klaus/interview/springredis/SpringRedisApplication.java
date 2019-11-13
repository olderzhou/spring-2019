package com.klaus.interview.springredis;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.klaus.interview.springredis", "com.klaus.interview.basemodel.config"})
@EnableJpaAuditing
@EntityScan(basePackages = {"com.klaus.interview.basemodel.model.school.po"})
@EnableSwagger2Doc
public class SpringRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplication.class, args);
    }

}
