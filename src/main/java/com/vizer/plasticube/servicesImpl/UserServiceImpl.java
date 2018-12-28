package com.vizer.plasticube.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vizer.plasticube.entities.Permission;
import com.vizer.plasticube.entities.User;
import com.vizer.plasticube.repositories.PermissionRepo;
import com.vizer.plasticube.repositories.RoleRepo;
import com.vizer.plasticube.repositories.UserRepo;
import com.vizer.plasticube.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private PermissionRepo permissionRepo;

	@Override
	public List<Permission> getPermissionByUserId(Integer userId) {
		return permissionRepo.findByRoleId(userRepo.getById(userId).getRole().getId());
	}
	
	@Override
	public User getByUserName(String userName) {
		return userRepo.getByUsername(userName);
	}
	
	
	
}
