package com.example.demo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class orderItems {
	public orderItems() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "productFK")
	private products product;

	private Integer product_quantity;
	
	@ManyToOne
	@JoinColumn(name = "orderFK")
	private orders order;

	@Column(name = "orderFK", insertable = false, updatable = false)
	private Integer orderFK;
	
	@Column(name = "productFK", insertable = false, updatable = false)
	private Integer productFK;
	
	public products getProduct() {
		return product;
	}

	public void setProduct(products product) {
		this.product = product;
	}

	public orders getOrder() {
		return order;
	}

	public void setOrder(orders order) {
		this.order = order;
	}

	public Integer getOrderFK() {
		return orderFK;
	}

	public void setOrderFK(Integer orderFK) {
		this.orderFK = orderFK;
	}

	public Integer getProductFK() {
		return productFK;
	}

	public void setProductFK(Integer productFK) {
		this.productFK = productFK;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

}
