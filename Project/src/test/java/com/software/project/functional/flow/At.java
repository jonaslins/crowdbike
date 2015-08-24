package com.software.project.functional.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.software.project.functional.WebPage;

public class At {

	private static WebDriver driver;

	public static void setDriver(WebDriver driver) {
		
		At.driver = driver;
		
	}

	public static boolean page(String URL) {

		(new WebDriverWait(driver, 5)).until(ExpectedConditions.urlToBe(URL));

		return driver.getCurrentUrl().equals(URL);
	}

}
