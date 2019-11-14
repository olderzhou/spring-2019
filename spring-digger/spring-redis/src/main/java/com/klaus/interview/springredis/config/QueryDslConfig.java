package com.klaus.interview.springredis.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class QueryDslConfig {

    @Autowired
    private EntityManager entityManager;
    @Bean
    public JPAQueryFactory jPAQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
