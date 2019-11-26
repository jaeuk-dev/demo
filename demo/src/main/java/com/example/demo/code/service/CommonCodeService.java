package com.example.demo.code.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.example.demo.code.entity.CommonCode;

public interface CommonCodeService {
	
	public List<CommonCode> getCodeList();
	
	public void setCodeData(CommonCode code);
	
	public void createCodeData();
	
	public Optional<CommonCode> getCodeOne(long idx);
	
	public List<CommonCode> getAuthCodeList(String authCode);

}
