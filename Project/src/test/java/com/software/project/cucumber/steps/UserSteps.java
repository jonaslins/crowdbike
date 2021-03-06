package com.software.project.cucumber.steps;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.software.project.entities.PasswordResetToken;
import com.software.project.entities.User;
import com.software.project.functional.HomePage;
import com.software.project.functional.IndexPage;
import com.software.project.functional.ResetPasswordPage;
import com.software.project.functional.SignUpPage;
import com.software.project.functional.flow.At;
import com.software.project.functional.flow.Go;
import com.software.project.service.UserService;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class UserSteps extends Steps{

	@Autowired
	public UserService userService;

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private WebDriver driver;

	private MockMvc mockMvc;

	private User userAux;
	private PasswordResetToken tokenAux;
	@Before
	public void init() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
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

	@Given("^the system has no user with username \"([^\"]*)\"$")
	public void the_system_has_no_user_with_username(String username) throws Throwable {

		User user = userService.getUserByUsername(username);
		assertNull(user);

	}

	@When("^I create a user with username \"(.*?)\", password \"(.*?)\" and e-mail \"(.*?)\"$")
	public void i_create_a_user_with_username_password_and_e_mail(String username, String password, String email)
			throws Throwable {

		User user = new User(username, password, email);
		userAux = userService.createUser(user);

	}

	@Then("^the user is properly stored by the system$")
	public void the_user_is_properly_stored_by_the_system() throws Throwable {

		assertNotNull(userAux);

	}

	@Given("^I am at the Index page$")
	public void I_am_at_the_Index_page() throws Throwable {

		Go.to(IndexPage.URL);
		At.page(IndexPage.URL);

	}

	@When("^I properly fill the fields with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void I_properly_fill_the_fields_with_username_and_password(String username, String password)
			throws Throwable {

		IndexPage.fillLoginForm(username, password);

	}

	@When("^I click the login button$")
	public void I_click_the_login_button() throws Throwable {

		IndexPage.clickLoginButton();

	}

	@Then("^I'm logged in at the Home page with my \"(.*?)\" username account$")
	public void i_m_logged_in_at_the_Home_page_with_my_username_account(String username) throws Throwable {

		assertTrue(At.page(HomePage.URL));
		assertTrue(HomePage.checkIfLoggedInAtGui(username));

	}

	@Given("^I'm at the Sign Up Page$")
	public void i_m_at_the_Sign_Up_Page() throws Throwable {
		Go.to(SignUpPage.URL);
		At.page(SignUpPage.URL);
	}

	@When("^I fill the Sign Up form with username \"(.*?)\", password \"(.*?)\", password confirmation \"(.*?)\" and email \"(.*?)\"$")
	public void i_fill_the_Sign_Up_form_with_username_password_password_confirmation_and_email(String username,
			String pass1, String pass2, String email) throws Throwable {
		SignUpPage.fillSignUpForm(username, pass1, pass2, email);
	}

	@When("^I click the Create account button$")
	public void i_click_the_Create_account_button() throws Throwable {
		SignUpPage.clickCreateAccountButton();
	}

	@Then("^a message indicating the user was successfully registered is displayed$")
	public void a_message_indicating_the_user_was_successfully_registered_is_displayed() throws Throwable {
		assertTrue(SignUpPage.checkSuccessfullyCreatedMsg());
	}

	@Then("^a message indicating the username already exists is displayed$")
	public void a_message_indicating_the_username_already_exists_is_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(SignUpPage.checkUsernameExistsMsg());
	}

	@Then("^a message indicating the passwords don't match is displayed$")
	public void a_message_indicating_the_passwords_don_t_match_is_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(SignUpPage.checkNonMatchingPasswordsMsg());
	}

	@Then("^a message indicating the email is not valid$")
	public void a_message_indicating_the_email_is_not_valid() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(SignUpPage.checkInvalidEmailMsg());
	}


	@Given("^I have an account with username \"(.*?)\" and email \"(.*?)\"$")
	public void i_have_an_account_with_username_and_email(String username, String arg2) throws Throwable {

		userAux = userService.getUserByUsername(username);
		assertNotNull(userAux);

	}
	
	@When("^I request to reset my password$")
	public void i_request_to_reset_my_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String token = UUID.randomUUID().toString();
		tokenAux = userService.createPasswordResetToken(userAux, token);
	}


	@Then("^a reset token permission is created$")
	public void a_reset_token_permission_is_created() throws Throwable {
		assertNotNull(tokenAux);
	}

	@Given("^I'm at the Reset Password Page$")
	public void i_m_at_the_Reset_Password_Page() throws Throwable {	
		Go.to(ResetPasswordPage.URL);
		At.page(ResetPasswordPage.URL);
	}

	@When("^I fill the email field with \"(.*?)\"$")
	public void i_fill_the_email_field_with(String email) throws Throwable {
		ResetPasswordPage.fillEmailfield(email);
	}
	
	@When("^I click to send email$")
	public void i_click_to_send_email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ResetPasswordPage.clickSendEmailBtn();
	}

	@Then("^a message indicating the email was sent is displayed\\.$")
	public void a_message_indicating_the_email_was_sent_is_displayed() throws Throwable {
		assertTrue(ResetPasswordPage.checkSentEmailMsg());
	}

	@When("^I fill the email field with the inexistent email \"(.*?)\"$")
	public void i_fill_the_email_field_with_the_inexistent_email(String email) throws Throwable {
		ResetPasswordPage.fillEmailfield(email);
	}

	@Then("^a message indicating the email was not found in the system is displayed$")
	public void a_message_indicating_the_email_was_not_found_in_the_system_is_displayed() throws Throwable {
		assertTrue(ResetPasswordPage.checkEmailNotFoundMsg());
	}

}
