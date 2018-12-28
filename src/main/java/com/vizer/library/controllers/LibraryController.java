package com.vizer.library.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LibraryController {
	
	public static String component="library";
    
    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String booklist(Model model) {
    	
    	String username;
    	
    	SecurityContext securityContext = SecurityContextHolder.getContext();

    	Authentication authentication = securityContext.getAuthentication();

    	Object principal = authentication.getPrincipal();
    	if (principal instanceof UserDetails) {
    		username = ((UserDetails)principal).getUsername();
    	} else {
    		username = principal.toString();
    	}
    	
    	model.addAttribute("component","plasticube/index");
    	model.addAttribute("function","test");
	    model.addAttribute("username",username.toString());
    	
    	
        return "shares/render";
    }
}