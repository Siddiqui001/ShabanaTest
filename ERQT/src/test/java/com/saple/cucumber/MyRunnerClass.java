package com.saple.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources" }, plugin = { "pretty","html:target/cucumber-reports" }, monochrome = true, glue = { "com.saple.cucumber" }, tags = { "@Ayaan" })

public class MyRunnerClass extends AbstractTestNGCucumberTests {

}
