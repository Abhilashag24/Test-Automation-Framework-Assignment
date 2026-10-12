package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.ui.util.FakeAddressUtility;

public class AddNewFirstAddressTest extends BaseTest {
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO addressPOJO;

	@BeforeMethod(description = "Valid First Time user is logs in the application")

	public void setUp() {
		myAccountPage = homePage.goToLoginPage().toLoginWith("rekeya3175@hudzer.com", "Admin123");
		addressPOJO = FakeAddressUtility.getFakeAddress();
	}

	@Test
	public void addNewFirstAddress() {
	String newAddress=	myAccountPage.goToAddAddressPage().saveAddress(addressPOJO);
		Assert.assertEquals(newAddress, addressPOJO.getAddressAlias().toUpperCase());
	}

}
