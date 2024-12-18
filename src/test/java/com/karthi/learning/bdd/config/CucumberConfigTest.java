package com.karthi.learning.bdd.config;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"},
        glue = {"com.karthi.learning.bdd.config",
                "com.karthi.learning.bdd.steps"},
        publish = false)
public class CucumberConfigTest {
}
