package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.util.BrowserUtility;
import com.ui.util.LambdaTestUtility;
import com.ui.util.LoggerUtility;

public class BaseTest {

	protected HomePage homePage;
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest; 
	
	@Parameters({"browser", "isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Load the HomePage of the website")
	public void setUp(@Optional("CHROME") String browser,
			@Optional ("false") boolean isLambdaTest,
			@Optional ("false") boolean isHeadless,ITestResult result) {
		
		this.isLambdaTest=isLambdaTest;
		WebDriver LambdaDriver;
		if (isLambdaTest) {

			LambdaDriver =	LambdaTestUtility.initializeLabmdaTestSession(result.getMethod().getMethodName(), browser);
		homePage = new HomePage(LambdaDriver);
		
		} else {
			logger.info("Loading the HomePage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}
	
	/*
	 * @AfterMethod(description = "Teasr dowm the browser") public void tearDown() {
	 * if(isLambdaTest) { LambdaTestUtility.quitSession(); }else { homePage.quit();
	 * } }
	 */

}
