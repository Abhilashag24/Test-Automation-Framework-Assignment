package com.ui.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;
	private Logger logger = LoggerUtility.getLogger(this.getClass());

	public BrowserUtility(WebDriver driver) {
		super();
		BrowserUtility.driver.set(driver);
		wait = new WebDriverWait(BrowserUtility.driver.get(), Duration.ofSeconds(10000));

	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser : " + browserName.toString());
		switch (browserName) {
		case CHROME -> driver.set(new ChromeDriver());
		case EDGE -> driver.set(new EdgeDriver());
		case FIREFOX -> driver.set(new EdgeDriver());
		}
		wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10000));
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser : " + browserName.toString() + "in headless mode");
		switch (browserName) {
		case CHROME -> {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		}
		case EDGE -> {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
		}
		case FIREFOX -> {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}
		}
		}
		wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10000));
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
		maximizeWindow();
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser Window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Clicking the element with locator " + locator);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Entering the text " + textToEnter + " in the locator " + locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
		logger.info("Returning the visible Text " + text);
		return text;
	}

	public String takeScreenshot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File sreenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timestamp + ".png";
		System.out.println(path);
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(sreenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
