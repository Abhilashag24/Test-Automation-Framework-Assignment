package com.ui.pojo;

import org.openqa.selenium.By;

public class AddressPOJO {

	private String company;
	private String address1;
	private String address2;
	private String city;
	private String postcode;
	private String homePhoneNumber;
	private String mobilePhoneNumber;
	private String otherInformation;
	private String addressAlias;
	private String state;

	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", postcode=" + postcode + ", homePhoneNumber=" + homePhoneNumber + ", mobilePhoneNumber="
				+ mobilePhoneNumber + ", otherInformation=" + otherInformation + ", addressAlias=" + addressAlias
				+ ", state=" + state + "]";
	}

	public AddressPOJO(String company, String address1, String address2, String city, String postcode,
			String homePhoneNumber, String mobilePhoneNumber, String otherInformation, String addressAlias,
			String state) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postcode = postcode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.otherInformation = otherInformation;
		this.addressAlias = addressAlias;
		this.state = state;
	}

}
