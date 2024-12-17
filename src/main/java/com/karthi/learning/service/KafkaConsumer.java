package com.karthi.learning.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private String receivedMessage;

    @KafkaListener(topics = "test_topic", groupId = "test-group")
    public void listen(String message) {
        this.receivedMessage = message;
    }

    public String getReceivedMessage() {
        return receivedMessage;
    }
}
