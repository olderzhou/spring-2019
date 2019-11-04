package com.klaus.interview.basemodel.po;

import com.klaus.interview.commonbase.config.CurrentAuditor;
import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 房间编号
 */
@Entity
@Data
@ToString
@EntityListeners(value = CurrentAuditor.class)
public class Room extends JpaBasePo {

    private String name;
    private String code;

}
