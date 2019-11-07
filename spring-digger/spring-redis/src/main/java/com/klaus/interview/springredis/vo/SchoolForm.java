package com.klaus.interview.springredis.vo;

import com.klaus.interview.basemodel.school.po.School;
import com.klaus.interview.commonbase.po.form.BaseForm;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class SchoolForm extends BaseForm<School> {


    private String name;
    private String schoolCode;




}
