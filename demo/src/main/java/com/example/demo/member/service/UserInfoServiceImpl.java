package com.example.demo.member.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.UserInfo;
import com.example.demo.member.repository.UserInfoRepository;
import com.example.demo.member.repository.UserInfoRepositorySupport;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	UserInfoRepositorySupport userInfoRepositorySupport; 

	@Override
	public void createUserInfo(UserInfo user) {
		userInfoRepository.save(user);
	}

	@Override
	public void tempCreateUserInfo() {
		UserInfo user = null;
		List<UserInfo> list = new ArrayList<UserInfo>();
		
		for(int i=0; i<10; i++) {
			user = new UserInfo("test"+i, "1234", "테스트"+i, "010-3035-445"+i);
			list.add(user);
		}
		
		userInfoRepository.saveAll(new Iterable<UserInfo>() {
			public Iterator<UserInfo> iterator(){
				return list.iterator();
			}
		});
	}

	@Override
	public Optional<UserInfo> getUserInfo(UserInfo user) {
		return userInfoRepository.findById(user.getIdx());
	}

	@Override
	public List<UserInfo> getUsersInfo(UserInfo user) {
		return userInfoRepositorySupport.findByDynamicQueryUserInfo(user);
	}
	
	
}
