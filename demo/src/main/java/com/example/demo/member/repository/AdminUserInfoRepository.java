package com.example.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.AdminUserInfo;

@Repository
public interface AdminUserInfoRepository extends JpaRepository<AdminUserInfo, Long>{

	AdminUserInfo findByUserName(String userName);
}
