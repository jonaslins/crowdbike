package com.software.project.functional.flow;

import org.openqa.selenium.WebDriver;

import com.software.project.functional.IndexPage;
import com.software.project.functional.WebPage;

public class Go {

	private static WebDriver driver;

	public static void setDriver(WebDriver driver) {
		Go.driver = driver;
	}

	public static void to(String URL) {
		driver.get(URL);
	}

}
