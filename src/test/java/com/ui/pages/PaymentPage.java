package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.util.BrowserUtility;

public class PaymentPage extends BrowserUtility {

	private static final By PAYMENT_ALERT_TEXT_LOCATOR = By.xpath("//p[@class='alert alert-warning']");

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public String getAlertText() {
		return getVisibleText(PAYMENT_ALERT_TEXT_LOCATOR);
	}
}
