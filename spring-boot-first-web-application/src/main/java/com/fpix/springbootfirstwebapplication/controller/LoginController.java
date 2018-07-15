package com.fpix.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fpix.springbootfirstwebapplication.service.LoginService;
@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(method=RequestMethod.GET ,value="/login")
	public String helloMsg() {
		return "login";
	}
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public String welcomeMsg(@RequestParam String name,@RequestParam String password,ModelMap model) {
		if(!loginService.loginValidation(name,password)) {
			model.put("error", "buddy enter correct input");
			return "login";
		}
		model.put("name", name);
		return "welcome";
	}
	 
}
