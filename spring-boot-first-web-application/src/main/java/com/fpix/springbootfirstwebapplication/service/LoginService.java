package com.fpix.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean loginValidation(String uName,String passWord) {
		return uName.equalsIgnoreCase("mani")&&passWord.equalsIgnoreCase("deep");
	}
	
}
