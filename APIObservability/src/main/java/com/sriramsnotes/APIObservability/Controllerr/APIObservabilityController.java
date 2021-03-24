package com.sriramsnotes.APIObservability.Controllerr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIObservabilityController {

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

}