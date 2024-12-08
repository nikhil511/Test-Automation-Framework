package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTestOLD {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		HomePage homepage = new HomePage(driver);
		
		LoginPage loginpage = homepage.goToLoginPage();
		loginpage.doLoginwith("sefasid905@exoular.com", "Password");
		
		//driver.quit();

	}

}
