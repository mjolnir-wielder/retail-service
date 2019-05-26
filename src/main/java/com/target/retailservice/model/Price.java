package com.target.retailservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {
	
	@JsonProperty("value")
	private Double value;
	
	@JsonProperty("currency_code")
	private String currencyCode;
	
	public Price() {}
	
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Price [value=").append(value).append(", currencyCode=").append(currencyCode).append("]");
		return builder.toString();
	}
}
