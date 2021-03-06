package com.klaus.interview.basemodel.model.school.po;

import com.klaus.interview.basemodel.config.CurrentAuditor;
import com.klaus.interview.basemodel.base.JpaBasePo;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 建筑物
 */
@Entity
@Data
@ToString
@EntityListeners(value = CurrentAuditor.class)
public class Building extends JpaBasePo {

    private String name;
    private String code;
    private int type;


    @Getter
    enum BuildingType {
        teach(1);
        private int value;
        BuildingType(int value) {
            this.value = value;
        }



    }

}
