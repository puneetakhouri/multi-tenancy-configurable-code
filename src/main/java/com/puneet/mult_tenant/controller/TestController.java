package com.puneet.mult_tenant.controller;


import com.puneet.mult_tenant.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {


    @Autowired
    private TestService testService;

    @GetMapping("/api/v1/getDetails")
    public Map<String, Object> getData(@RequestParam String tenant) {

        return testService.getData(tenant);
    }
}
