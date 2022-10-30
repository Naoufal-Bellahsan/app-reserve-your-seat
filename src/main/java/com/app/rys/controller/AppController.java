package com.app.rys.controller;


import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@RequestMapping("/")
	String hellow() {
		return "Hello World!";
	}
	
	

}
