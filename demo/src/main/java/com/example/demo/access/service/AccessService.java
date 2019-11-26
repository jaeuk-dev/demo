package com.example.demo.access.service;

import javax.servlet.http.HttpServletRequest;

public interface AccessService {
	
	public void createAccess(HttpServletRequest request);
	
	public long getAccessAllCount();

}
