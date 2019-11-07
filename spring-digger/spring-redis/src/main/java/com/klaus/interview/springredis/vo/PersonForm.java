package com.klaus.interview.springredis.vo;

import com.klaus.interview.basemodel.school.po.Person;
import com.klaus.interview.commonbase.po.form.BaseForm;
import lombok.Data;

@Data
public class PersonForm extends BaseForm<Person> {

    private String name;
    private Integer age = 0;
    private String mobile;
}
