package com.klaus.interview.basemodel.model.school.po;

import com.klaus.interview.basemodel.config.CurrentAuditor;
import com.klaus.interview.basemodel.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;


/**
 * 学院
 */
@Entity
@Data
@ToString
@EntityListeners(value = CurrentAuditor.class)
public class College extends JpaBasePo {
    private String name;
    private String code;

}
