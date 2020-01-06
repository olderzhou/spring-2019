package com.klaus.interview.springelasticsearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.annotation.Generated;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "spring-elastic.school-new", type = "school-new", createIndex = false)
@ToString
@ApiModel(value = "学校", description = "school entity description")
public class SchoolPo {
    @Id()
    @Field(type = FieldType.Long)
    @ApiModelProperty(name = "主键",example = "1")
    private Long id;

    @Field(analyzer="ik_max_word", type = FieldType.Text)
    @ApiModelProperty(name = "名称",example = "klaus")
    private String name;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty(name = "编码",example = "2019111022")
    private String code;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @JsonFormat(pattern = "yyyyMMdd")
    @ApiModelProperty(name = "建立日",example = "2019-12-10")
    private Date foundDate = new Date();

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "建立时间",example = "2019-12-10 11:51:30")
    private Date birth_day = new Date();

    @Field(type = FieldType.Keyword)
    @ApiModelProperty(name = "创建人",example = "klaus")
    private String founder;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty(name = "校长",example = "klaus")
    private String chairman;



}
