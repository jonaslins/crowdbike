package com.software.project.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends WebPage {

	public static final String URL = BASE_APP_URL + "pages/home.jsf";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="formMenu:username")
	private static WebElement usernameLabel;
	
	public static boolean checkIfLoggedInAtGui(String username) {
		boolean loggedInAtGui = (new WebDriverWait(driver, TIMEOUT_DEFAULT)).until(ExpectedConditions.textToBePresentInElement(usernameLabel, username));
		return loggedInAtGui;
	}
	
}