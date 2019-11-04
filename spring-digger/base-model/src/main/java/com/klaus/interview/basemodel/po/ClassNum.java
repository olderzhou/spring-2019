package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonbase.config.CurrentAuditor;
import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
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
