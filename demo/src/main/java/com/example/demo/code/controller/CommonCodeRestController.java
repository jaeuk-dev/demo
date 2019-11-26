package com.example.demo.code.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.code.entity.CommonCode;
import com.example.demo.code.service.CommonCodeService;

@RestController
public class CommonCodeRestController {

	@Autowired
	CommonCodeService commonCodeService;

	@RequestMapping(value = "/getCodeOne")
	public @ResponseBody Optional<CommonCode> getCodeOne() {
		long id=1;
		return commonCodeService.getCodeOne(id);
	}
	
	@RequestMapping(value = "/getCodeAll")
	public @ResponseBody List<CommonCode> getCodeAll() {
		return commonCodeService.getCodeList();
	}
}
