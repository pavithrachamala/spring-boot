package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/allusers")
	public ModelAndView allUsers(ModelAndView mv){
		mv.addObject("accounts", userService.findAll());
		mv.setViewName("allusers");
		return mv;
	}
	
	@GetMapping("/adduser")
	public ModelAndView addUser(ModelAndView mv)
	{
		mv.addObject("addaccount", new User());
		mv.setViewName("adduser");
		return mv;
	}
	@PostMapping("/adduser")
	public String addUserPost(@ModelAttribute(name="user")User user,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "adduser";
		}
		else
		{
			userService.addUser(user);
		}
		return "redirect:allusers";
	}
	
}






