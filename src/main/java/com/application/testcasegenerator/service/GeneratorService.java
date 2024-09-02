package com.application.testcasegenerator.service;

import com.application.testcasegenerator.gateways.service.OpenAIService;
import com.application.testcasegenerator.models.APIInput;
import com.application.testcasegenerator.models.APITestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneratorService {

    @Autowired
    private OpenAIService openAIService;

    public List<APITestResponse> generate(APIInput apiInput){
        String prompt = generatePrompt(apiInput);

        String response = openAIService.generateTestCases(prompt);

        ObjectMapper objectMapper = new ObjectMapper();
        List<APITestResponse> apiTestResponse = null;
        try {
            apiTestResponse = objectMapper.readValue(response,
                    new TypeReference<List<APITestResponse>>() {
                    });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return apiTestResponse;
    }

    private String generatePrompt(APIInput apiInput){
        StringBuilder prompt = new StringBuilder();

        prompt.append("Generate test cases for the api with details as below");
        prompt.append("\n");
        prompt.append("api endpoint: "+ apiInput.getEndpoint());
        prompt.append("\n");
        prompt.append("api method: "+ apiInput.getMethod());
        prompt.append("\n");
        prompt.append("api request body: "+ apiInput.getRequestBody().toString());
        prompt.append("\n");
        prompt.append("Output should be strictly generated in list of json object format as below without any header or footer comments and any code block formatting (no ```json)");
        prompt.append("\n");
        prompt.append("test_id : <test_id>");
        prompt.append("\n");
        prompt.append("description : <description>");
        prompt.append("\n");
        prompt.append("request (containing fields endpoint, method, requestBody(as another json object containing string key = `data` and string value with strict json format)): <request>");
        prompt.append("\n");
        prompt.append("response (containing fields status & message with strict json format: <response>");
        prompt.append("\n");
        prompt.append("Make sure no special characters included in json output which breaks while parsing json");
        return prompt.toString();
    }
}
