package com.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    format = "pretty"     
)
//tags = {"~@Ignore"},
//features = "src/test/resources/com/cucumber/"  
public class RunCucumber {  
	
}