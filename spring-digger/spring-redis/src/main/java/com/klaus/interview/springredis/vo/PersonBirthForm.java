package com.klaus.interview.springredis.vo;

import com.klaus.interview.basemodel.base.form.BaseForm;
import com.klaus.interview.basemodel.model.school.po.Person;
import lombok.Data;

import java.util.Date;

@Data
public class PersonBirthForm extends BaseForm<Person> {

    private String hospitalCode;
    private String doctorID;
    private String nurseID;
    private Date birthTime;
    private Date birthNo;





}
