package com.vizer.plasticube.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vizer.plasticube.entities.Permission;
import com.vizer.plasticube.entities.User;

@Service
public interface UserService {
	List<Permission> getPermissionByUserId(Integer userId);
	User getByUserName(String userName);
}
