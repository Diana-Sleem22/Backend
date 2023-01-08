package com.example.demo;

import org.apache.catalina.connector.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class invoiceController {
	@Autowired
	private invoiceRepository repository;
	
	@PostMapping("/registerInvoice")
    public JSONArray registration(@RequestBody invoice invoiceDto ){
		repository.save(invoiceDto);
		JSONObject json = new JSONObject();
		json.put("responseCode", Response.SC_CREATED);
		json.put("invoice", invoiceDto);
		JSONArray ja = new JSONArray();
		ja.add(json);
		return ja ;
                            
}
}
