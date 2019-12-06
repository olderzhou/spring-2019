package com.klaus.interview.commonbase.util;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
public class ChineseCloudsGenerator {
    //主语、谓语、宾语、定语、状语、补语
    public static List<String> subjectPhrases = Arrays.asList("我","你","他","的","她","它","I","you","he","she","we","they","学生","老师","教授","农民","工人","战士","解放军","中国人","美国人","日本人","我们","你们","他们","它们","她们","大家","所有人");
    public static List<String> predicatePhrases = Arrays.asList("讨厌","hate","出生","死亡","解释","接受","接收","","","","","嫌弃","热爱","充满","学会","学习","看到","看","看见","打","骂","说","","","","","","");
    public static List<String> objectPhrases = Arrays.asList("我","你","他","的","她","它","我们","你们","他们","它们","她们","大家","所有人","动物","植物","微生物","","","","","","","","");
    public static List<String> attributePhrases = Arrays.asList("我","你","他","的","她","它","喜欢","讨厌","嫌弃","热爱","激情","呢","","","","","","","","","","","","");
    public static List<String> adverbialPhrases = Arrays.asList("我","你","他","的","她","它","喜欢","讨厌","嫌弃","热爱","激情","呢","","","","","","","","","","","","","","");
    public static List<String> complementPhrases = Arrays.asList("可爱的","美丽的","善良的","和蔼的","她","它","喜欢","讨厌","嫌弃","热爱","激情","呢","","","","","","","","","","","","","","","","");
    @Getter
    public enum SentenceType {
        simple(1), normal(2), complete(3);
        private int type;
        SentenceType(int value) {
            this.type = value;
        }
    }

    static {

    }
    public ChineseCloudsGenerator() {

    }
    public static String generatorSimpleSentence(SentenceType type, int length) {
        Random random =new Random();
        int ran = random.nextInt(100);
        switch (type) {
            case normal: {
                return subjectPhrases.get(ran)+ predicatePhrases.get(ran)+objectPhrases.get(ran);
            }
            case complete: {

                return subjectPhrases.get(ran)+ predicatePhrases.get(ran)+objectPhrases.get(ran);
            }
            case simple: {
                return subjectPhrases.get(ran)+ predicatePhrases.get(ran)+objectPhrases.get(ran);
            }
            default: {
                return ChineseWordsGenerator.generatorSentence(length);
            }
        }
    }

    public static String generateRandomLengthSentence() {
        Random random =new Random();
        int ran = random.nextInt(100);
        return generatorSimpleSentence(SentenceType.complete, ran);
    }

    public static void main(String[] args) {
        log.info("sentence is :{} ", generateRandomLengthSentence());
    }

}
