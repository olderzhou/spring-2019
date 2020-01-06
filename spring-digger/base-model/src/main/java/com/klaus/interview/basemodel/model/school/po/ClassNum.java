package com.klaus.interview.basemodel.model.school.po;

import com.klaus.interview.basemodel.base.JpaBasePo;
import com.klaus.interview.basemodel.config.CurrentAuditor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 班级
 */
@Entity
@Data
@EntityListeners(value = CurrentAuditor.class)
public class ClassNum extends JpaBasePo {
    private String name;
    private String count;

}
