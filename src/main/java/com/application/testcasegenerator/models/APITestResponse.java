package com.application.testcasegenerator.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class APITestResponse {

    private String test_id;
    private String description;
    @JsonDeserialize(as = APIInput.class)
    private APIInput request;
    @JsonDeserialize(as = APIOutput.class)
    private APIOutput response;

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public APIInput getRequest() {
        return request;
    }

    public void setRequest(APIInput request) {
        this.request = request;
    }

    public APIOutput getResponse() {
        return response;
    }

    public void setResponse(APIOutput response) {
        this.response = response;
    }
}
