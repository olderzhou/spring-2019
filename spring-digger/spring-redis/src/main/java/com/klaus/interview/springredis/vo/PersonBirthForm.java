package com.klaus.interview.springredis.vo;

import com.klaus.interview.basemodel.school.po.Person;
import com.klaus.interview.commonbase.po.form.BaseForm;
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
