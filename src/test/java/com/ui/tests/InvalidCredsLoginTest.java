package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListener.class)
public class InvalidCredsLoginTest extends BaseTest {

	private static final String INVALID_EMAIL_ADDRESS = "abc@abc.com";
	private static final String INVALID_PASSWORD = "QWERTY123";

	@Test(description = "Verifies if the error message is shown fro the user when they enter invalid credentials", groups = {
			"Regression", "E2E", "Sanity" })
	public void loginTest() {

		assertEquals(homePage.goToLoginPage().toLoginWithInvalidCreds(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.");

	}

	@Test(description = "Verifies if the valid user is able to login the application", groups = { "Regression", "E2E",
			"Sanity" }, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.RetryAnalyzer.class)
	public void logiclearnExcelTest(User user) {

		assertEquals(homePage.goToLoginPage().toLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Rek Aya");

	}

	@Test(description = "Verifies if the valid user is able to login the application", groups = { "Regression", "E2E",
			"Sanity" }, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider", retryAnalyzer = com.ui.listeners.RetryAnalyzer.class)
	public void loginCSVTest(User user) {

		assertEquals(homePage.goToLoginPage().toLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Rek Aya");

	}

}
