package com.spring.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author lrz
 *
 */
@Controller
@RequestMapping("user")
public class UserControler {
	
	@RequestMapping(value = "login", method = {RequestMethod.GET})
	public String login(){
		System.out.println("this is my test");
		return "";
	}
}
