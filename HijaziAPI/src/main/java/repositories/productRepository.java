package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Products;

public interface productRepository extends JpaRepository<Products,Integer>{

}
