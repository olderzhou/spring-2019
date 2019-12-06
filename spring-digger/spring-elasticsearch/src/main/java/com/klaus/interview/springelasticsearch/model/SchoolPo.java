package com.klaus.interview.springelasticsearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "spring-elastic-test", type = "school", createIndex = false)
@ToString
public class SchoolPo {
    @Id
    private Long id;
    @Field(analyzer="ik_max_word", type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Keyword)
    private String code;

    @Field(type = FieldType.Date, format = DateFormat.basic_date)
    @JsonFormat(pattern = "yyyyMMdd")
    private Date foundDate = new Date();

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    @JsonFormat(pattern = "yyyyMMdd'T'HHmmss.SSSZ")
    private Date birth_day;

    @Field(type = FieldType.Keyword)
    private String founder;
    @Field(type = FieldType.Keyword)
    private String chairman;
}
