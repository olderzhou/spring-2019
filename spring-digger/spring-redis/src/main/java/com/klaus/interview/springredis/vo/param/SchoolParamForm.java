package com.klaus.interview.springredis.vo.param;

import com.klaus.interview.basemodel.base.param.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;


@ApiModel(value = "schoo model with page", description = "this is to handle school param query")
@Data
@ToString
public class SchoolParamForm extends BaseParam {
    @ApiModelProperty(name = "name", example = "黑龙江大学")
    private String name;
    @ApiModelProperty(name = "schoolCode", example = "100001")
    private String schoolCode;





}
