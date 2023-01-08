package com.example.demo;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class invoice {
	public invoice() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	
	@Column(name = "userFK")
	private Integer userFK;
	
	private Integer customerFK;
	
	
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
}
