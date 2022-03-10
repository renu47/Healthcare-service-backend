package com.healthcare.healthcareservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import com.healthcare.healthcareservice.Model.ApplicationUser;
import com.healthcare.healthcareservice.repository.ApplicationUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserAuthService implements UserDetailsService{
	@Autowired
	private ApplicationUserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		ApplicationUser user = userRepository.findByUserEmail(email).get();
      
		// List<UserRole> userRoles = user.getUserRoles().stream().collect(Collectors.toList());

		// List<GrantedAuthority> grantedAuthorities = userRoles.stream().map(r -> {
		// 	return new SimpleGrantedAuthority(r.getRole());
		// }).collect(Collectors.toList());
		
		return new org.springframework.security.core.userdetails.User(email, user.getPassword(), new ArrayList<>());
	}
}