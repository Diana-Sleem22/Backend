package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "products")
public class products {
	public products () {
		
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String barcode;
	private Integer quantity;
	private Integer price;
	private Integer companyFK;
	private Integer categoryFK;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
	public Integer getCompanyFK() {
		return companyFK;
	}
	public void setCompanyFK(Integer companyFK) {
		this.companyFK = companyFK;
	}
	public Integer getCategoryFK() {
		return categoryFK;
	}
	public void setCategoryFK(Integer categoryFK) {
		this.categoryFK = categoryFK;
	}
}
