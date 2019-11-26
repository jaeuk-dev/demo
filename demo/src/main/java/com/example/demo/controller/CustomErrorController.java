package com.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomErrorController implements ErrorController{

	private static final String PATH = "/error"; 
	
	@Override
	public String getErrorPath() {
		return PATH;
	}

	@RequestMapping(value = PATH)
	public String error(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		String returnPage = "errors/error";
		log.debug("status : " + String.valueOf(status) + " : " + HttpStatus.NOT_FOUND.toString() + " : " + HttpStatus.NOT_FOUND.toString().contains(String.valueOf(status)));
		if(HttpStatus.NOT_FOUND.toString().contains(String.valueOf(status))) {
			returnPage = "errors/404";
		}
		log.debug("returnpage : " + returnPage);
		return returnPage;
	}
	
}
