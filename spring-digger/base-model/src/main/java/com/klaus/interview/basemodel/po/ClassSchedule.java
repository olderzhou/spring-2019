package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonbase.config.CurrentAuditor;
import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;


/**
 * 课程表
 */
@Entity
@Data
@ToString
@EntityListeners(value = CurrentAuditor.class)
public class ClassSchedule extends JpaBasePo {

    private String roleCode;
    @Column(name = "open_id",length = 128, unique = true, nullable = false)
    private String openID;
}
