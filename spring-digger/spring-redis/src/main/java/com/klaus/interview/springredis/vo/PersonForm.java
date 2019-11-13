package com.klaus.interview.springredis.vo;

import com.klaus.interview.basemodel.base.form.BaseForm;
import com.klaus.interview.basemodel.model.school.po.Person;
import lombok.Data;

@Data
public class PersonForm extends BaseForm<Person> {

    private String name;
    private Integer age = 0;
    private String mobile;
}
