package com.karthi.learning.bdd.config;

import com.karthi.learning.Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@CucumberContextConfiguration
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(partitions = 1,
        topics = {"user-example-topic","test_topic"},
        controlledShutdown = true,
        kraft = false,
        brokerProperties = {"log.dir=build/tmp/kafka-data/${spring.application.name}"})
public class SpringIntegrationTest {
}
