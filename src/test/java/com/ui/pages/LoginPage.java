package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.util.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By LOGIN_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By AUTH_FAILED_TEXT_LOCATOR =By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public MyAccountPage toLoginWith(String emailId, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailId);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(LOGIN_BUTTON_LOCATOR);
		return new MyAccountPage(getDriver());

	}
	public LoginPage toLoginWithInvalidCreds(String emailId, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailId);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(LOGIN_BUTTON_LOCATOR);
		return new LoginPage(getDriver());
		
	}
	public String getErrorMessage() {
		
		return getVisibleText(AUTH_FAILED_TEXT_LOCATOR);
	}

}
