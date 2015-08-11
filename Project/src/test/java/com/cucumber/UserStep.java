package com.cucumber;

import static org.junit.Assert.*;
import org.springframework.test.context.ContextConfiguration;

import com.software.project.beans.UserBean;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("classpath:cucumber.xml")
public class UserStep {
	
	
	
	@Given("^the system has no user with username \"([^\"]*)\"$")
	public void the_system_has_no_user_with_username(String arg1){
	    // Express the Regexp above with the code you wish you had	   
	}
	
	@When("^I create a user with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_create_a_user_with_username_and_password(String arg1, String arg2) {
	    // Express the Regexp above with the code you wish you had
	}
	
	@Then("^the user with username \"([^\"]*)\" is properly stored by the system$")
	public void the_user_with_username_is_properly_stored_by_the_system(String arg1) throws Throwable{
	    // Express the Regexp above with the code you wish you had
		assertEquals("foo", "foo");
	}

}
