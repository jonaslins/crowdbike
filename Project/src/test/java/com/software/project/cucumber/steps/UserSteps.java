package com.software.project.cucumber.steps;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.software.project.entities.User;
import com.software.project.service.UserService;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@ContextConfiguration(locations = {"classpath:cucumber.xml"})
@WebAppConfiguration
public class UserSteps{
	
	
	@Autowired
	public UserService userService;
	@Autowired
	private WebDriver driver;

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Before
	public void init(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@PostConstruct
	public void setUp() {
		System.out.println(wac.getApplicationName());
	}

	
	@After
    public void cleanUp(){
        if (driver != null) {
        	driver.close();
        }
    }
	
	@PreDestroy
	public void tearDown() {
		driver.quit();
		
	}
	
	
	@Given("^the system has no user with username \"([^\"]*)\"$")
	public void the_system_has_no_user_with_username(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@When("^I create a user with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_create_a_user_with_username_and_password(String arg1, String arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@Then("^the user with username \"([^\"]*)\" is properly stored by the system$")
	public void the_user_with_username_is_properly_stored_by_the_system(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@Given("^I am the at the Home page$")
	public void I_am_the_at_the_Home_page() throws Throwable {
	    driver.get("http://localhost:8080/example/");
	    
	}

	@Given("^I have a account with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_have_a_account_with_username_and_password(String arg1, String arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@When("^I click on login link$")
	public void I_click_on_login_link() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("form:loginButton")));
	}

	@When("^I properly fill the fields with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_properly_fill_the_fields_with_username_and_password(String arg1, String arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@When("^click the login button$")
	public void click_the_login_button() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@Then("^I logged in at the Home page$")
	public void I_logged_in_at_the_Home_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    
	}
	
	
	
	

}
