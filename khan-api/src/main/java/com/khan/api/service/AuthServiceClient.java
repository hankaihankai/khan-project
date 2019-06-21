package com.khan.api.service;

import com.khan.api.entity.JWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value = "zuul",fallback = AuthServiceClient.AuthServiceHystrix.class )
public interface AuthServiceClient {

	@PostMapping(value = "/oauth/token")
	JWT getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type,
				 @RequestParam("username") String username, @RequestParam("password") String password);

	@Service
	class AuthServiceHystrix implements AuthServiceClient {

		@Override
		public JWT getToken(String authorization, String type, String username, String password) {
			return null;
		}
	}
}
