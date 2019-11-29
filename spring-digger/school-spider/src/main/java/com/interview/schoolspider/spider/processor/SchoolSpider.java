package com.interview.schoolspider.spider.processor;


import com.interview.schoolspider.spider.model.SchoolVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolSpider implements Runnable{
    private String url;

    @Value("${spider.thread.amount:10}")
    private int threadAmount;

    @Override
    public void run() {
        log.info("url is :{}, threadAmount is :{}", url, threadAmount);
        OOSpider.create(Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36")
                ,new PageModelPipeline() {
                    @Override
                    public void process(Object o, Task task) {
                        log.error("=====================================data is :{}", o);
                    }
                }, SchoolVo.class)
                .addUrl("http://xuexiao.pinwaiyi.com/hy/list.php?fid=460")
                .thread(threadAmount).run();
    }
}
