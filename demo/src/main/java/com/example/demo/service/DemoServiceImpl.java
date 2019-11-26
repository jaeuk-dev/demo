package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DemoBoard;
import com.example.demo.repository.DemoBoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	DemoBoardRepository demoBoardRepository;
	
	@Override
	public void insertDemo() throws Exception {
		demoBoardRepository.save(new DemoBoard("jaeuk", 18));
	}

	@Override
	public List<DemoBoard> selectDemo() throws Exception {
		return (List<DemoBoard>)demoBoardRepository.findAll(); 
	}

}
