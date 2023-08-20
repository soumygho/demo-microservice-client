package com.soumya.demo.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class TestController {
	private static final String SERVICE_URL = "http://TESTSERVICE/test/hello";
	@LoadBalanced
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/test")
	public String invoke() {
		return this.restTemplate.getForObject(SERVICE_URL, String.class);
	}
}
