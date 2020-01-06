package com.klaus.interview.basemodel.model.school.po;

import com.klaus.interview.basemodel.config.CurrentAuditor;
import com.klaus.interview.basemodel.base.JpaBasePo;
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

    // 房间名称
    private String name;
    // 房间编号
    private String code;
    // 建筑物编号
    private String buildingCode;
    // 容量
    private int capacity;
    // 面积
    private int areaSize;


}
