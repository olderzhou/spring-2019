package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;


/**
 * 学院
 */
@Entity
@Data
@ToString
public class College extends JpaBasePo {

    private String name;
    private String code;

}
