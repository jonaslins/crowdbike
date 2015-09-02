package com.software.project.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetPasswordPage extends WebPage {

	public static final String URL = BASE_APP_URL + "pages/user/resetPassword/resetPassword.jsf";
	
	public ResetPasswordPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id="form:email")
	private static WebElement emailInput;
	
	@FindBy(id="form:messages")
	private static WebElement messages;
	
	@FindBy(id="form:sendPasswordResetTokentBtn")
	private static WebElement emailBtn;
	
	
	private final static String messagesId = "form:messages";
	private final static String emailMsgId = "form:emailMsg";


	public static boolean checkSentEmailMsg() {
		return messageContains(messagesId, "Check your email inbox");
	}

	public static boolean checkEmailNotFoundMsg() {
		return messageContains(messagesId, "User e-mail not found");
	}

	public static void fillEmailfield(String email) {
		emailInput.sendKeys(email);		
	}


	public static void clickSendEmailBtn() {
		emailBtn.click();		
	}
	
	
}