package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase{

	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;
@BeforeMethod(description="User logs into the application and searches for a product")

public void setUp() throws InterruptedException {
	
	searchResultPage = homePage.goToLoginPage().doLoginwith("sefasid905@exoular.com", "Password").searchForProduct(SEARCH_TERM);
}



@Test(description = "Verify the logged user is able to buy a dress",
groups= {"e2e","smoke","sanity"})

public void checkoutTest() {
	String result = searchResultPage.clickOnTheProductAtIndex(0).changeSize(L).addProductToCart().proceedToCheckout().
	goToConfirmAddressPage().gotToShipmentPage().goToPaymentPage().makePaymentByWire();
	
	Assert.assertTrue(result.contains("complete"));
	
	
	
	
	
}



}