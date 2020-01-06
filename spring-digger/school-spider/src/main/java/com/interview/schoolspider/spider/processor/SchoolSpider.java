package com.interview.schoolspider.spider.processor;


import com.interview.schoolspider.spider.model.SchoolSpiderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Slf4j
@Component
public class SchoolSpider {

    @Value("${spider.thread.helpurl}")
    private String helpurl;

    @Value("${spider.thread.amount}")
    private String threadAmount;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void run(String url) {
        log.info("url is :{}, helpUrl is:{} threadAmount is :{}", url, helpurl, threadAmount);
        OOSpider.create(Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36")
                ,new PageModelPipeline() {
                    @Override
                    public void process(Object o, Task task) {
                        log.error("=====================================data is :{}", o);
                        kafkaTemplate.send("school-topic", ((SchoolSpiderVo) o).toScoolVo());
                    }
                }, SchoolSpiderVo.class)
                .addUrl(StringUtils.isEmpty(url)? "http://xuexiao.pinwaiyi.com/hy/list.php?fid=200": url)
                .thread(Integer.parseInt(threadAmount)).run();
    }
}
