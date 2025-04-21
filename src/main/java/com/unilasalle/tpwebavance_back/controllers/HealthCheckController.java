package com.unilasalle.tpwebavance_back.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/public/ping")
    public String pingPublic(){return "pong from public";}

    @GetMapping("/private/ping")
    public String pingPrivate(){return "pong from private";}
}
