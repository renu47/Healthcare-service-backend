package com.healthcare.healthcareservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.healthcare.healthcareservice.Model.ApplicationUser;
import com.healthcare.healthcareservice.repository.ApplicationUserRepository;

import org.json.simple.JSONObject;

@Service
public class ApplicationUserService {
    @Autowired
    ApplicationUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean registerUser(ApplicationUser user) {
        String pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        ApplicationUser usr = userRepository.save(user);
        System.out.println("user is ====================="+user.getUser_email());
        System.out.println("user is ====================="+usr);
        if(usr != null)
        return true;
        else 
        return false;

    }

    public ApplicationUser viewProfile(String userId) {
      
        return  userRepository.findById(userId).get();
    }

    public JSONObject editProfile(ApplicationUser user, String userId) {
        ApplicationUser usr = userRepository.findByUserEmail(userId).get();
        usr = user;
        usr = userRepository.save(usr);
        JSONObject res = new JSONObject();
        
        if(usr != null)
        res.put("message", "Update successful!");
        else
        res.put("message", "Update not successful!");
        return res;
    }

}

