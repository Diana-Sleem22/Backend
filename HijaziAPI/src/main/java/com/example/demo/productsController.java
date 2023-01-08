package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@RestController
public class productsController {
	@Autowired
	private productsRepository repository;
	
	@Autowired
	private productsRepository2 repository2;

	@Autowired
	private productsSuppliersRepository productSuppliersrepository;

	@PostMapping("/registerProduct")
	public JSONArray registration(@RequestBody products productsDto) {
		JSONObject json = new JSONObject();
		JSONArray ja = new JSONArray();
		products p = new products(productsDto.getName(), productsDto.getBarcode(), productsDto.getQuantity(),
				productsDto.getPrice(), productsDto.getCompanyFK(), productsDto.getCategoryFK());
		List<Object[]> list = repository.searchProductsByExactBarCode(productsDto.getBarcode());
		if (list.size() == 0) {
			repository.addProduct(productsDto.getBarcode(), productsDto.getName(), productsDto.getPrice() + "",
					productsDto.getQuantity() + "", productsDto.getCompanyFK() + "", productsDto.getCategoryFK() + "");
			Integer id = repository.getLastInsertId();
			p.setId(id);
			json.put("responseCode", Response.SC_CREATED);
			json.put("product", p);

		} else {
			json.put("responseCode", Response.SC_FOUND);
		}
		ja.add(json);

		return ja;

	}

	@PostMapping("/registerProductSupplier")
	public JSONArray registerProductSupplier(@RequestBody productsSuppliers productsSuppliersDto) {
		productSuppliersrepository.save(productsSuppliersDto);
		JSONArray ja = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("responseCode", Response.SC_CREATED);
		json.put("product", productsSuppliersDto);
		ja.add(json);

		return ja;

	}

	@GetMapping("/getAllProducts")
	public List<products> getAllProducts() {
		List<products> list = new ArrayList<products>();
		List<Object[]> list2 = repository.getAllProducts();
		for (int i = 0; i < list2.size(); i++) {
			list.add(new products(Integer.parseInt(list2.get(i)[0] + ""), list2.get(i)[1] + "", list2.get(i)[2] + "",
					Integer.parseInt(list2.get(i)[3] + ""), Integer.parseInt(list2.get(i)[4] + ""),
					Integer.parseInt(list2.get(i)[5] + ""), Integer.parseInt(list2.get(i)[6] + ""),
					Integer.parseInt(list2.get(i)[7] + "")));

		}
		return list;

	}

	@PutMapping("/updateProduct")
	private int update(@RequestBody products productsDto) {
		repository.updateProduct(productsDto.getId(), productsDto.getQuantity(), productsDto.getPrice());
		return Response.SC_CREATED;
	}

	@PutMapping("/updateProducts")
	private List<products2> update(@RequestBody List<products2> productsDto) {
		List<products2> pList = new ArrayList<products2>();
		for (int i = 0; i < productsDto.size(); i++) {
			pList.add(new products2(productsDto.get(i).getId(), productsDto.get(i).getName(),
					productsDto.get(i).getBarcode(), productsDto.get(i).getQuantity(), productsDto.get(i).getPrice(),
					productsDto.get(i).getCompanyFK(), productsDto.get(i).getCategoryFK()));
		}
		repository2.saveAll(pList);
		return productsDto;
	}

	@DeleteMapping("/deleteProduct/{id}")
	private void deleteProduct(@PathVariable("id") int productid) {
		repository.deleteById(productid);
	}

	@GetMapping("/searchProducts/{name}")
	public List<products> searchProducts(@PathVariable("name") String productName) {
		List<products> products = null;
		if (productName != null) {

			List<products> list = new ArrayList<products>();
			List<Object[]> list2 = repository.searchProducts("%" + productName + "%");
			for (int i = 0; i < list2.size(); i++) {
				list.add(new products(Integer.parseInt(list2.get(i)[0] + ""), list2.get(i)[1] + "",
						list2.get(i)[2] + "", Integer.parseInt(list2.get(i)[3] + ""),
						Integer.parseInt(list2.get(i)[4] + ""), Integer.parseInt(list2.get(i)[5] + ""),
						Integer.parseInt(list2.get(i)[6] + ""), Integer.parseInt(list2.get(i)[7] + "")));

			}
			return list;
		}

		return products;
	}

	@GetMapping("/searchProductsByBarCode/{barcode}")
	public List<products> searchProductsByBarCode(@PathVariable("barcode") String barcode) {
		List<products> products = null;
		if (barcode != null) {
			List<products> list = new ArrayList<products>();
			List<Object[]> list2 = repository.searchProductsByBarCode(barcode);
			for (int i = 0; i < list2.size(); i++) {
				list.add(new products(Integer.parseInt(list2.get(i)[0] + ""), list2.get(i)[1] + "",
						list2.get(i)[2] + "", Integer.parseInt(list2.get(i)[3] + ""),
						Integer.parseInt(list2.get(i)[4] + ""), Integer.parseInt(list2.get(i)[5] + ""),
						Integer.parseInt(list2.get(i)[6] + ""), Integer.parseInt(list2.get(i)[7] + "")));

			}
			return list;

		}

		return products;
	}
}
