package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class uniqueOrderItems {

	public uniqueOrderItems() {

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer productFK;
	private Integer product_quantity;
	private Integer orderFK;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductFK() {
		return productFK;
	}

	public void setProductFK(Integer productFK) {
		this.productFK = productFK;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Integer getOrderFK() {
		return orderFK;
	}

	public void setOrderFK(Integer orderFK) {
		this.orderFK = orderFK;
	}

	@Override
	public String toString() {
		return "{\"productFK\":" + productFK + ", \"product_quantity\":" + product_quantity + ", \"orderFK\":" + orderFK
				+ "}";
	}
}
