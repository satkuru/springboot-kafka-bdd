package com.karthi.learning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        CompletableFuture<SendResult<String, String>> completableFuture = kafkaTemplate.send(topic, message);
        completableFuture.whenComplete((res,exp)->{
           if(res!=null){
               log.info("Message sent to topic successfully to topic: {}", res.getRecordMetadata());
           }
        });
    }
}
