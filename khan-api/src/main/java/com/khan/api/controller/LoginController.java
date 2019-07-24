package com.khan.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@GetMapping("/product/{id}")
	public String getProduct(@PathVariable String id) {
		return "product id : " + id;
	}

	@GetMapping("/order/{id}")
	public String getOrder(@PathVariable String id) {
		return "order id : " + id;
	}

}
