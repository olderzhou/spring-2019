package com.interview.schoolspider.config;


import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Autowired
    private KafkaAdmin kafkaAdmin;

    @Bean
    public KafkaAdminClient kafkaAdminClient() {
        return (KafkaAdminClient)KafkaAdminClient.create(kafkaAdmin.getConfig());
    }

}
