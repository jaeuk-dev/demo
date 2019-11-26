package com.example.demo.code.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.code.entity.CommonCode;
import com.example.demo.code.entity.CommonCodeSub;
import com.example.demo.code.repository.CommonCodeRepository;
import com.example.demo.code.repository.CommonCodeSubRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommonCodeSubServiceImpl implements CommonCodeSubService{

	@Autowired
	CommonCodeRepository commonCodeRepository;
	
	@Autowired
	CommonCodeSubRepository commonCodeSubRepository; 
	
	@Override
	public void createCodeSubData() {
		
		List<CommonCode> codeList = commonCodeRepository.findAll();
		
		if(!codeList.isEmpty()) {
			
			CommonCodeSub codeSub = null;
			List<CommonCodeSub> list = new ArrayList<CommonCodeSub>();
			
			for(int i=0; i<codeList.size(); i++) {
				codeSub = new CommonCodeSub(String.valueOf(codeList.get(i).getIdx()), String.valueOf(i), "코드"+i+"번", String.valueOf(i), String.valueOf(i), String.valueOf(i), "비고"+i);
				list.add(codeSub);
			}
			
			commonCodeSubRepository.saveAll(new Iterable<CommonCodeSub>() {
				public Iterator<CommonCodeSub> iterator(){
					return list.iterator();
				}
			});
		}
		
		
	}

}
