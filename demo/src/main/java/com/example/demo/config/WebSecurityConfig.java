package com.example.demo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final Environment env;
	
	public WebSecurityConfig(Environment env) {
		this.env = env;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		if(isLocalMode()) {
			setLocalMode(http);
		}else {
			setRealMode(http);
		}
		
	}
	
	private boolean isLocalMode() {
		String profile = env.getActiveProfiles().length > 0 ? env.getActiveProfiles()[0] : "local";
		return profile.equals("local");
	}
	
	private void setLocalMode(HttpSecurity http) throws Exception{
		
		http
		.authorizeRequests()
		.antMatchers("/h2-console/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.csrf().ignoringAntMatchers("/h2-console/**")
		.and()
		.headers().addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "script-src 'self'")).frameOptions().disable()
		.and()
		.formLogin()
		.and()
		.httpBasic()
		//.and()
		//.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(new WhiteListedAllowFromStrategy(Arrays.asList("localhost"))))
		//.and()
		//.formLogin().loginPage("").defaultSuccessUrl("").permitAll()
		//.and()
		//.logout().logoutSuccessUrl("").permitAll()
		;
		
		
		//http.antMatcher("/**")
        //.authorizeRequests()
        //.antMatchers("/", "/me", "/h2-console/**", "/login/**", "/js/**", "/css/**", "/image/**", "/fonts/**", "/favicon.ico").permitAll()
        //.and().headers().frameOptions().sameOrigin()
        //.and().csrf().disable()
        //;
	}
	
	private void setRealMode(HttpSecurity http) throws Exception{
		http
        .authorizeRequests()
        //.antMatchers("/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("").defaultSuccessUrl("").permitAll()
      	.and()
      	.logout().logoutSuccessUrl("").permitAll()
        ;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}
