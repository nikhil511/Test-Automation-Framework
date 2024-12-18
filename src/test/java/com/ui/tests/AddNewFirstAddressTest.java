package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.fakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	
	private AddressPOJO address;
	
	@BeforeMethod(description = "Valid first time user logs into the application")
	public void setup() {

		myAccountPage = homePage.goToLoginPage().doLoginwith("sefasid905@exoular.com", "Password");
		address = fakeAddressUtility.getFakeAddress();
	}
	
	
@Test	
public void addNewAddress() {
	
	String  newAddress = myAccountPage.goToAddressPage().saveAddress(address);
	Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
}
}
