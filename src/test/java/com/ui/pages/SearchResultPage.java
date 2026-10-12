package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.util.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT_ITEMS_LOCATOR = By.xpath("//h5[@itemprop='name']/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchedResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

	public boolean isSearchedTextPresentInProductList(String searchedText) {
		List<String> keywords = Arrays.asList(searchedText.toLowerCase().split(" "));
		List<String> productNamesList = getAllVisibleText(ALL_PRODUCT_ITEMS_LOCATOR);
		boolean result = productNamesList.stream()
				.anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
	}

	public ProductDetailsPage clickOnTheProductAt(int index) {
		clickOn(getAllElements(ALL_PRODUCT_ITEMS_LOCATOR).get(index));
		return new ProductDetailsPage(getDriver());
	}
}
