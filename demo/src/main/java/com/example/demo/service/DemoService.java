package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.DemoBoard;

public interface DemoService {

	public void insertDemo() throws Exception;
	
	public List<DemoBoard> selectDemo() throws Exception;
}
