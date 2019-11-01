package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Data
@ToString
public class Person extends JpaBasePo {

    private String name;
    private Integer age = -1;
    private String mobile;
    @Column(name = "open_id",length = 128, unique = true, nullable = false)
    private String openID;
}
