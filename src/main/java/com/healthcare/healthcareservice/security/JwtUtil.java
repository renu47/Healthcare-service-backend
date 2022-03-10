package com.healthcare.healthcareservice.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.function.Function;

import com.healthcare.healthcareservice.Model.ApplicationUser;



@Component
public class JwtUtil {
    @Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.token.validity}")
	private long tokenValidity;

	public String getUserName(final String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

			return body.getSubject();
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}

		return null;
	}

	public String generateToken(Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		System.out.println("====================="+user.getUsername()+user.getUsername());
		Claims claims = Jwts.claims().setSubject(user.getUsername());

		final long nowMillis = System.currentTimeMillis();
		final long expMillis = nowMillis + tokenValidity;

		Date exp = new Date(expMillis);

		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public void validateToken(final String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		}catch(Exception e){
			System.out.println("Invalid ");
		}
		// } catch (SignatureException ex) {
		// 	throw new JwtTokenMalformedException("Invalid JWT signature");
		// } catch (MalformedJwtException ex) {
		// 	throw new JwtTokenMalformedException("Invalid JWT token");
		// } catch (ExpiredJwtException ex) {
		// 	throw new JwtTokenMalformedException("Expired JWT token");
		// } catch (UnsupportedJwtException ex) {
		// 	throw new JwtTokenMalformedException("Unsupported JWT token");
		// } catch (IllegalArgumentException ex) {
		// 	throw new JwtTokenMissingException("JWT claims string is empty.");
		// }
	}


}