package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface rolesPermissionsRepository extends JpaRepository<Role, Integer> {
	@Query("SELECT ar.name FROM AccessRight ar JOIN RolePermission rp ON ar.id = rp.accessRightFK WHERE rp.roleFK = :roleId")
	List<String> findAccessRightsByRoleId(@Param("roleId") Integer roleId);
}
