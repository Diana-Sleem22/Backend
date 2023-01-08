package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "products_suppliers")
public class productsSuppliers {
	
	private Integer productFK;
	private Integer userFK;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Override
	public String toString() {
		return "{\"productFK\":" + productFK + ", \"userFK\":" + userFK + "}";
	}
	public Integer getProductFK() {
		return productFK;
	}
	public void setProductFK(Integer productFK) {
		this.productFK = productFK;
	}
	public Integer getUserFK() {
		return userFK;
	}
	public void setUserFK(Integer userFK) {
		this.userFK = userFK;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
