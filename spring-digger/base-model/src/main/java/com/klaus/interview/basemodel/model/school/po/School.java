package com.klaus.interview.basemodel.model.school.po;

import com.klaus.interview.basemodel.config.CurrentAuditor;
import com.klaus.interview.basemodel.base.JpaBasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;


@Entity
@Data
@ToString
@EntityListeners(value = CurrentAuditor.class)
@AllArgsConstructor
@NoArgsConstructor
public class School extends JpaBasePo {

    private String name;
    private String schoolCode;

}
