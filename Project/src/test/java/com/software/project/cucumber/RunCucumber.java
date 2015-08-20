package com.software.project.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue="com.software.project.cucumber.steps")
public class RunCucumber {  
	
}