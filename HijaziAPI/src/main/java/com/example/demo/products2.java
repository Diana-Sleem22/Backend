package com.example.demo;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "products")
public class products2 {
	public products2() {

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

	

//	public productsSuppliers getPs() {
//		return ps;
//	}
//
//	public void setPs(productsSuppliers ps) {
//		this.ps = ps;
//	}

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

	

	public products2(Integer id, String name, String barcode, Integer quantity, Integer price, Integer companyFK,
			Integer categoryFK) {
		this.id = id;
		this.name = name;
		this.barcode = barcode;
		this.quantity = quantity;
		this.price = price;
		this.companyFK = companyFK;
		this.categoryFK = categoryFK;
	}

	public products2(String name, String barcode, Integer quantity, Integer price, Integer companyFK,
			Integer categoryFK) {
		this.name = name;
		this.barcode = barcode;
		this.quantity = quantity;
		this.price = price;
		this.companyFK = companyFK;
		this.categoryFK = categoryFK;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"name\":\"" + name + "\", \"barcode\":\"" + barcode + "\", \"quantity\":" + quantity
				+ ", \"price\":" + price + ", \"companyFK\":" + companyFK + ", \"categoryFK\":" + categoryFK + "}";
	}

}
