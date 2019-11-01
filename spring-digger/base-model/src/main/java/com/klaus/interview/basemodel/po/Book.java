package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 图书
 */
@Entity
@Data
@ToString
public class Book extends JpaBasePo {

    private String name;
    private String author;
    private String remark;
    private String tags;
}
