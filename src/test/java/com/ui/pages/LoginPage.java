package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email']");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin"); 
	private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,'alert alert-danger')]/ol/li");
	

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public MyAccountPage doLoginwith(String emailAddress,String password ) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
		
	}
	
	public LoginPage doLoginWithInvalidCredentials(String emailAddress,String password ) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
		
	}
	public String getErrorMessage() {
		return getVisibleText(ERROR_MESSAGE_LOCATOR);
		
	}
	
	

}
