package com.example.layer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenRequest {

	@JsonProperty(value = "email_id")
	private String emailId;

	@JsonProperty(value = "contact_number")
	private String contactNumber;

	@JsonProperty(value = "amount")
	private double amount;

	@JsonProperty(value = "mtx")
	private String mtx;

	@JsonProperty(value = "currency")
	private String currency;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMtx() {
		return mtx;
	}

	public void setMtx(String mtx) {
		this.mtx = mtx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
