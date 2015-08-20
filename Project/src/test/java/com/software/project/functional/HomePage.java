package com.software.project.functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends WebPage {

	public static final String URL = BASE_APP_URL + "";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="form:loginLink")
	private WebElement loginButton;

	public void clickLoginButton() {
		loginButton.click();
	}
}