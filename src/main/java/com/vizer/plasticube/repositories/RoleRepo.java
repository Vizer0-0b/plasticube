package com.vizer.plasticube.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vizer.plasticube.entities.Role;

public interface RoleRepo extends JpaRepository<Role,Long>{
	Role getByName(String name);
	List<Role> findByUserId(Integer id);
}