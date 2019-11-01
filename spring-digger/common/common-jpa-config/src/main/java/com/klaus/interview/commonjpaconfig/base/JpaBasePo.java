package com.klaus.interview.commonjpaconfig.base;


import com.klaus.interview.commonbase.po.BasePo;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

import static com.klaus.interview.commonbase.util.CommonConstants.DeleteSet.UNDELETED;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class JpaBasePo extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date createDt;

    @LastModifiedDate
    private Date lastUpdateDt;

    @CreatedBy
    @Size(min = 6, max = 128)
    private String createBy;

    @LastModifiedBy
    @Size(min = 6, max = 128)
    private String lastUpdateBy;
    private char deleted;

    @PrePersist
    public void onCreate() {
        deleted = UNDELETED.getValue();
    }


}
