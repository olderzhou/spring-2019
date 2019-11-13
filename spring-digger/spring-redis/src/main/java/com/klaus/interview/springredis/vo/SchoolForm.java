package com.klaus.interview.springredis.vo;

import com.klaus.interview.basemodel.base.form.BaseForm;
import com.klaus.interview.basemodel.model.school.po.School;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@ApiModel(value = "school model for post", description = "create school form")
public class SchoolForm extends BaseForm<School> {


    @ApiModelProperty(value = "name", example = "黑龙江大学")
    private String name;
    @ApiModelProperty(value = "schoolCode", example = "100001")
    private String schoolCode;




}
