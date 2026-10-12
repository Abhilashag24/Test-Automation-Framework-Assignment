package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.util.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility {

	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@name='Submit']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR =By.xpath("//a[@title='Proceed to checkout']");
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ProductDetailsPage addToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailsPage(getDriver());
	}

	public ShoppingCartSummaryPage proceedToShoppingCartSummary() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShoppingCartSummaryPage(getDriver());
	}
}
