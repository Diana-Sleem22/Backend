package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Products;
import services.productService;

@RestController
public class productController {
@Autowired
private productService service;
@GetMapping("/products")
public List<Products> list(){
	return service.listAll();
}

}
