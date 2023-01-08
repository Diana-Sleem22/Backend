package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class invoiceAndOrderController {
	@Autowired
	private invoiceAndOrderRepository repository;

	@GetMapping("/getOrders")
	public List<orderInvoice> getOrders() {
		List<orderInvoice> list = new ArrayList<orderInvoice>();
		List<Object[]> list2 = repository.findAllOrdersWithDetails();
		for (int i = 0; i < list2.size(); i++) {
			list.add(new orderInvoice(Integer.parseInt(list2.get(i)[0] + ""), list2.get(i)[1] + "",
					list2.get(i)[2] + " " + list2.get(i)[3] + "", list2.get(i)[4] + " " + list2.get(i)[5] + ""));

		}
		return list;

	}

	@GetMapping("/getOrdersByCustomerNameOrDate/{searchText}")
	public List<orderInvoice> getOrdersByCustomerNameOrDate(@PathVariable("searchText") String searchText) {
		List<orderInvoice> list = new ArrayList<orderInvoice>();
		List<Object[]> list2 = repository.findAllOrdersWithDetailsAndFilter(searchText);
		for (int i = 0; i < list2.size(); i++) {
			list.add(new orderInvoice(Integer.parseInt(list2.get(i)[0] + ""), list2.get(i)[1] + "",
					list2.get(i)[2] + " " + list2.get(i)[3] + "", list2.get(i)[4] + " " + list2.get(i)[5] + ""));

		}
		return list;

	}

}
