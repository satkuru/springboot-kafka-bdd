package com.karthi.learning.bdd.config;

import com.karthi.learning.Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
@EmbeddedKafka(partitions = 1,
        topics = {"test_topic"},
        controlledShutdown = true)
public class SpringIntegrationTest {

}
