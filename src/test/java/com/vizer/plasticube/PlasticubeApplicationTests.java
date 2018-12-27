package com.vizer.plasticube;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vizer.plasticube.entities.Permission;
import com.vizer.plasticube.entities.Role;
import com.vizer.plasticube.entities.User;
import com.vizer.plasticube.repositories.PermissionRepo;
import com.vizer.plasticube.repositories.RoleRepo;
import com.vizer.plasticube.repositories.UserRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlasticubeApplicationTests {

    @Autowired
    PermissionRepo permissionRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    UserRepo userRepo;
    
    
	@Test
	public void contextLoads() {
		// 
//		User user = userRepo.getByUsername("vizer");
//		Role role = roleRepo.getByName("admin");
		
		//List<Permission> permission = permissionRepo.getByRoleId(0);

		//List<Role> roles = roleRepo.findByUsersId(1);
		
		//System.out.println("##1##########"+roles.toString());
		
		//roles = roleRepo.findByUsersId(2);
		
		//System.out.println("##2##########"+roles.toString());

//		List<User> userss = userRepo.findUserByRoleId(0);
//		
//		System.out.println("##3##########"+userss.toString());
//
//		userss = userRepo.findUserByRoleId(1);
//		
//		System.out.println("##4##########"+userss.toString());
//		
//		userss = userRepo.findUserByRoleId(1);
//		List<Permission> lp = permissionRepo.findByRoleId(1);
//		System.out.println("##5##########"+lp.toString());
//		
//		Integer usersss = userRepo.getById(17).getRole().getId();
//
//		System.out.println("##6##########"+usersss.toString());
		
		System.out.println("############");
		
		
		
		//System.out.println(role.toString());

		
		//System.out.println(permission.toString());
	}
	
	
	
	
}

