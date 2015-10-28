package com.spring.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.Person;

@RequestMapping("/result")
@Controller
public class ResultControler {
	
	@RequestMapping(value = "/reponse", method = {RequestMethod.GET})
	@ResponseBody
	public Person getResponse(){
		return new Person("xxx", 24);
	}
}
