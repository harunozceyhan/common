package com.smart.common;

import com.smart.common.feign.client.SboClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;


@RestController
@RequestMapping("/")
@EnableFeignClients
public class HomeController {
	@Autowired
	private Environment env;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SboClient sboClient;

	@Value("${test.msg}")
	String value;
	
	@RequestMapping("/")
	public String homeAdmin() {
		return "Common service running at port: " + env.getProperty("local.server.port");
	}

	@RequestMapping("/config")
	public String getConsulConfig() {
		return value;
	}

	@RequestMapping("/getsbo")
	public JSONObject getSboList() {
		return restTemplate.getForObject("http://sbo-service/operations", JSONObject.class);
	}

	@RequestMapping("/getsbo-feign")
	public JSONObject getSboListFeign() {
		return sboClient.operations();
	}

	@RequestMapping("/getsbo-home")
	public String getSboHome() {
		return sboClient.home();
	}
	
}