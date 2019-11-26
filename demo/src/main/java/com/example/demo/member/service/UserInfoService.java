package com.example.demo.member.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.member.UserInfo;

public interface UserInfoService {

	public void createUserInfo(UserInfo user);
	public void tempCreateUserInfo();
	public Optional<UserInfo> getUserInfo(UserInfo user);
	public List<UserInfo> getUsersInfo(UserInfo user);
}
