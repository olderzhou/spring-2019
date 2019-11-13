package com.klaus.interview.basemodel.model.chinese.po;


import com.klaus.interview.basemodel.base.JpaBasePo;
import com.klaus.interview.basemodel.config.CurrentAuditor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Entity
@Data
@ToString
@EntityListeners(value = CurrentAuditor.class)
public class ChineseWord extends JpaBasePo {

    private String cn;
    private String spell;
}
