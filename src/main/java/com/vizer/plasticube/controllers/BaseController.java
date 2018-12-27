package com.vizer.plasticube.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
	
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/plasticube", method = RequestMethod.GET)
    public String plasticube(Model model) {
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

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
    	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	    if (auth != null){    
    	        new SecurityContextLogoutHandler().logout(request, response, auth);
    	    }
        return "logout";
    }
    
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
    	
        return "error";
    }
}