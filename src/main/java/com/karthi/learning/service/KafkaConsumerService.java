package com.karthi.learning.service;

import lombok.Getter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Getter
@Service
public class KafkaConsumerService {

    private String receivedMessage;

    @KafkaListener(topics = "test_topic", groupId = "test-group")
    public void listen(String message) {
        this.receivedMessage = message;
    }

}
