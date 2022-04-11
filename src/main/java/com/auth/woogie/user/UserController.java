package com.auth.woogie.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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

  // @GetMapping("/user")
	// public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
  //   System.out.println(principal);
	// 	return Collections.singletonMap("name", principal.getName());
	// }
  
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
