package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
@Listeners(com.ui.listeners.TestListener.class)
public class LoginWithCSVTest extends BaseTest{
	private HomePage homePage;

	@BeforeMethod(description = "Load the HomePage of the website")
	public void setUp() {
		homePage = new HomePage(Browser.CHROME,true);
	}

	@Test(description = "Verifies if the valid user is able to login the application", groups = { "Regression", "E2E",
			"Sanity" }, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "LoginTestDataProvider", retryAnalyzer = com.ui.listeners.RetryAnalyzer.class)
	public void loginTest(User user) {

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
