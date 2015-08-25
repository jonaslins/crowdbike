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
	
	@FindBy(id="form:confirmPassword")
	private static WebElement confirmPasswordInput;
	
	@FindBy(id="form:createAccountBtn")
	private static WebElement createAccountBtn;
	
	@FindBy(id="form:messages")
	private static WebElement messages;
	
	
	
	public static void fillSignUpForm(String username, String pass1, String pass2) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(pass1);
		confirmPasswordInput.sendKeys(pass2);
	}
	
	public static void clickCreateAccountButton(){
		createAccountBtn.click();
	}

	public static boolean checkSuccessfullyCreatedMsg() {
		messages = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(messages));
		return messages.getText().contains("Welcome");
	}
	
	
	
}