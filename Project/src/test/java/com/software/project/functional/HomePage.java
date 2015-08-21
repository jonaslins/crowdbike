package com.software.project.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends WebPage {

	public static final String URL = BASE_APP_URL + "pages/home.jsf";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	//TODO
	private WebElement usernameLabel;

	public boolean loggedIn() {
		return true;		
	}
	
	
	
	
}