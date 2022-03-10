package com.healthcare.healthcareservice.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.security.core.AuthenticationException;

@Component
public class ApiAuthenticationEntryPoint implements AuthenticationEntryPoint  {
    private static final long serialVersionUID = -7858869558953243875L;

    @Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException{
				
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}