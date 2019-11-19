package com.interview.schoolspider;


import io.swagger.annotations.ApiModel;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@ApiModel("school")
//@TargetUrl("http://xuexiao.pinwaiyi.com/home/?uid=120742")
@TargetUrl("http://xuexiao.pinwaiyi.com/hy/list.php?fid=38")
//@ExtractBy(value = "", multi = true)
public class SchoolVo {

    /*地区：	四川省遂宁市*/
    @ExtractBy(value = "", type = ExtractBy.Type.Css)
    private String diqu;
    /*电话：	0825-7853528*/
    @ExtractBy(value = "", type = ExtractBy.Type.Css)
    private String dianhua;
    /*学段:	24一贯制学校*/
    @ExtractBy(value = "", type = ExtractBy.Type.Css)
    private String xueduan;
    /*邮编:	629300*/
    @ExtractBy(value = "", type = ExtractBy.Type.Css)
    private String youbian;
    /*校长：	王福林*/
    @ExtractBy(value = "", type = ExtractBy.Type.Css)
    private String xiaozhang;
    /*小学在校人数:	0*/
    @ExtractBy(value = "", type = ExtractBy.Type.Css)
    private String xiaoxuezaixiaorenshu;
    /*初中在校人数:	632*/
    @ExtractBy(value = "", type = ExtractBy.Type.Css)
    private String chuzhongzaixiaorenshu;
    /*高中在校人数:	0*/
    @ExtractBy(value = "", type = ExtractBy.Type.Css)
    private String gaozhongzaixiaorenshu;
    /*学校地址*/
    @ExtractBy(value = "", type = ExtractBy.Type.Css)
    private String xuexiaodizhi;
}
