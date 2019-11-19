package com.interview.schoolspider.processor;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

@Slf4j
public class GithubRepoPageProcessor implements PageProcessor {
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {

//        log.info("page content is :{}", page.getRawText());

//        String  data = page.getUrl().regex("https://xuexiao\\.pinwaiyi\\.com/(\\w+)/.*").toString();
//        log.info("data is :{}", data);

        List<String> cityLinks = page.getHtml().css("div.shi").links().all();
        //cityLinks.stream().forEach(i -> log.info("shi url is :{}", i));

//        List<String> contents = page.getHtml().css("div.shi").$("a", "text").all();
//        contents.stream().forEach(i -> log.info("content is :{}", i));

        //page.putField("contents", contents);
        page.addTargetRequests(cityLinks);


        List<String> schoolLinks = page.getHtml().css("div.title").links().all();
        schoolLinks.stream().forEach(i -> log.info("school url is :{}", i));
        page.addTargetRequests(schoolLinks);
//        // 部分二：定义如何抽取页面信息，并保存下来
//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
//        if (page.getResultItems().get("name") == null) {
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
//
//        // 部分三：从页面发现后续的url地址来抓取
//        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
    }

    @Override
    public Site getSite() {
        return site;
    }


    public static void main(String[] args) {

        Spider.create(new GithubRepoPageProcessor())
                //从"https://github.com/code4craft"开始抓
//                .addUrl("http://xuexiao.pinwaiyi.com/")
                .addUrl("http://xuexiao.pinwaiyi.com/hy/list.php?fid=460")
                //.addUrl("http://github.com/code4craft")

                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}
