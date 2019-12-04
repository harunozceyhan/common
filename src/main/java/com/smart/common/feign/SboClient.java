package com.smart.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import net.minidev.json.JSONObject;

@FeignClient(name = "sbo-service")
public interface SboClient {

    @GetMapping("/")
    String home();

    @GetMapping("/operations")
    JSONObject operations();

}