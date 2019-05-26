package com.target.retailservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
	@JsonIgnore
	private ObjectId id;
	
	@Id
	@JsonProperty(value="id")
	private String productId;
	
	@JsonProperty(value="name")
	private String name;
	
	@JsonProperty(value="current_price")
	private Price price;
	
	public Product() {}
	

	public Product(String id) {
		this.productId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=").append(id).append(", productId=").append(productId).append(", name=")
				.append(name).append(", price=").append(price).append("]");
		return builder.toString();
	}
}
