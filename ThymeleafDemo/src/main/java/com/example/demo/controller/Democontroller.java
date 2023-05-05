package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class Democontroller {

	@GetMapping("/hello")
	public String sayhello(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());
		
		return "api/hello";
	}
}
