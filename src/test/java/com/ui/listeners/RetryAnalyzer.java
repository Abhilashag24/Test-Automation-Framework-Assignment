package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ui.util.PropertiesUtililty;

public class RetryAnalyzer implements IRetryAnalyzer {

	private static final int MAX_NO_OF_ATTEMPTS = Integer
			.parseInt(PropertiesUtililty.getProperty("MAX_NO_OF_ATTEMPTS"));
	private static int currentAttempt = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (currentAttempt <= MAX_NO_OF_ATTEMPTS) {
			currentAttempt++;

			return true;
		}
		return false;
	}

}
