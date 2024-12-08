package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;

import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

import com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.cssSelector("a.login");
	
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName,isHeadless); // To call the parent class constructor from child class constructor
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
		logger.info("Home page is loading");
	}
public HomePage(WebDriver driver) {
	super(driver);
	goToWebsite(JSONUtility.readJSON(QA).getUrl());
	
}
	
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
		
		
	}
	
	
	

}
