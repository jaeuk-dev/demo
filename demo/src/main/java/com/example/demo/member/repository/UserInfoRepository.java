package com.example.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.UserInfo;
import com.google.common.base.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	public Optional<UserInfo> findByUserName(String userName);
	public Optional<UserInfo> findByName(String nmame);
	public Optional<UserInfo> findByPhoneNumber(String phoneNumber);
	
}
