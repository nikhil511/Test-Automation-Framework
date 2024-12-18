package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class SearchProductTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM="Printed Summer Dress";

	@BeforeMethod(description = "Valid user login to the application")
	public void setup() {

		myAccountPage = homePage.goToLoginPage().doLoginwith("sefasid905@exoular.com", "Password");
	}

	@Test(description = "Verify if the login user is able to Search for a product and correct products search results are displayed", groups = {
			"e2e", "sanity", "smoke" })
	public void VerifyProuductSearchTest() {

		boolean actualresult = myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualresult, true);
		
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
