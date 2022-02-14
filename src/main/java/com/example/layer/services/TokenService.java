package com.example.layer.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.layer.model.TokenRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TokenService {

	@Value("${open.api.url}")
	private String apiUrl;

	@Value("${open.api.token}")
	private String apiToken;

	public Map<String, Object> createToken(TokenRequest tokenRequest) {

		ObjectMapper mapper = new ObjectMapper();
		String json = "";

		tokenRequest.setMtx(UUID.randomUUID().toString());

		try {
			json = mapper.writer().writeValueAsString(tokenRequest);
		} catch (JsonProcessingException e1) {

			e1.printStackTrace();
		}

		Map<String, Object> map = new HashMap<String, Object>();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).header("Accept", "application/json")
				.header("Content-Type", "application/json").header("Authorization", apiToken)
				.method("POST", HttpRequest.BodyPublishers.ofString(json)).build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response);

			map.put("statusCode", response.statusCode());
			map.put("responseBody", response.body());

		} catch (IOException e) {

			map.put("statusCode", 500);
			map.put("responseBody", "IO Exception " + e.getMessage());

		} catch (InterruptedException e) {

			map.put("statusCode", 500);
			map.put("responseBody", "Interrupted Exception " + e.getMessage());

		}

		return map;

	}

}
