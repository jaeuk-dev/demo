package com.example.demo.member.login.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.UserInfo;


@Repository(value = "loginRepository")
public interface LoginRepository extends JpaRepository<UserInfo, Long>{

	Optional<UserInfo> findByUserName(String username);

}
