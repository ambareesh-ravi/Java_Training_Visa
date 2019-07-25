package com.visa.prj.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	@GetMapping(value = "/greet")
	public String greet() {
		return "Good Day";
	}
}
