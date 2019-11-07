package com.klaus.interview.basemodel.school.po;

import com.klaus.interview.commonbase.config.CurrentAuditor;
import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;


@Entity
@Data
@ToString
@EntityListeners(value = CurrentAuditor.class)
public class School extends JpaBasePo {

    private String name;
    private String schoolCode;

}
