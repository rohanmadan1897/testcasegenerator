package com.application.testcasegenerator.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class APIInput {

    private String endpoint;
    private String method;
    @JsonDeserialize(as = APIRequestBody.class)
    private APIRequestBody requestBody;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public APIRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(APIRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    public String toString() {
        return "APIInput{" +
                "endpoint='" + endpoint + '\'' +
                ", method='" + method + '\'' +
                ", requestBody='" + requestBody + '\'' +
                '}';
    }
}
