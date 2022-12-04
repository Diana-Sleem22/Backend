package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Products;
import repositories.productRepository;

@Service
public class productService {
@Autowired
private productRepository repo;
public List<Products> listAll(){
	return repo.findAll();
}
}
