package com.software.project.cucumber.steps;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.PostConstruct;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.software.project.entities.Legend;
import com.software.project.functional.HomePage;
import com.software.project.functional.IndexPage;
import com.software.project.functional.ResetPasswordPage;
import com.software.project.functional.SignUpPage;
import com.software.project.functional.flow.At;
import com.software.project.functional.flow.Go;
import com.software.project.service.LegendService;
import com.software.project.service.UserService;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(locations = { "classpath:cucumber.xml" })
@WebAppConfiguration
public class LegendSteps {

	@Autowired
	public LegendService legendService;

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private WebDriver driver;
	
	private Legend legendAux;
	
	@Before
	public void init() {

	}

	@PostConstruct
	public void setUp() {

		Go.setDriver(driver);
		At.setDriver(driver);
		PageFactory.initElements(driver, IndexPage.class);
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, SignUpPage.class);
		PageFactory.initElements(driver, ResetPasswordPage.class);
		

	}
	
	
	@AfterClass
	public static void cleanUp(){
		//TODO Check better approach to manage the browser during tests
		//		driver.quit();
	}
	
	@Given("^the system has no legend with name \"(.*?)\"$")
	public void the_system_has_no_legend_with_name(String legendName) throws Throwable {
		Legend legend = legendService.getLegendByCode(legendName);
		assertNull(legend);
	}

	@When("^I create a legend with name \"(.*?)\"$")
	public void i_create_a_legend_with_name(String legendName) throws Throwable {
		legendAux = legendService.createLegend(legendName);
		    
	}

	@Then("^the legend is stored by the system$")
	public void the_legend_is_stored_by_the_system() throws Throwable {
		assertNotNull(legendAux);	
	}

	@Given("^the system has a legend with name \"(.*?)\"$")
	public void the_system_has_a_legend_with_name(String legendName) throws Throwable {
		Legend legend = legendService.getLegendByCode(legendName);
		assertNotNull(legend);
	    
	}

	@Then("^the legend with name \"(.*?)\" is not stored in the system$")
	public void the_legend_with_name_is_not_stored_in_the_system(String legendName) throws Throwable {
		Legend legend = legendService.getLegendByCode(legendName);
	    assertNull(legend);
	    
	}

	@Given("^I am at the Admin Page$")
	public void i_am_at_the_Admin_Page() throws Throwable {
	    //TODO
	    
	}

	@Given("^I fill the name field with \"(.*?)\"$")
	public void i_fill_the_name_field_with(String legendName) throws Throwable {
	    //TODO
	    
	}

	@Given("^I click the create button$")
	public void i_click_the_create_button() throws Throwable {
	    //TODO
	    
	}

	@Then("^a message indicating the legend was successfully stored is displayed$")
	public void a_message_indicating_the_legend_was_successfully_stored_is_displayed() throws Throwable {
	    //TODO
	    
	}

	@When("^I try to delete a legend with name \"(.*?)\"$")
	public void i_try_to_delete_a_legend_with_name(String legendName) throws Throwable {
		Legend legend = legendService.getLegendByCode(legendName);
		legendService.deleteLegend(legend);	    
	}

	@Then("^the legend is not stored in the system$")
	public void the_legend_is_not_stored_in_the_system() throws Throwable {
	    //TODO
	    
	}

}
