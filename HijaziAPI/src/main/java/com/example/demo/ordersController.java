package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.connector.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ordersController {
	@Autowired
	private ordersRepository repository;

	@PostMapping("/registerOrder")
	public JSONArray registration(@RequestBody orders orderDto) {
		repository.insertOrder(orderDto.getInvoiceFK());

		Integer id = repository.getLastInsertId();
		JSONObject json = new JSONObject();
		orderDto.setId(id);
		json.put("responseCode", Response.SC_CREATED);
		json.put("order", orderDto);
		JSONArray ja = new JSONArray();
		ja.add(json);
		return ja;

	}

	@GetMapping("/getAllOrders")
	public List<orders> getProduct() {
		return repository.findAll();

	}

}