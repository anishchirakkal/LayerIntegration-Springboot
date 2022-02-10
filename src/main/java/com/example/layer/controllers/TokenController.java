package com.example.layer.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.layer.model.TokenRequest;
import com.example.layer.services.TokenService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TokenController {

	@Autowired
	private TokenService tokenService;

	@PostMapping("/payment_token")
	public Map<String, Object> createToken(@RequestBody TokenRequest tokenRequest) {

		return tokenService.createToken(tokenRequest);

	}

}
