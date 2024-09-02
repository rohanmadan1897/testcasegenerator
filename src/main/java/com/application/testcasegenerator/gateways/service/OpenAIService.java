package com.application.testcasegenerator.gateways.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class OpenAIService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    private static final String OPEN_API_URL = "https://api.openai.com/v1/chat/completions";

    public String generateTestCases(String prompt){

        try {
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer " + apiKey);
            headers.set("Content-Type", "application/json");

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "gpt-4o-mini");
            requestBody.put("temperature", 0.7);

            Map<String, String> message = new HashMap<>();
            message.put("role", "user");
            message.put("content", prompt);
            requestBody.put("messages", new Map[]{message});

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);
            ResponseEntity<Map> response = restTemplate.postForEntity(OPEN_API_URL, request, Map.class);
            Map<String, Object> responseBody = response.getBody();
            if (responseBody != null && responseBody.containsKey("choices")) {
                Object content = new JSONObject(responseBody.get("choices"))
                        .getJSONObject("last")
                        .getJSONObject("message")
                        .get("content");


                return content.toString();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "Error generating test cases";
    }
}
