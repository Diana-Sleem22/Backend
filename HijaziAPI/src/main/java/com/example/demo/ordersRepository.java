package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ordersRepository extends JpaRepository<orders, Integer> {

	@Modifying
	@Query(value = "INSERT INTO orders(invoiceFK) VALUES(:invoiceFK)", nativeQuery = true)
	@Transactional
	void insertOrder(@Param("invoiceFK") Integer invoiceFK);

	@Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
	Integer getLastInsertId();
}
