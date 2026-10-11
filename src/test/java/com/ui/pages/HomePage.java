package com.ui.pages;

import static com.ui.util.PropertiesUtililty.getProperty;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.ui.util.BrowserUtility;
import com.ui.util.LoggerUtility;

public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_BUTTON_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	private Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless);
		goToWebsite(getProperty("URL"));
		 

	}
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(getProperty("URL"));
		 

	}
	public LoginPage goToLoginPage() {
		logger.info("Trying to perform click to go to Sign In Page");
		clickOn(SIGN_IN_BUTTON_LOCATOR);

		return new LoginPage(getDriver());
	}
	public void quit() {
		getDriver().quit();
		
	}

}
