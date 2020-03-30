package org.cap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//@GetMapping("/greet")
public class MyRestController {

	//@GetMapping("/greet")
	@RequestMapping(value = "/greet",method = RequestMethod.GET)
	public String greetUser() {
		return "Hello! Good Morning!";
	}
	
}
