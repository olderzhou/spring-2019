package com.klaus.interview.springredis;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = SpringRedisApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AllArgsConstructor
public class SpringRedisApplicationTests {

    @Test
    public void contextLoads() {
    }

}
