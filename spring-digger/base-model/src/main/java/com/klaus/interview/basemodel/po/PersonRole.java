package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Data
@ToString
public class PersonRole extends JpaBasePo {

    private String roleCode;
    @Column(name = "open_id",length = 128, unique = true, nullable = false)
    private String openID;
}
