package com.interview.schoolspider.controller;

import com.interview.schoolspider.spider.model.SchoolSpiderVo;
import com.interview.schoolspider.spider.processor.SchoolSpider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.config.ConfigResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/school")
@Api(tags = {"School Module"})
@Slf4j
public class SchoolSpiderController {

    @Autowired
    private SchoolSpider schoolSpider;
    public static final String helpUrl = "http://xuexiao.pinwaiyi.com/hy/list.php?fid=%s";

    public static final List<Integer> sheng = new ArrayList<>(34);
    static {
        for(int i=8;i<=34; i++) {
            sheng.add(i);
        }
    }
    @GetMapping
    @ApiOperation(value = "test status", notes = "this is use to test service status")
    public ResponseEntity success() {
          sheng.stream().forEach(
                  i -> {
                    new Runnable() {
                        @Override
                        public void run() {
                            schoolSpider.run(String.format(helpUrl, i));
                        }
                    }.run();
                  }
          );
        return ResponseEntity.ok("success");
    }

    @Autowired
    private KafkaTemplate kafkaTemplate;



    @GetMapping("/test")
    @ApiOperation(value = "test kafka status", notes = "this is use to test service status")
    public ResponseEntity testKafka(@RequestParam(name = "message") String message) {
        log.info("kafkaTemplate.metrics() is :{}", kafkaTemplate.metrics());
//        kafkaTemplate.send("school-topic", message);

        SchoolSpiderVo schoolSpiderVo = new SchoolSpiderVo();
        schoolSpiderVo.setChuzhongzaixiaorenshu("111");
        schoolSpiderVo.setDianhua("22");
        schoolSpiderVo.setDiqu("33");
        schoolSpiderVo.setTitle(message);
//        kafkaTemplate.send("school-topic-1", schoolSpiderVo);
//        kafkaTemplate.send("school-topic-2", schoolSpiderVo);
//        kafkaTemplate.send("school-topic", schoolSpiderVo);
//        kafkaTemplate.send("test-topic", schoolSpiderVo);
//        kafkaTemplate.send("test-topic-1", schoolSpiderVo);
//        kafkaTemplate.send("test-topic-a", schoolSpiderVo);
        return ResponseEntity.ok(true);
    }

    @Autowired
    private KafkaAdminClient kafkaAdminClient;

    @DeleteMapping("/topic")
    public ResponseEntity deleteTopic(@RequestParam(name = "topic") String topic) {
        DeleteTopicsOptions deleteTopicsOptions = new DeleteTopicsOptions();
        deleteTopicsOptions.timeoutMs(1000);
        DeleteTopicsResult deleteTopicsResult = kafkaAdminClient.deleteTopics(Arrays.asList(topic), deleteTopicsOptions);
        try {
            return ResponseEntity.ok(deleteTopicsResult.all().get(1000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/topic")
    public ResponseEntity createTopic(@RequestParam(name = "topic") String topic,
                                      @RequestParam(name = "partitions") int partitions,
                                      @RequestParam(name = "replicas") short replicas) throws Exception{
        NewTopic newTopic = new NewTopic(topic,partitions, replicas);
        Collection<NewTopic> newTopicList = new ArrayList<>();
        newTopicList.add(newTopic);
        CreateTopicsResult createTopicsResult = kafkaAdminClient.createTopics(newTopicList);
        return ResponseEntity.ok(createTopicsResult.all().get(1000L, TimeUnit.MILLISECONDS));
    }


    @PostMapping("/topic/manage")
    public ResponseEntity manageTopic(@RequestParam(name = "topic") String topic,
                                      @RequestParam(name = "partitions") int partitions,
                                      @RequestParam(name = "replicas") int replicas) throws Exception{
        log.info("{}, {}, {}", partitions, replicas, topic);
        DescribeTopicsOptions describeTopicsOptions = new DescribeTopicsOptions();
        describeTopicsOptions.timeoutMs(1000);
        DescribeTopicsResult describeTopicsResult = kafkaAdminClient.describeTopics(Arrays.asList(topic), describeTopicsOptions);
        Map<String, TopicDescription> configs = describeTopicsResult.all().get(1000L, TimeUnit.MILLISECONDS);
        TopicDescription topicDescription = configs.get(topic);
        log.info("topicDescription is :{}", topicDescription.toString());
        Config config = new Config(Arrays.asList(
                new ConfigEntry("replicas", String.valueOf(replicas)), new ConfigEntry("partitions", String.valueOf(partitions))
        ));
        Map<ConfigResource, Config> configResourceConfigMap = new HashMap<>();
        configResourceConfigMap.put(new ConfigResource(ConfigResource.Type.TOPIC, topic), config);
        AlterConfigsOptions alterConfigsOptions = new AlterConfigsOptions();
        AlterConfigsResult alterConfigsResult = kafkaAdminClient.alterConfigs(configResourceConfigMap, alterConfigsOptions);
        log.info("----------------------------alterConfigsOptions is :{}", alterConfigsOptions);
        return ResponseEntity.ok().body(topicDescription.toString());
    }


    @GetMapping("/topic")
    public ResponseEntity listTopic() throws Exception {
        ListTopicsResult listTopicsResult = kafkaAdminClient.listTopics(new ListTopicsOptions());
        Set<String> topics = listTopicsResult.names().get(1000L, TimeUnit.MILLISECONDS);
//            topics.stream().forEach( i -> {
//                kafkaAdminClient.
//
//            });
        return ResponseEntity.ok(topics);
    }






}
