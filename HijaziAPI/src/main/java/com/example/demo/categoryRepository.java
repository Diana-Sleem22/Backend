package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface categoryRepository extends JpaRepository<category,Integer>{
	@Query("SELECT n FROM products n where n.name LIKE 'name%'" )
    List<category> searchCategories(@Param("name") String name);
    List<category> findByNameLike(String name);
}
