package com.example.demo.member.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.code.service.CommonCodeService;
import com.example.demo.member.service.AdminUserInfoService;

@Controller
@RequestMapping("/admin")
public class AdminUserInfoController {
	
	@Autowired
	CommonCodeService commonCodeService;
	
	@Autowired
	AdminUserInfoService adminUserInfoService;

	@RequestMapping("/adminUserRgt")
	public String adminUserRgt(@RequestParam HashMap<String, Object> map, Model model) {
		
		//권한 코드 목록 조회
		model.addAttribute("authList", commonCodeService.getAuthCodeList("AUTH001"));
		
		//관리자 지정되지 않은 아이디 목록 조회
		model.addAttribute("idList", "");
		
		return "";
	}
}
