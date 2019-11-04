package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonbase.config.CurrentAuditor;
import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 个人
 */
@Entity
@Data
@ToString
@EntityListeners(value = CurrentAuditor.class)
public class Person extends JpaBasePo {

    private String name;
    private Integer age = 0;
    private String mobile;
    @Column(name = "open_id",length = 128, unique = true, nullable = false)
    private String openID;
}
