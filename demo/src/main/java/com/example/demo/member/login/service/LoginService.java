package com.example.demo.member.login.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.member.AdminUserInfo;
import com.example.demo.member.UserInfo;
import com.example.demo.member.login.repository.LoginRepository;
import com.example.demo.member.repository.AdminUserInfoRepository;


@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AdminUserInfoRepository adminUserInfoRepository;
	
	public UserInfo createLoginEntity(String name, String password) {
		UserInfo len = new UserInfo(name, passwordEncoder.encode(password));
		return loginRepository.save(len);
	}
	
	private Collection<? extends GrantedAuthority> authorities(){
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	private Collection<? extends GrantedAuthority> adminAuthorities(){
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> byUserName = loginRepository.findByUserName(username);
		UserInfo len = byUserName.orElseThrow(() -> new UsernameNotFoundException(username));
		
		//관리자 여부에 따라 role부여 분기
		boolean adminYn = false;
		AdminUserInfo adminUserInfo = adminUserInfoRepository.findByUserName(len.getUserName());
		if(len.getUserName().equalsIgnoreCase(adminUserInfo.getUserName())) {
			adminYn = true;
		}
		
		User usr = null;
		
		if(adminYn) {
			usr = new User(len.getUserName(),len.getPassword(),adminAuthorities());
		}else {
			usr = new User(len.getUserName(),len.getPassword(),authorities());
		}
		
		//return new User(len.getUserName(),len.getPassword(),authorities());
		
		return usr;
	}

	
}
