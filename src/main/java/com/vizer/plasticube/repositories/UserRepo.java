package com.vizer.plasticube.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vizer.plasticube.entities.User;


public interface UserRepo extends JpaRepository<User,Long>{
	User getByUsername(String userName);
	User getById(Integer id);
	List<User>  findUserByRoleId(Integer id);
}