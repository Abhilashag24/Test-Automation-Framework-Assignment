package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends BaseTest {

	private static final String SEARCHED_TEXT = "Printed Summer Dress";
	private SearchResultPage searchResultPage;

	@BeforeMethod(description = "User logs in the application and searched for the product")
	public void setUp() {

		searchResultPage = homePage.goToLoginPage().toLoginWith("rekeya3175@hudzer.com", "Admin123")
				.searchProduct(SEARCHED_TEXT);
	}

	@Test(description = "Verify if logged in user is able to buy a dress", groups = { "E2E", "Sanity" })
	public void checkoutTest() {

		String paymentText=searchResultPage.clickOnTheProductAt(0).addToCart().proceedToShoppingCartSummary().proceedToAddressCheckout()
				.processAddress().checkTermsAndConditions().proceedToPayment().getAlertText();
		System.out.println(paymentText);
		Assert.assertEquals(paymentText, "No payment modules have been installed.");
	}

}
