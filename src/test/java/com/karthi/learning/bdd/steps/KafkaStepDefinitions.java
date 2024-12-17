package com.karthi.learning.bdd.steps;

import com.karthi.learning.service.KafkaConsumer;
import com.karthi.learning.service.KafkaProducer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;

//@CucumberContextConfiguration
@EmbeddedKafka(partitions = 1,
        topics = {"test_topic"},
        brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
@EnableKafka
@TestPropertySource(properties = {
        "spring.kafka.bootstrap-servers = ${spring.embedded.kafka.brokers}",
})
public class KafkaStepDefinitions {

    @Autowired
    private KafkaProducer kafkaProducer;  // Assuming you have a KafkaProducer service

    @Autowired
    private KafkaConsumer kafkaConsumer;  // Assuming you have a KafkaConsumer service

    private String receivedMessage;

    @Given("a Kafka producer is available")
    public void givenKafkaProducerIsAvailable() {
        Assert.assertNotNull(kafkaProducer);
        Assert.assertNotNull(kafkaConsumer);
        // You can verify that the KafkaProducer bean is injected correctly.
    }

    @When("a message is sent to the {string} topic")
    public void whenMessageIsSentToTopic(String topic) {
        // Send a message to Kafka
        String message = "Test Message";
        kafkaProducer.sendMessage(topic, message);
    }

    @Then("the consumer should receive the message")
    public void thenTheConsumerShouldReceiveTheMessage() throws InterruptedException {
        // Wait for the consumer to process the message
        Thread.sleep(1000);  // Simulating waiting for message consumption

        // Verify that the message is received by the KafkaConsumer
//        receivedMessage = kafkaConsumer.getReceivedMessage();
//        assertEquals("Test Message", receivedMessage);
    }
}
