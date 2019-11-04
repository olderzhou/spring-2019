package com.klaus.interview.springredis.vo;

import com.klaus.interview.basemodel.po.Person;
import com.klaus.interview.commonbase.po.form.BaseForm;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class PersonForm extends BaseForm<Person> {

    private String name;
    private Integer age = 0;
    private String mobile;
}
