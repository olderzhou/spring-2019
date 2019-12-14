package com.klaus.interview.springelasticsearch.dto.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "LogForm", description = "log form obj")
public class LogForm {

    @ApiModelProperty(name = "id", example = "1")
    private Long id;

    @ApiModelProperty(name = "timestamp", example = "13245532416")
    private Long timestamp;

    @ApiModelProperty(name = "cTime", example = "19901210")
    @JsonFormat(pattern = "yyyyMMdd")
    private Date cTime;

    @ApiModelProperty(name = "bizType", example = "LOG_SAVE_SCHOOL")
    private String bizType;

    @ApiModelProperty(name = "url", example = "1")
    private String url;

    @ApiModelProperty(name = "ip", example = "129.196.65.129")
    private String ip;

    @ApiModelProperty(name = "labels", example = "[\"hign\",\"middle\",\"low\"]")
    private List<String> labels;
}
