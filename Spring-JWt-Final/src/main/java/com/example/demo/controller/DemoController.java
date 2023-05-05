package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping("/home")
	public String home() {
		String text = "This is Private page!!";
		text += " This page is allowed to Authenticated users!!";
		return text;
	}
	
	@RequestMapping("/getuser")
	public String getuser() {
		return "{\"name\" : \"Aspire\"}";
	}
}
