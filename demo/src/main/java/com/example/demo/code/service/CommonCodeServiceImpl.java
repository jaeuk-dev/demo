package com.example.demo.code.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.code.entity.CommonCode;
import com.example.demo.code.repository.CommonCodeRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommonCodeServiceImpl implements CommonCodeService{

	@Autowired
	CommonCodeRepository commonCodeRepository;
	
	@Override
	public List<CommonCode> getCodeList() {
		List<CommonCode> list = commonCodeRepository.findAll();
		return list;
	}

	@Override
	public void setCodeData(CommonCode code) {
		commonCodeRepository.save(code);
	}

	@Override
	public void createCodeData() {
		
		CommonCode code = null;
		List<CommonCode> list = new ArrayList<CommonCode>();
		
		for(int i=0; i<=4; i++) {
			code = new CommonCode(String.valueOf(i), "코드"+i+"번", String.valueOf(i), "비고"+i);
			list.add(code);
		}
		
		commonCodeRepository.saveAll(new Iterable<CommonCode>() {
			public Iterator<CommonCode> iterator(){
				return list.iterator();
			}
		});
		
	}

	@Override
	public Optional<CommonCode> getCodeOne(long idx) {
		return commonCodeRepository.findById(idx);
	}

	@Override
	public List<CommonCode> getAuthCodeList(String authCode) {
		return commonCodeRepository.findByCodeNumber(authCode);
	}

}
