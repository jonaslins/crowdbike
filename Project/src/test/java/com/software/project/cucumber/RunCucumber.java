package com.software.project.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue= { "com.software.project.cucumber" , "cucumber.api.spring" },
		format={"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class RunCucumber {  
	
}