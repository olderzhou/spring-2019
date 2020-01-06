package com.klaus.interview.basespider.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class SchoolVo {

    private String title;
    /*地区：	四川省遂宁市*/
    private String diqu;
    /*电话：	0825-7853528*/
    private String dianhua;
    /*学段:	24一贯制学校*/
    private String xueduan;
    /*邮编:	629300*/
    private String youbian;
    /*校长：	王福林*/
    private String xiaozhang;
    /*小学在校人数:	0*/
    private String xiaoxuezaixiaorenshu;
    /*初中在校人数:	632*/
    private String chuzhongzaixiaorenshu;
    /*高中在校人数:	0*/
    private String gaozhongzaixiaorenshu;
    /*学校地址*/
    private String xuexiaodizhi;
    /*学校代码*/
    private String xuexiaodaima;
}
