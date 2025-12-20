package com.info.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Rajesh
 */
@Slf4j
@Component
public class KafkaConsumers {

    @KafkaListener(topics = "order", groupId = "groupId-1")
    public void listenGroupOrder(String message) {
        System.out.println("****** Received Message for order Topic in groupId-1:********** {} "+ message);
    }




}
