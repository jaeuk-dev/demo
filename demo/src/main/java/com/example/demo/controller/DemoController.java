package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DemoBoard;
import com.example.demo.service.DemoService;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DemoController {

	@Autowired
	DemoService demoService;
	
	@RequestMapping("/demo")
	public String demo() {
		return "sample First";
	}
	
	@RequestMapping("/demoInsert")
	public String demoInsert() throws Exception {
		demoService.insertDemo();
		return "success";
	}
	
	@RequestMapping(value="/demoSelect",headers = "Accept=application/json")
	@JsonView(DemoBoard.class)
	public List<DemoBoard> demoSelect() throws Exception {
		return demoService.selectDemo();
	}
	
	@RequestMapping(value="/demoSelect2")
	public List<DemoBoard> demoSelect2() throws Exception {
		return demoService.selectDemo();
	}
	
}
