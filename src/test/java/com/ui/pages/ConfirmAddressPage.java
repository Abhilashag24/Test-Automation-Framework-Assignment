package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.util.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility {
	private static final By PROCESS_ADDRESS_BUTTON_LOCATOR = By.xpath("//button[@name='processAddress']");

	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
		}
	
	public ShippingDetailsPage processAddress() {
		clickOn(PROCESS_ADDRESS_BUTTON_LOCATOR);
		return new ShippingDetailsPage(getDriver());
	}

}
