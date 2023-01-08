package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "exchangeRateCurrency")
public class exchangeRate {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer exchangeRateValue;
public exchangeRate() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getExchangeRateValue() {
		return exchangeRateValue;
	}
	public void setExchangeRateValue(Integer exchangeRateValue) {
		this.exchangeRateValue = exchangeRateValue;
	}
	
}
