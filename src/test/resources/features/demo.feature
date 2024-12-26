Feature: Kafka producer and consumer integration in Spring Boot
  Scenario: Send a message to Kafka and receive it
    Given a Kafka producer is available
    When a message is sent to the "test_topic" topic
    Then the consumer should receive the message
