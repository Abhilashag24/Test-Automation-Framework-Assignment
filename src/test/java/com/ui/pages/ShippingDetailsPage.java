package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.util.BrowserUtility;

public class ShippingDetailsPage extends BrowserUtility {

	private static final By TERMS_CHECKBOX_LOCATOR = By.xpath("//div[@id ='uniform-cgv']");
	private static final By PROCESS_ADDRESS_BUTTON_LOCATOR = By.xpath("//button[@name='processCarrier']");


	
	public ShippingDetailsPage(WebDriver driver) {
		super(driver);
		
	}

	public ShippingDetailsPage checkTermsAndConditions() {
		clickOn(TERMS_CHECKBOX_LOCATOR);
		return new ShippingDetailsPage(getDriver());
	}
	
	public PaymentPage proceedToPayment() {
		clickOn(PROCESS_ADDRESS_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}
	
}
