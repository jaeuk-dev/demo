package com.example.demo.member.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.UserInfo;
import com.example.demo.member.service.UserInfoService;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserInfoRestController {
	
	@Autowired
	UserInfoService userInfoService;

	@RequestMapping(value="/user/getUserInfo",headers = "Accept=application/json")
	@JsonView(UserInfo.class)
	public Optional<UserInfo> getUserInfo(@RequestParam UserInfo user) {
		return userInfoService.getUserInfo(user);
	}
	
	@RequestMapping(value="/user/getUsersInfo",headers = "Accept=application/json")
	@JsonView(UserInfo.class)
	public List<UserInfo> getUsersInfo(@RequestParam UserInfo user) {
		return userInfoService.getUsersInfo(user);
	}
}
