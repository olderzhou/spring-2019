package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 班级
 */
@Entity
@Data
@ToString
public class Class extends JpaBasePo {

    private String name;
    private String count;

}
