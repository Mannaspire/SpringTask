package com.example.demo.reset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Coach;

@RestController
public class DemoContoller { 	
		
	private Coach myCoach;

	@Autowired
	public DemoContoller(Coach theCoach) {
		myCoach = theCoach;
	}
	
	@GetMapping("/CricketCoach")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
