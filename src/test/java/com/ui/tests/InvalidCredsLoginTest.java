package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class InvalidCredsLoginTest extends TestBase {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS= "NYIJ@SEDEEW.COM";
	private static final String INVALID_PASSWORD= "qwewrw12";
	

	
	@Test(description = "Verify if the proper error message is shown for the user when they enter invalid credentials", groups = { "e2e",
			"sanity","smoke" })
	public void loginTest() {

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage()
				,"Authentication failed.");

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
