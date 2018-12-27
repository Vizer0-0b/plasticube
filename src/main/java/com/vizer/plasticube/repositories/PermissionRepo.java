package com.vizer.plasticube.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vizer.plasticube.entities.Permission;

public interface PermissionRepo extends JpaRepository<Permission,Long>{
	List<Permission> findByRoleId(Integer id);
}