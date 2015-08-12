package com.cucumber;

import static org.junit.Assert.assertNull;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.software.project.entities.User;
import com.software.project.service.UserService;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public class UserSteps{
	
	
	@Autowired
	public UserService userService;

	public WebDriver driver;
	
	@Before
	public void getInit() {
		driver = new FirefoxDriver();	
		driver.get("http://localhost:8080/project");
	}
	
	@After
    public void cleanUp(){
        if (driver != null) {
        	driver.close();
        	driver.quit();
        }
    }
	
	@Given("^the system has no user with username \"([^\"]*)\"$")
	public void the_system_has_no_user_with_username(String arg1){
				
		assertNull(userService.getUserByUsername(arg1));
	}
	
	@When("^I create a user with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_create_a_user_with_username_and_password(String arg1, String arg2) throws Exception {
		User user = new User();
		user.setUsername(arg1);
		user.setPassword(arg2);
		userService.createUser(user);		
	}
	
	@Then("^the user with username \"([^\"]*)\" is properly stored by the system$")
	public void the_user_with_username_is_properly_stored_by_the_system(String arg1) throws Throwable{
		//assertNotNull(userService.getUserByUsername(arg1));
	}
	
	
	@Given("^I am the at the Home page$")
	public void I_am_the_at_the_Home_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		
	}

	@Given("^I have a account with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_have_a_account_with_user_name_and_password(String arg1, String arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	}

	@When("^I click on login link$")
	public void I_click_on_login_button() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		final WebElement loginLink = driver.findElement(By.id("form:loginLink"));

        loginLink.sendKeys(Keys.ENTER);

	}

	@When("^I properly fill the fields with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_properly_fill_the_fields(String arg1, String arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had

 	
		final WebElement usernameButton = driver.findElement(By.id("form:username"));
		final WebElement passwordButton = driver.findElement(By.id("form:password"));
		usernameButton.sendKeys(arg1);
		passwordButton.sendKeys(arg2);   
		
	}

	@When("^click the login button$")
	public void click_the_login_button() throws Throwable {
	    // Express the Regexp above with the code you wish you ha
		
		final WebElement passwordButton = driver.findElement(By.id("form:loginButton"));
		passwordButton.sendKeys(Keys.ENTER);
		
	}

	@Then("^I logged in at the Home page$")
	public void I_logged_in_at_the_Home_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		
	}
	
	

}
