package com.klaus.interview.basemodel.model.school.po;

import com.klaus.interview.basemodel.config.CurrentAuditor;
import com.klaus.interview.basemodel.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 图书
 */
@Entity
@Data
@ToString
@EntityListeners(value = CurrentAuditor.class)
public class Book extends JpaBasePo {

    private String name;
    private String author;
    private String remark;
    private String tags;
}
