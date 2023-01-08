package com.example.demo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.catalina.User;

@Entity
@Table(name = "invoice")
public class invoiceAndOrder {

	public invoiceAndOrder() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public user getCustomer() {
		return customer;
	}

	public void setCustomer(user customer) {
		this.customer = customer;
	}

	public Integer getUserFK() {
		return userFK;
	}

	public void setUserFK(Integer userFK) {
		this.userFK = userFK;
	}

	public Integer getCustomerFK() {
		return customerFK;
	}

	public void setCustomerFK(Integer customerFK) {
		this.customerFK = customerFK;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date date;

	@ManyToOne
	@JoinColumn(name = "userFK")
	private user user;
	
	@Column(name = "userFK", insertable = false, updatable = false)
	private Integer userFK;
	
	@Column(name = "customerFK", insertable = false, updatable = false)
	private Integer customerFK;
	
	@ManyToOne
	@JoinColumn(name = "customerFK")
	private user customer;

}
