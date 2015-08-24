package com.software.project.cucumber.steps;

import static org.junit.Assert.*;

import javax.annotation.PostConstruct;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.software.project.entities.User;
import com.software.project.functional.HomePage;
import com.software.project.functional.IndexPage;
import com.software.project.functional.flow.At;
import com.software.project.functional.flow.Go;
import com.software.project.service.UserService;

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
	private WebApplicationContext wac;
	
	@Autowired
	private WebDriver driver;
	
	private MockMvc mockMvc;
	
	private User userAux;
	
	
	@Before
	public void init(){
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	
	@PostConstruct
	public void setUp(){
		Go.setDriver(driver);
		At.setDriver(driver);
		PageFactory.initElements(driver, IndexPage.class);
		PageFactory.initElements(driver, HomePage.class);
	}
	
	@AfterClass
	public static void cleanUp(){
		//TODO Check better approach to manage the browser during tests
		//driver.quit();
	}
	
	@Given("^the system has no user with username \"([^\"]*)\"$")
	public void the_system_has_no_user_with_username(String username) throws Throwable {
		
		User user = userService.getUserByUsername(username);
		assertNull(user);
		
	}

	@When("^I create a user with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_create_a_user_with_username_and_password(String username, String password) throws Throwable {
		
		User user = new User(username, password);
		userAux = userService.createUser(user);    
	    
	}

	@Then("^the user is properly stored by the system$")
	public void the_user_is_properly_stored_by_the_system() throws Throwable {
				
		assertNotNull(userAux);
	    
	}

	@Given("^I have an account with username \"(.*?)\" and password \"(.*?)\"$")
	public void i_have_an_account_with_username_and_password(String username, String password) throws Throwable {
		
		User user = userService.getUserByUsername(username);
		assertNotNull(user);		
		
	}
	
	@Given("^I am at the Index page$")
	public void i_am_at_the_Index_page() throws Throwable {
		
	    Go.to(IndexPage.URL);
	    At.page(IndexPage.URL);
	   	    
	}

	@When("^I click on login link$")
	public void I_click_on_login_link() throws Throwable {
				
		IndexPage.clickLoginLink();
		
	}

	@When("^I properly fill the fields with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_properly_fill_the_fields_with_username_and_password(String username, String password) throws Throwable {
		
		IndexPage.fillLoginForm(username, password);    
	    
	}

	@When("^click the login button$")
	public void click_the_login_button() throws Throwable {
		
		IndexPage.clickLoginButton();
	    
	}

	@Then("^I'm logged in at the Home page with my \"(.*?)\" username account$")
	public void i_m_logged_in_at_the_Home_page_with_my_username_account(String username) throws Throwable {
				
		assertTrue(At.page(HomePage.URL));
		assertTrue(HomePage.checkIfLoggedInAtGui(username));
		
	}
		

}
