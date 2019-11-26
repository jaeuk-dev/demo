package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.code.entity.CommonCode;
import com.example.demo.code.service.CommonCodeService;
import com.example.demo.code.service.CommonCodeSubService;
import com.example.demo.member.UserInfo;
import com.example.demo.member.login.service.LoginService;
import com.example.demo.member.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TempLoginRunner implements ApplicationRunner{

	@Autowired
	LoginService loginService;
	
	@Autowired
	CommonCodeService commonCodeService;
	
	@Autowired
	CommonCodeSubService commonCodeSubService; 
	
	@Autowired
	UserInfoService userInfoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		UserInfo saelobi = loginService.createLoginEntity("test", "1234");
		log.debug(saelobi.getUserName()+" : "+saelobi.getPassword());
		commonCodeService.createCodeData();
		log.debug("commoncode success!!");
		commonCodeSubService.createCodeSubData();
		log.debug("commoncodesub success!!");
		userInfoService.tempCreateUserInfo();
		log.debug("userinfo success!!");
	}
}
