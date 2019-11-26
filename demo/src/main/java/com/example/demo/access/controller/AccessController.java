package com.example.demo.access.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.access.service.AccessService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AccessController {

	@Autowired
	AccessService accessService;
	
	@RequestMapping("/access/getAllCount")
	public String getAccessCount(HttpServletRequest request, HttpServletResponse response) {
		
		log.debug("count = " + "" + accessService.getAccessAllCount());
		
		return "common/code/getCodeList";
	}
	
}
