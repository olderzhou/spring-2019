package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * 建筑物
 */
@Entity
@Data
@ToString
public class Building extends JpaBasePo {

    private String name;
    private String code;

}
