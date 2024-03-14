package com.automation.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features={"classpath:FeatureFiles/herokuinternet.feature"}, glue={"classpath:com.automation.stepdef","classpath:com.automation.base"}, plugin={"json:target/cucumber-reports/CucumberTestReport.json"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
