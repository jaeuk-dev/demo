package com.example.demo.access.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.access.entity.Access;
import com.example.demo.access.repository.AccessRepository;
import com.example.demo.access.repository.AccessRepositorySupport;


@Service
@Transactional(rollbackFor = Exception.class)
public class AccessServiceImpl implements AccessService {

	@Autowired
	AccessRepository accessRepository;
	
	@Autowired
	AccessRepositorySupport accessRepositorySupport; 

	@Override
	public void createAccess(HttpServletRequest request) {
		
		Access access = new Access(request.getRemoteAddr(), request.getRequestedSessionId(), request.getRequestURI(), request.getRemoteUser());
		
		accessRepository.save(access);
		
	}

	@Override
	public long getAccessAllCount() {
		return accessRepositorySupport.findByCountGroupbyIpAndSessionIdAndUser();
	}
	
	
}
