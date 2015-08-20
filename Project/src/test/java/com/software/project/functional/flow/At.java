package com.software.project.functional.flow;

import org.openqa.selenium.WebDriver;

import com.software.project.functional.WebPage;

public class At {

	private static WebDriver driver;

	public static void setDriver(WebDriver driver) {
		At.driver = driver;
	}

	public static boolean page(String URL) {
		return driver.getCurrentUrl().equals(URL);
	}

}
