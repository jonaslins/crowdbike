package com.software.project.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends WebPage {

	public static final String URL = BASE_APP_URL + "pages/signup/";
	
	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="form:username")
	private static WebElement usernameInput;
	
	@FindBy(id="form:password")
	private static WebElement passwordInput;
	
	@FindBy(id="form:email")
	private static WebElement emailInput;
	
	@FindBy(id="form:confirmPassword")
	private static WebElement confirmPasswordInput;
	
	@FindBy(id="form:createAccountBtn")
	private static WebElement createAccountBtn;
	
	@FindBy(id="form:messages")
	private static WebElement messages;
	
	
	private final static String messagesId = "form:messages";
	private final static String passMsgId = "form:passMsg";
	private final static String emailMsgId = "form:emailMsg";
	
	
	public static void fillSignUpForm(String username, String pass1, String pass2, String email) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(pass1);
		confirmPasswordInput.sendKeys(pass2);
		emailInput.sendKeys(email);
	}
	
	public static void clickCreateAccountButton(){
		createAccountBtn.click();
	}
	
	private static boolean messageContains(String elementId, String message){
		WebElement messagesEl = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id(elementId)));
		return messagesEl.getText().contains(message);
	}
	
	
	public static boolean checkSuccessfullyCreatedMsg() {
		messages = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(messages));
		return messages.getText().contains("Welcome");
	}

	public static boolean checkUsernameExistsMsg() {
		
		return messageContains(messagesId, "Username already exists");
	}

	public static boolean checkNonMatchingPasswordsMsg() {
		return messageContains(passMsgId, "Password should match");
	}

	public static boolean checkInvalidEmailMsg() {
		return messageContains(emailMsgId, "Invalid e-mail");
	}
	
	
}