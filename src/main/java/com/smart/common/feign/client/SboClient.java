package com.smart.common.feign.client;

import com.smart.common.feign.fallback.SboClientFallbackFactory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import net.minidev.json.JSONObject;

@FeignClient(name = "sbo-service", fallbackFactory = SboClientFallbackFactory.class)
public interface SboClient {

    @GetMapping("/")
    String home();

    @GetMapping("/operations")
    JSONObject operations();

}