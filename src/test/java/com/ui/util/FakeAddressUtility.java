package com.ui.util;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {

	public static AddressPOJO getFakeAddress() {

		Faker faker = new Faker(Locale.US);

		AddressPOJO addressPOJO = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetAddress(), faker.address().cityName(), "78451",
				faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "Other Information", "Home Address",
				faker.address().state());

		return addressPOJO;
	}
}
