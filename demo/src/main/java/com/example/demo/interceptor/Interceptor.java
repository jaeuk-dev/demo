package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.demo.access.service.AccessService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Interceptor extends HandlerInterceptorAdapter {

	@Autowired
	AccessService accessService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.debug("Interceptor pre start");
		log.debug("request URI : " + request.getRequestURI());
		log.debug("request IP : " + request.getLocalAddr());
		log.debug("request IP : " + request.getLocalName());
		log.debug("request IP : " + request.getLocalPort());
		log.debug("request IP : " + request.getRemoteAddr());
		log.debug("request IP : " + request.getRemoteHost());
		log.debug("request IP : " + request.getRemotePort());
		log.debug("request IP : " + request.getRemoteUser());
		
		if(!request.getRequestURI().contains("/error")) {
			log.debug("access count");
			accessService.createAccess(request);
		}
		
		return true;
	}
}
