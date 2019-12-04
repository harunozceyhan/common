package com.smart.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private Environment env;

	@Value("${test.msg}")
	String value;
	
	@RequestMapping("/")
	public String homeAdmin() {
		return "Parameter service running at port: " + env.getProperty("local.server.port");
	}

	@RequestMapping("/config")
	public String getConsulConfig() {
		return value;
	}
}