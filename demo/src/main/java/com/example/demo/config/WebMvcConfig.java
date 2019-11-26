package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.filter.XssFilter;
import com.example.demo.interceptor.Interceptor;
import com.example.demo.interceptor.XssInterceptor;

@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired Interceptor interceptor;
	@Autowired XssInterceptor xssInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/**");
	}
	
	//@Override
	//public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	//	configurer.enable();
	//}
	
	//Bean
	@Bean
	public FilterRegistrationBean<XssFilter> getFilterRegistrationBean() {
		FilterRegistrationBean<XssFilter> registrationBean = new FilterRegistrationBean<XssFilter>(new XssFilter());
		return registrationBean;
	}
}
