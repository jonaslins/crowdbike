package com.software.project.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public abstract class WebPage {

	private static final String APP_NAME = "project";
	private static final String SERVER_URL = "http://localhost:8080/";
	public static final String BASE_APP_URL = SERVER_URL + APP_NAME + "/";

	public static WebDriver driver;

	protected WebPage(WebDriver driver) {
		WebPage.driver = driver;
	}
	
	public static boolean messageContains(String elementId, String message){
		return (new WebDriverWait(driver, 15)).until(ExpectedConditions.textToBePresentInElement(By.id(elementId), message));		
	}




}
