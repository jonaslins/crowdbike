package com.software.project.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends WebPage {

	public static final String URL = BASE_APP_URL + "pages/admin/adminPage.jsf";
	
	public AdminPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="accordPanel:legendForm:singleDT:addLegend")
	private static WebElement addLegendBtn;	
	
	@FindBy(id="addLegendForm:name")
	private static WebElement legendNameInput;
	
	@FindBy(id="addLegendForm:addBtn")
	private static WebElement createLegendBtn;
	
	private final static String legendMessagesId = "addLegendForm:message_container";

	public static void clickAddLegendBtn() {
		addLegendBtn.click();
	}
	
	public static void fillLegendForm(String name){
		legendNameInput.sendKeys(name);
	}

	public static void clickCreateLegendBtn() {
		createLegendBtn.click();
	}

	public static boolean checkSuccessfullyCreatedMsg() {
		return messageContains(legendMessagesId, "Operação realizada com sucesso");
	}
	
}