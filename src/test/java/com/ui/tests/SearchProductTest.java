package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)
public class SearchProductTest extends BaseTest {

	private MyAccountPage myAccountPage;
	private static final String SEARCHED_TEXT = "Printed Summer Dress";

	@BeforeMethod(description = "Valid user is logged in the application")
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().toLoginWith("rekeya3175@hudzer.com", "Admin123");
		
	}

	@Test(description = "Verify if the logged in user is able to search for a product and correct product search results are displayed.", groups = {
			"E2E", "Sanity" })
	public void searchProductTest() {
		boolean actualResult = myAccountPage.searchProduct(SEARCHED_TEXT).isSearchedTextPresentInProductList(SEARCHED_TEXT);
		
	Assert.assertEquals(actualResult,true);
	}
}
