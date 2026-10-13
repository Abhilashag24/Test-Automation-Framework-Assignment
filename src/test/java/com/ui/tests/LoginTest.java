package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends BaseTest{ 


	@Test(description = "Verifies if the valid user is able to login the application", groups = { "Regression", "E2E",
			"Sanity" }, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "LoginTestDataProvider", retryAnalyzer = com.ui.listeners.RetryAnalyzer.class)
	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().toLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Rek Aya");

	}

	@Test(description = "Verifies if the valid user is able to login the application", groups = { "Regression", "E2E",
			"Sanity" }, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.RetryAnalyzer.class)
	public void loginExcelTest(User user) {

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
