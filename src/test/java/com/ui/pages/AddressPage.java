package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.ui.util.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMAPNY_TEXT_BOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXT_BOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXT_BOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXT_BOX_LOCATOR = By.id("city");
	private static final By POST_CODE_TEXT_BOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXT_BOX_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_TEXT_BOX_LOCATOR = By.id("phone_mobile");
	private static final By OTHER_INFORMATION_TEXT_AREA_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXT_BOX_LOCATOR = By.id("alias");
	private static final By STATE_DROPDOWN_LOCATOR = By.xpath("//div/select[@name='id_state']");
	private static final By SAVE_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING = By.tagName("h3");

	public AddressPage(WebDriver driver) {
		super(driver);

	}

	public String saveAddress(AddressPOJO addressPOJO) {
		enterText(COMAPNY_TEXT_BOX_LOCATOR, addressPOJO.getCompany());
		enterText(ADDRESS1_TEXT_BOX_LOCATOR, addressPOJO.getAddress1());
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, addressPOJO.getAddress2());
		enterText(CITY_TEXT_BOX_LOCATOR, addressPOJO.getCity());
		enterText(POST_CODE_TEXT_BOX_LOCATOR, addressPOJO.getPostcode());
		enterText(HOME_PHONE_TEXT_BOX_LOCATOR, addressPOJO.getHomePhoneNumber());
		enterText(MOBILE_PHONE_TEXT_BOX_LOCATOR, addressPOJO.getMobilePhoneNumber());
		enterText(OTHER_INFORMATION_TEXT_AREA_LOCATOR, addressPOJO.getOtherInformation());
		clearText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR, addressPOJO.getAddressAlias());
		selectFromDropdown(STATE_DROPDOWN_LOCATOR, addressPOJO.getState());
		clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
		return getVisibleText(ADDRESS_HEADING);
	}

}
