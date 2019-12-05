package com.smart.common.feign.fallback;

import com.smart.common.feign.client.SboClient;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import net.minidev.json.JSONObject;

@Component
public class SboClientFallbackFactory implements FallbackFactory<SboClient> {
	@Override
	public SboClient create(Throwable cause) {
		return new SboClient() {
            @Override
			public String home() {
				return new String();
			}
			@Override
			public JSONObject operations() {
                JSONObject responseJson = new JSONObject();
                responseJson.put("operationStatus", false);
                responseJson.put("message", cause.getMessage());
                responseJson.put("getLocalizedMessage", cause.getLocalizedMessage());
				return responseJson;
			}
		};
	}
}