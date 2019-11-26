package com.example.demo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.member.UserInfo;
import com.example.demo.member.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;

	@RequestMapping("/user/addUserInfo")
	public String addUserInfo(@RequestParam UserInfo user, Model model) {
		
		return "";
	}
}
