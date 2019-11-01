package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;


@Entity
@Data
@ToString
public class Room extends JpaBasePo {

    private String name;
    private String code;

}
