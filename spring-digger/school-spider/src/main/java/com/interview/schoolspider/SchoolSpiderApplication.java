package com.interview.schoolspider;

import com.interview.schoolspider.spider.model.SchoolVo;
import com.spring4all.swagger.EnableSwagger2Doc;
import kafka.Kafka;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.record.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.List;

@SpringBootApplication
@EnableSwagger2Doc
@Slf4j
public class SchoolSpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolSpiderApplication.class, args);
    }



//    @KafkaListener(topics = {"school-topic"}, groupId = "test1")
//    public void receive1(String record) {
//        log.info("receive1 data is :{}", record);
//    }
//
//    @KafkaListener(topics = {"school-topic"}, groupId = "test2")
//    public void receive2(String record) {
//        log.info("receive2 data is :{}", record);
//    }







//    @KafkaListener(topics = {"school-topic"}, groupId = "test3")
//    public void receive3(List<ConsumerRecord<String, SchoolVo>> record) {
//        log.info("receive3 data is :{}", record);
//    }

//    @KafkaListener(groupId = "test3", topics = "schoo-topic-1")
//    public void receive4(List<ConsumerRecord<String, SchoolVo>> record) {
//        log.info("receive4 data is :{}", record);
//    }

    @KafkaListener(id = "test3", topics = {"schoo-topic-2","school-topic-1","school-topic"})
    public void receive5(List<ConsumerRecord<String, SchoolVo>> record) {
        log.info("receive5 data is :{}", record);
    }
//    @KafkaListener(groupId = "test6", topicPattern = "schoo-topic-*")
//    public void receive6(List<ConsumerRecord<String, SchoolVo>> record) {
//        log.info("receive6 data is :{}", record);
//    }



}
