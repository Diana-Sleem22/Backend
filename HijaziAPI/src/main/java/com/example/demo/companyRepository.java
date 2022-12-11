package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface companyRepository extends JpaRepository<company,Integer> {
	@Query("SELECT n FROM company n where n.name LIKE 'name%'" )
    List<company> searchCompanies(@Param("name") String name);
    List<company> findByNameLike(String name);

}
