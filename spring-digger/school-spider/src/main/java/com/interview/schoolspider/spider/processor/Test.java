package com.interview.schoolspider.spider.processor;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




@Slf4j
public class Test {

    public static void main(String[] args) {

//        Pattern pattern = Pattern.compile("http://xuexiao.pinwaiyi.com/home/?uid=\\[1-9]+\\d*");
        Pattern pattern = Pattern.compile("http://xuexiao.pinwaiyi.com/home/\\?uid=\\d*");
        Matcher matcher = pattern.matcher("http://xuexiao.pinwaiyi.com/home/?uid=2341231");
        if (matcher.find()) {
            log.info("==========");
        } else {
            log.info("------------");
        }


    }
}
