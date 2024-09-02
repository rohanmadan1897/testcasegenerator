package com.application.testcasegenerator.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class APITestCase {

    private String apiTestCaseId;
    private String testId;
    private String description;
    private String requestEndpoint;
    private String requestMethod;
    private String requestBody;
    private String responseStatus;
    private String responseBody;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRequestEndpoint() {
        return requestEndpoint;
    }

    public void setRequestEndpoint(String requestEndpoint) {
        this.requestEndpoint = requestEndpoint;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getApiTestCaseId() {
        return apiTestCaseId;
    }

    public void setApiTestCaseId(String apiTestCaseId) {
        this.apiTestCaseId = apiTestCaseId;
    }
}
