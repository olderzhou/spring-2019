package com.klaus.interview.basemodel.school.po;

import com.klaus.interview.commonbase.config.CurrentAuditor;
import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
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
