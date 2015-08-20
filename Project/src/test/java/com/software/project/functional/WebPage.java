package com.software.project.functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class WebPage {
	
	
	private static final String APP_NAME = "project";
	private static final String SERVER_URL ="http://localhost:8080/";
	public static final String BASE_APP_URL = SERVER_URL + APP_NAME +"/";
	
	public  WebDriver driver;

	public WebPage(WebDriver driver){ 
        this.driver = driver;
    }

}
