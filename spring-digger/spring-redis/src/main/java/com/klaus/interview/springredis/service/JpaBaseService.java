package com.klaus.interview.springredis.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaBaseService {

    @Autowired
    protected JPAQueryFactory jpaQueryFactory;

}
