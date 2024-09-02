package com.application.testcasegenerator.controller;

import com.application.testcasegenerator.models.APIInput;
import com.application.testcasegenerator.models.APITestResponse;
import com.application.testcasegenerator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generate")
public class GenerateController {

    @Autowired
    private GeneratorService generatorService;

    @PostMapping("/apitests")
    public ResponseEntity<List<APITestResponse>> generateAPITests(@RequestBody APIInput apiInput) {
        List<APITestResponse> testCases = generatorService.generate(apiInput);
        return ResponseEntity.ok(testCases);
    }


}
