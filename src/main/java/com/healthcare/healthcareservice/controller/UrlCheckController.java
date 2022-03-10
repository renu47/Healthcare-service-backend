package com.healthcare.healthcareservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.URL;
import java.net.HttpURLConnection;
@RestController
public class UrlCheckController {
    private final String IS_SITE_UP = "Site is up!";
    private final String IS_SITE_DOWN = "Site is down!";
}
