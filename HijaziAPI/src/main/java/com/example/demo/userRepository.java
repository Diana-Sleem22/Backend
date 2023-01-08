package com.example.demo;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user, Integer> {
	@Query("SELECT u FROM user u where u.email = :email AND u.password = :password AND u.roleFK = :roleFK")
	List<user> loginUser(@Param("email") String email, @Param("password") String password,
			@Param("roleFK") Integer roleFK);

	@Query("SELECT u FROM user u WHERE u.roleFK =2")
	List<user> getAllSuppliers();

	@Query("SELECT u FROM user u WHERE u.roleFK =4")
	List<user> getAllCustomers();

	@Query("SELECT u FROM user u WHERE u.firstname LIKE :firstname AND u.roleFK = 4")
	List<user> searchCustomer(@Param("firstname") String firstname);

	@Query("SELECT u FROM user u WHERE u.firstname LIKE :firstname AND u.roleFK = 2")
	List<user> searchSupplier(@Param("firstname") String firstname);

//  List<user> findByfirstnameLike(String firstname);
	@Query("SELECT u FROM user u WHERE u.phoneNumber = :phoneNumber and u.roleFK =4")
	List<user> getSuppliersByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	@Query("SELECT u FROM user u WHERE u.phoneNumber = :phoneNumber and u.roleFK =2")
	List<user> getCustomerByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	@Query("SELECT u FROM user u WHERE u.email = :email and u.roleFK =3")
	List<user> getSellerByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM user u WHERE u.email = :email and u.roleFK =1")
	List<user> getAdminByEmail(@Param("email") String email);


}
