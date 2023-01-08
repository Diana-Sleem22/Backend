package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface invoiceAndOrderRepository extends JpaRepository<orders, Integer> {
	@Query("SELECT o.id, i.date, u.firstname, u.lastname, c.firstname, c.lastname FROM orders o INNER JOIN invoiceAndOrder i ON o.invoiceFK = i.id INNER JOIN user u ON i.userFK = u.id INNER JOIN user c ON i.customerFK = c.id")
	List<Object[]> findAllOrdersWithDetails();
	
	@Query("SELECT o.id, i.date, u.firstname, u.lastname, c.firstname, c.lastname FROM orders o INNER JOIN invoiceAndOrder i ON o.invoiceFK = i.id INNER JOIN user u ON i.userFK = u.id INNER JOIN user c ON i.customerFK = c.id where c.firstname LIKE %:searchText% or i.date LIKE  %:searchText%")
	List<Object[]> findAllOrdersWithDetailsAndFilter(@Param("searchText") String searchText);

	@EntityGraph(value = "Order.detail", type = EntityGraphType.LOAD)
	List<orders> findAll();
}
