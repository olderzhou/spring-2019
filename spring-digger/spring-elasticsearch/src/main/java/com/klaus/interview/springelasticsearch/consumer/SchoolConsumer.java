package com.klaus.interview.springelasticsearch.consumer;


import com.klaus.interview.basespider.model.SchoolVo;
import com.klaus.interview.springelasticsearch.config.DistributedIdGenerator;
import com.klaus.interview.springelasticsearch.model.SchoolPo;
import com.klaus.interview.springelasticsearch.repository.SchoolEsRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@Slf4j
@AllArgsConstructor
public class SchoolConsumer {

    private DistributedIdGenerator distributedIdGenerator;

    private static final String SCHOOL_TPOIC = "school-topic";

    private SchoolEsRepo schoolEsRepo;

//    @KafkaListener(topicPartitions = {
//            @TopicPartition(
//                    topic = SCHOOL_TPOIC,
//                    partitionOffsets ={@PartitionOffset(partition = "0", initialOffset="0"), @PartitionOffset(partition = "1", initialOffset="0")}
//                    )
//    })
    public void receive1(List<ConsumerRecord<String, SchoolVo>> record) {
        List<SchoolPo> schoolPoList = record.stream().filter(
                new Predicate<ConsumerRecord<String, SchoolVo>>() {
                    @Override
                    public boolean test(ConsumerRecord<String, SchoolVo> stringSchoolVoConsumerRecord) {
                        List<SchoolPo> schoolPos = schoolEsRepo.existsByName(stringSchoolVoConsumerRecord.value().getTitle());
                        if (schoolPos == null || schoolPos.isEmpty()) {
                            return true;
                        }
                        return false;
                    }
                }).map(i -> {
            SchoolPo schoolPo = new SchoolPo();
            schoolPo.setName(i.value().getTitle());
            schoolPo.setCode(i.value().getXuexiaodaima());
            schoolPo.setChairman(i.value().getXiaozhang());
            schoolPo.setId(distributedIdGenerator.getSnowFlake().nextId());
            return schoolPo;
        }).collect(Collectors.toList());
        if (schoolPoList !=null && !schoolPoList.isEmpty()) {
            schoolEsRepo.saveAll(schoolPoList);
        }
        log.info("saved school size is: {}", record.size());
    }

}
