package com.ernstyoung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ernstyoung.service.MetadataService;

@RestController
public class MetadataController {
    @Autowired
    private MetadataService service;

    @PostMapping("/process")
    public String process(@RequestBody List<String> ids) {
        System.out.println("end point has been called");
        for (String id : ids) {
            service.processMetadata(id);
        }
        return "Started";
    }
}
