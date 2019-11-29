package com.bankapp.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping(path="accessdenied")
	public String accessdenied(){
		return "403";
	}
	
	@GetMapping(path="mylogin")
	public String login(){
		return "loginpage";
	}
	
	@GetMapping(path="admin")
	public String helloAdmin(){
		return "admin_home";
	}
	
	@GetMapping(path="clerk")
	public String helloClerk(Principal principal){
		if(principal!=null)
			System.out.println("------------------------------");
			System.out.println(principal.getName());
			System.out.println("------------------------------");
		
		return "clerk_home";
	}
	
	@GetMapping(path="mgr")
	public String helloMgr(){
		return "mgr_home";
	}
	
	@GetMapping(path="/")
	public String index(){
		return "redirect:/home";
	}
	
	@GetMapping(path="home")
	public String hello(){
		return "home";
	}
	

}
