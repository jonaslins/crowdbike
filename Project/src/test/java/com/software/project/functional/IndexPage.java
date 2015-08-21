package com.software.project.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends WebPage {

	public static final String URL = BASE_APP_URL + "";
	
	public IndexPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="form:loginLink")
	private WebElement loginLink;
	
	@FindBy(id="form:loginButton")
	private WebElement loginButton;
	
	@FindBy(id="form:username")
	private WebElement usernameField;
	
	@FindBy(id="form:password")
	private WebElement passwordField;

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickLoginLink() {
		loginLink.click();
	}
	
	public void fillLoginForm(String username, String password){
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
	}

	public boolean loggedIn() {
		return true;		
	}
	
	
	
	
}