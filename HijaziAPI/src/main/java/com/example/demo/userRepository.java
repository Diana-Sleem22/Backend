package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user,Integer>  {
	@Query("SELECT u FROM user u where u.email = :email AND u.password = :password AND u.roleFK = :roleFK")
    List<user> loginUser(@Param("email") String email, @Param("password") String password , @Param("roleFK") Integer roleFK);
    @Query("SELECT u FROM user u WHERE u.roleFK =2")
    List<user> getAllSuppliers ();
    
  
}
