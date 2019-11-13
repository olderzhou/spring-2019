package com.klaus.interview.basemodel.model.chinese.po;


import com.klaus.interview.basemodel.config.CurrentAuditor;
import com.klaus.interview.basemodel.base.JpaBasePo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Entity
@Data
@ToString
@EntityListeners(value = CurrentAuditor.class)
public class ChineseWords extends JpaBasePo {

    private String cn;
    private String similar;
}
