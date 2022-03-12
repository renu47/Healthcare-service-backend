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

    public boolean editProfile(ApplicationUser user, String userId) {
        System.out.println("user id is = "+userId);
        ApplicationUser usr = userRepository.findByUserName(userId).get();
        System.out.println("usr  is == "+usr.user_email+" "+usr.user_mobile);
        usr.setUser_name(userId);
        usr.setUser_email(user.getUser_email());
        usr.setUser_mobile(user.getUser_mobile());
        usr.setLocation(user.getLocation());
        System.out.println("user is= "+user.user_email+" "+user.user_mobile);
        usr = userRepository.save(usr);
        JSONObject res = new JSONObject();
        
        if(usr != null)
        return true;
        else
        return false;
    }

}

