package com.klaus.interview.basemodel.school.po;


import com.klaus.interview.commonbase.config.CurrentAuditor;
import com.klaus.interview.commonjpaconfig.base.JpaBasePo;
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