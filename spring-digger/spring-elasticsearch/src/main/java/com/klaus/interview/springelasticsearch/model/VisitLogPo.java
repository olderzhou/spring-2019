package com.klaus.interview.springelasticsearch.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(type = "visit-log", indexName = "spring-elastic-test", createIndex = true)
public class VisitLogPo {

    @Id
    @Field(type = FieldType.Long)
    private Long id;
    @Field(type = FieldType.Long)
    private Long timestamp;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @JsonFormat(pattern = "yyyyMMdd")
    private Date cTime;
    @Field(type = FieldType.Keyword)
    private String bizType;
    @Field(type = FieldType.Keyword)
    private String url;
    @Field(type = FieldType.Keyword)
    private String ip;
}
