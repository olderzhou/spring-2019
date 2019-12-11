package com.klaus.interview.commonbase.util;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
public class ChineseCloudsGenerator {
    //主语、谓语、宾语、定语、状语、补语
    public static List<String> subjectPhrases = Arrays.asList("我","你","他","的","她","它","I","you","he","she","we","they","学生","老师","教授","农民","工人","战士","解放军","中国人","美国人","日本人","我们","你们","他们","它们","她们","大家","所有人","钱","老师","学生","校长","打菜阿姨","扫地阿姨","外来学生","留学生","一楼","二楼","三楼","深圳","上海","北京","纽约","巴黎","伦敦","法兰克福","魁北克","台北","东京");
    public static List<String> predicatePhrases = Arrays.asList("讨厌","hate","出生","死亡","解释","接受","接收","","","","","嫌弃","热爱","充满","学会","学习","看到","看","看见","打","骂","说");
    public static List<String> objectPhrases = Arrays.asList("我","你","他","的","她","它","我们","你们","他们","它们","她们","大家","所有人","动物","植物","微生物");
    public static List<String> attributePhrases = Arrays.asList("野生","家养","人工培养","弯弯曲曲","扭扭捏捏","好","不好","绿","新","旧","高","底","难","深","浅");
    public static List<String> adverbialPhrases = Arrays.asList("喜欢","讨厌","嫌弃","热爱","激情","呢");
    public static List<String> complementPhrases = Arrays.asList("可爱的","美丽的","善良的","和蔼的","死的","活的","香的","香香的","臭臭的","热爱","激情");
    public static List<String> badLanguage = Arrays.asList("混蛋","傻瓜","笨蛋","垃圾","傻逼","fuck you","滚蛋","去你妈的","不要脸的","撕逼","搞笑","见鬼");
    public static List<String> symbolsEnd = Arrays.asList(",", "!", "?", "。");
    public static List<String> symbolsBetween = Arrays.asList("", ".", ":");
    @Getter
    public enum SentenceType {
        simple(1), normal(2), complete(3), bad_language(4), full(5), random(0);
        private int type;
        SentenceType(int value) {
            this.type = value;
        }
    }

    static {

    }
    public ChineseCloudsGenerator() {

    }


    //主谓宾、定状补，主干枝叶分清楚。定语必居主
    //宾前，谓前为状谓后补。状语有时位主前，逗号分开
    //心有数
    public static String generatorSimpleSentence(SentenceType type, int length) {
        switch (type) {
            case normal: {
                return getByRandom(subjectPhrases)+ getByRandom(predicatePhrases)+getByRandom(objectPhrases)+getByRandom(symbolsEnd);
            }
            case complete: {
                return getByRandom(attributePhrases)+getByRandom(subjectPhrases)+ getByRandom(predicatePhrases)+getByRandom(attributePhrases)+getByRandom(objectPhrases)+getByRandom(symbolsEnd);
            }
            case full: {
                return getByRandom(complementPhrases)+getByRandom(subjectPhrases)+ getByRandom(predicatePhrases)+getByRandom(attributePhrases)+getByRandom(objectPhrases)+getByRandom(symbolsEnd);
            }
            case simple: {
                return getByRandom(adverbialPhrases)+getByRandom(subjectPhrases)+ getByRandom(predicatePhrases)+getByRandom(objectPhrases)+getByRandom(symbolsEnd);
            }
            case bad_language: {
                return getByRandom(badLanguage)+getByRandom(symbolsEnd);
            }
            case random: {
                return ChineseWordsGenerator.generatorSentence(length);
            }
        }
        return "";
    }
    public static String getByRandom(List<String> source) {
        Random random =new Random();
        int ran = random.nextInt(source.size());
        return source.get(ran);
    }


    public static String generateRandomLengthSentence() {
        Random random =new Random();
        int ran = random.nextInt(100);
        return generatorSimpleSentence(SentenceType.complete, ran);
    }

    public static void main(String[] args) {
        log.info("sentence is : {} ", generateRandomLengthSentence());
        log.info("bad_language sentence is : {} ", generatorSimpleSentence(SentenceType.bad_language, 12));
        log.info("full sentence is : {} ", generatorSimpleSentence(SentenceType.full, 12));
        log.info("complete sentence is : {} ", generatorSimpleSentence(SentenceType.complete, 12));
        log.info("normal sentence is : {} ", generatorSimpleSentence(SentenceType.normal, 12));
        log.info("simple sentence is : {} ", generatorSimpleSentence(SentenceType.simple, 12));
        log.info("random sentence is : {} ", generatorSimpleSentence(SentenceType.random, 12));
    }

}
