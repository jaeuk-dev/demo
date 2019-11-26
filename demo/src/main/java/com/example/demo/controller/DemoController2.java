package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DemoController2 {

	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request, Model model) {
		log.debug("/test : " + request.getAuthType());
		model.addAttribute("id", "iopqwas");
		model.addAttribute("name", "김재욱");
		model.addAttribute("authType", "web");
		return "test/test";
	}
	

	@RequestMapping(value="/vueTest")
	public String vueTest(HttpServletRequest request, Model model) {
		return "main/test";
	}
}
