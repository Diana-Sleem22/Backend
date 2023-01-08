package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.connector.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class orderItemsController {
	@Autowired
	private orderItemsRepository repository;

	@PostMapping("/registerOrderItems")
	@Transactional
	public JSONArray registration(@RequestBody List<uniqueOrderItems> items) {
		repository.saveAll(items);
		JSONObject json = new JSONObject();
		json.put("responseCode", Response.SC_CREATED);
		json.put("orderItems", items);
		JSONArray ja = new JSONArray();
		ja.add(json);
		return ja;

	}

	@GetMapping("/getOrderItems/{orderID}")
	public List<orderItemsDetails> getOrders(@PathVariable("orderID") int orderID) {
		List<orderItemsDetails> list = new ArrayList<orderItemsDetails>();
		List<Object[]> list2 = repository.getOrderItems(orderID);
		for (int i = 0; i < list2.size(); i++) {
			list.add(new orderItemsDetails(Integer.parseInt(list2.get(i)[0] + ""),
					Integer.parseInt(list2.get(i)[1] + ""), list2.get(i)[2] + ""));

		}
		return list;

	}

}
