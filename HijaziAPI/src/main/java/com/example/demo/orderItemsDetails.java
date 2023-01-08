package com.example.demo;

public class orderItemsDetails {
	private Integer quantity;
	private Integer price;
	private String name;

	public orderItemsDetails(Integer quantity, Integer price, String name) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{\"productName\":\"" + name + "\", \"quantity\":" + quantity + ", \"price\":" + price + "}";
	}
}
