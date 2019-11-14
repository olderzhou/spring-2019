package com.klaus.interview.springredis.vo.vo;

import com.klaus.interview.basemodel.base.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "school model for vo", description = "school vo")
@AllArgsConstructor
@NoArgsConstructor
public class SchoolVo extends BaseVo {

    @ApiModelProperty(value = "name", example = "黑龙江大学")
    private String name;
    @ApiModelProperty(value = "schoolCode", example = "100001")
    private String schoolCode;




}