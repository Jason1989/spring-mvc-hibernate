package com.jason.bookstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason.bookstore.model.User;
import com.jason.bookstore.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index.do")
	public String index(Map<String, Object> map){
		map.put("user", new User());
		return "/login";
	}
	
	@RequestMapping("/login.do")
	public String findUser(@ModelAttribute("user") User user, BindingResult result){
		User res = userService.findUser(user);
		if(res != null){
			return "/success";
		}else{
			return "/login";
		}
	}
}
