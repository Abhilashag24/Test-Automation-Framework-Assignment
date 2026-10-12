package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.util.BrowserUtility;

public class ShoppingCartSummaryPage extends BrowserUtility{

	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR =By.xpath("//p/a[@title='Proceed to checkout']");
	


	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public ConfirmAddressPage proceedToAddressCheckout() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ConfirmAddressPage(getDriver());
	}
	
}
