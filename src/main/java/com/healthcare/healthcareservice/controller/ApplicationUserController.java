package com.healthcare.healthcareservice.controller;

import java.util.Set;

import com.healthcare.healthcareservice.Model.ApplicationUser;
import com.healthcare.healthcareservice.Model.jwtUser;
import com.healthcare.healthcareservice.exceptions.DisabledUserException;
import com.healthcare.healthcareservice.exceptions.InvalidUserCredentialsException;
import com.healthcare.healthcareservice.security.JwtUtil;
import com.healthcare.healthcareservice.service.ApplicationUserService;
import com.healthcare.healthcareservice.service.UserAuthService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApplicationUserController {
    @Autowired
    ApplicationUserService userService;
    @Autowired
	private UserAuthService userAuthService;
    @Autowired
    JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/check")
	public JSONObject registerUser(){
		System.out.println("Check API of ApplicationUser Controller");
		JSONObject Obj = new JSONObject();
		Obj.put("message", "success!");
        return Obj;
    }


    @PostMapping("/register")
	public JSONObject registerUser(@RequestBody ApplicationUser user){
        JSONObject obj = new JSONObject();
        if(userService.registerUser(user))
        obj.put("message", "Registration successful");
        else
        obj.put("message", "Password or username policy failed");
        return obj;
    }

	@GetMapping("/view/{userId}")
    public ApplicationUser viewProfile(@PathVariable String userId){
       System.out.println("==============="+userService.viewProfile(userId)) ;
        return userService.viewProfile(userId);
    }

	@PostMapping("/edit/{userId}")
	public boolean editProfile(@RequestBody ApplicationUser user, @PathVariable String userId){
		return userService.editProfile(user, userId);
	}
    

	@PostMapping("/signin")
	public ResponseEntity<JSONObject> generateJwtToken(@RequestBody ApplicationUser request) {
		Authentication authentication = null;
        
		try {
			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getUser_name(), request.getPassword()));
		} catch (DisabledException e) {
			throw new DisabledUserException("User Inactive");
		} catch (BadCredentialsException e) {
			throw new InvalidUserCredentialsException("Invalid Credentials");
		}

		UserDetails user =  (UserDetails) authentication.getPrincipal();
		// Set<String> roles = user.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.toSet());

		String token = jwtUtil.generateToken(authentication);

		JSONObject response = new JSONObject();
		response.put("message", "Authentication successful");
		response.put("token", token);
        response.put("id", user.getUsername());
		return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
	}
}

