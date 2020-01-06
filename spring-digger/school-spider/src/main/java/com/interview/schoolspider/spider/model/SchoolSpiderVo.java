package com.interview.schoolspider.spider.model;


import com.klaus.interview.basespider.model.SchoolVo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@ApiModel("school")
@HelpUrl("http://xuexiao.pinwaiyi.com/hy/list.php\\?fid=\\d+")
@TargetUrl("http://xuexiao.pinwaiyi.com/home/\\?uid=\\d+")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class SchoolSpiderVo {

    @ExtractBy(value = "//td[@class=\"content\"]/table/tbody/tr[1]/td[2]/b/font/text()", type = ExtractBy.Type.XPath)
    private String title;

    /*地区：	四川省遂宁市*/
    @ExtractBy(value = "//td[@class=\"content\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/text()", type = ExtractBy.Type.XPath)
    private String diqu;
    /*电话：	0825-7853528*/
    @ExtractBy(value = "//td[@class=\"content\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[2]/td[2]/text()", type = ExtractBy.Type.XPath)
    private String dianhua;
    /*学段:	24一贯制学校*/
    @ExtractBy(value = "//td[@class=\"content\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[3]/td[2]/text()", type = ExtractBy.Type.XPath)
    private String xueduan;
    /*邮编:	629300*/
    @ExtractBy(value = "//td[@class=\"content\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[4]/td[2]/text()", type = ExtractBy.Type.XPath)
    private String youbian;
    /*校长：	王福林*/
    @ExtractBy(value = "//td[@class=\"content\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[5]/td[2]/text()", type = ExtractBy.Type.XPath)
    private String xiaozhang;
    /*小学在校人数:	0*/
    @ExtractBy(value = "//td[@class=\"content\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[6]/td[2]/text()", type = ExtractBy.Type.XPath)
    private String xiaoxuezaixiaorenshu;
    /*初中在校人数:	632*/
    @ExtractBy(value = "//td[@class=\"content\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[7]/td[2]/text()", type = ExtractBy.Type.XPath)
    private String chuzhongzaixiaorenshu;
    /*高中在校人数:	0*/
    @ExtractBy(value = "//td[@class=\"content\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[8]/td[2]/text()", type = ExtractBy.Type.XPath)
    private String gaozhongzaixiaorenshu;
    /*学校地址*/
    @ExtractBy(value = "//td[@class=\"content\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[9]/td[2]/text()", type = ExtractBy.Type.XPath)
    private String xuexiaodizhi;

    @ExtractBy(value = "//td[@class=\"homepage_left\"]/table/tbody/tr[2]/td[1]/center[5]/text()", type = ExtractBy.Type.XPath)
    private String xuexiaodaima;


    public SchoolVo toScoolVo() {
        SchoolVo schoolVo = new SchoolVo();
        BeanUtils.copyProperties(this, schoolVo);
        return schoolVo;
    }

//    public static void main(String[] args) {
//        OOSpider.create(Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36")
//                ,new PageModelPipeline() {
//                    @Override
//                    public void process(Object o, Task task) {
//                        log.error("=====================================data is :{}", o);
//                    }
//                }, SchoolSpiderVo.class)
//                .addUrl("http://xuexiao.pinwaiyi.com/hy/list.php?fid=460")
//                .thread(10).run();
//    }
}
