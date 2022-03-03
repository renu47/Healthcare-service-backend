package com.healthcare.healthcareservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.URL;
import java.net.HttpURLConnection;
@RestController
public class UrlCheckController {
    private final String IS_SITE_UP = "Site is up!";
    private final String IS_SITE_DOWN = "Site is down!";

    @GetMapping("/get")
    public String checkUrl(@RequestParam String url){
        String returnMsg = "";
        try{
        URL urlObj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection)urlObj.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int resCode = conn.getResponseCode()/100;
        if(resCode != 2 || resCode != 3){
            returnMsg = IS_SITE_DOWN;
        }else{
            returnMsg = IS_SITE_UP;
        }
    }catch(Exception e){
        System.out.print(e.getMessage());
    }
        return returnMsg;
    }
}
