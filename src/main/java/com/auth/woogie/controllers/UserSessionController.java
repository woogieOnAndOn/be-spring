package com.auth.woogie.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.woogie.models.UserSessionVO;
import com.auth.woogie.services.UserSessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
public class UserSessionController extends WebSecurityConfigurerAdapter {

//	▼ 변수 ===============================================================

	@Autowired
	private UserSessionService userSessionService;


//	▼ 메소드 ===============================================================	

  @GetMapping("/user")
	public UserSessionVO user(@AuthenticationPrincipal OAuth2User principal) {
		UserSessionVO loginUser = new UserSessionVO(
			principal.getAttributes().get("id").toString(),
			principal.getAttributes().get("login").toString(),
			"",
			principal.getAttributes().get("avatar_url").toString()
		);
		return loginUser;
	}

	@PostMapping("/user")
	public void saveSession(@AuthenticationPrincipal OAuth2User principal, @CookieValue("JSESSIONID") String jSessionId) {
		UserSessionVO userSession = new UserSessionVO(
			principal.getAttributes().get("id").toString(),
			principal.getAttributes().get("login").toString(),
			jSessionId,
			""
		);
		userSessionService.insertUserSession(userSession);
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
			.csrf().disable()
			.oauth2Login();
			
		// @formatter:on
	}
}
