package com.klaus.interview.basemodel.util;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;

import java.util.function.LongSupplier;

public final class PageExecution {

    private PageExecution() {}

    public static Page getPage(JPAQuery jpaQuery, Pageable pageable){
        return PageableExecutionUtils.getPage( jpaQuery.fetch(), pageable, new LongSupplier() {
            public long getAsLong() {
                return jpaQuery.fetchCount();
            }
        });
    }
}
