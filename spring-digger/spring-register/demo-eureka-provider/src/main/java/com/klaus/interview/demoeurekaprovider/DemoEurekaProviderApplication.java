package com.klaus.interview.demoeurekaprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoEurekaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaProviderApplication.class, args);
    }


}
