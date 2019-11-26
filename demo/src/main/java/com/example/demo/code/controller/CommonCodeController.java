package com.example.demo.code.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.code.entity.CommonCode;
import com.example.demo.code.service.CommonCodeService;

@Controller
public class CommonCodeController {
	
	@Autowired
	CommonCodeService commonCodeService;
	
	@RequestMapping(value = "/getCodeList")
	public String getCodeList(HttpServletRequest request,Model model) {
		
		List<CommonCode> list = commonCodeService.getCodeList();
		
		model.addAttribute("codeList", list);
		
		return "common/code/getCodeList";
		
	}
	
}
