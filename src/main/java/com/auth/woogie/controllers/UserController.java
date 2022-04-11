package com.auth.woogie.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.woogie.models.UserVO;

import org.springframework.http.HttpStatus;

@RestController
public class UserController extends WebSecurityConfigurerAdapter {

  @GetMapping("/user")
	public UserVO user(@AuthenticationPrincipal OAuth2User principal) {
		UserVO loginUser = new UserVO(
			principal.getAttributes().get("id").toString(),
			principal.getAttributes().get("login").toString(),
			principal.getAttributes().get("avatar_url").toString()
		);
		return loginUser;
	}

	@PostMapping("/user")
	public void saveSession(UserVO userInfo) {

	}
  
  @Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.authorizeRequests(a -> a
				.antMatchers("/", "/error", "/webjars/**").permitAll()
				.anyRequest().authenticated()
			)
			.exceptionHandling(e -> e
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
			)
			.logout(l -> l
				.logoutSuccessUrl("/").permitAll()
			)
			.csrf(c -> c
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			)
			.oauth2Login();
			
		// @formatter:on
	}
}
