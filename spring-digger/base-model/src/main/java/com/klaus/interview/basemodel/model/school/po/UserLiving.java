package com.klaus.interview.basemodel.model.school.po;


import com.klaus.interview.basemodel.config.CurrentAuditor;
import com.klaus.interview.basemodel.base.JpaBasePo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 学校用户
 * 校园网统一用户管理
 */
@Entity
@EntityListeners(value = CurrentAuditor.class)
@Data
public class UserLiving extends JpaBasePo {

    private String userCode;
    private String buildingCode;
    private String roomCode;
}
