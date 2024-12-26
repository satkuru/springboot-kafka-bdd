package com.karthi.learning.bdd.steps;

import com.karthi.learning.bdd.config.SpringIntegrationTest;
import com.karthi.learning.service.KafkaConsumerService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.awaitility.Awaitility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KafkaStepDefinitions extends SpringIntegrationTest {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private KafkaConsumerService service;

    private String receivedMessage;

    @Given("a Kafka producer is available")
    public void givenKafkaProducerIsAvailable() {
        assertNotNull( kafkaTemplate);
    }

    @When("a message is sent to the {string} topic")
    public void whenMessageIsSentToTopic(String topic) {
        // Send a message to Kafka
        String message = "Test Message";
        kafkaTemplate.send(topic, message);
        receivedMessage = message;
    }

    @Then("the consumer should receive the message")
    public void thenTheConsumerShouldReceiveTheMessage() throws InterruptedException {
        Awaitility.await().atMost(5, TimeUnit.SECONDS).until(()->service.getReceivedMessage()!=null);
        assertEquals(receivedMessage,service.getReceivedMessage());
    }
}
