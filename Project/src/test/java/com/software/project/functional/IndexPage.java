package com.software.project.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage extends WebPage {

	public static final String URL = BASE_APP_URL + "";
	
	public IndexPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="form:login")
	private static WebElement loginButton;
	
	@FindBy(id="form:username")
	private static WebElement usernameField;
	
	@FindBy(id="form:password")
	private static  WebElement passwordField;

	public static void clickLoginButton() {
		loginButton.click();
	}
	
	
	public static void fillLoginForm(String username, String password){
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
	}

	public static boolean loggedIn() {
		return true;		
	}
	
}