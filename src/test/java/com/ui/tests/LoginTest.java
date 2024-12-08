package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@BeforeMethod(description = "Load the home page of the website")
	public void setup() {

		homePage = new HomePage(CHROME,true);
	}

	@Test(description = "Verifies with the valid user is able to login", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void LoginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginwith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Nik N");

	}

	/*
	 * @Test(description = "Verifies with the valid user is able to login", groups =
	 * { "e2e", "sanity" }, dataProviderClass =
	 * com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	 * "LogincsvTestDataProvider") public void LogincsvTest(User user) {
	 * 
	 * assertEquals(homePage.goToLoginPage().doLoginwith(user.getEmailAddress(),
	 * user.getPassword()).getUserName(), "Nik N"); }
	 * 
	 * @Test(description = "Verifies with the valid user is able to login", groups =
	 * { "e2e", "sanity" }, dataProviderClass =
	 * com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	 * "LoginexcelTestDataProvider", retryAnalyzer =
	 * com.ui.listeners.MyRetryAnalyzer.class) public void loginExcelTest(User user)
	 * {
	 * 
	 * assertEquals(homePage.goToLoginPage().doLoginwith(user.getEmailAddress(),
	 * user.getPassword()).getUserName(), "Nikh N");
	 * 
	 * }
	 */
}
