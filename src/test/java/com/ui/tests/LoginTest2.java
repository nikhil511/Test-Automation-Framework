package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTest2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		BrowserUtility browserutility = new BrowserUtility(driver);

		browserutility.goToWebsite("http://www.automationpractice.pl/");
		browserutility.maximizeWindow();

		By SignInLinkLocator = By.cssSelector("a.login");
		browserutility.clickOn(SignInLinkLocator);

		By emailTextBoxLocator = By.id("email");
		browserutility.enterText(emailTextBoxLocator, "sefasid905@exoular.com");

		By passwordTextBoxLocator = By.id("passwd");
		browserutility.enterText(passwordTextBoxLocator, "Password");

		By SubmitButtonLocator = By.cssSelector("a.login");
		browserutility.clickOn(SubmitButtonLocator);
		
		driver.quit();

	}

}
