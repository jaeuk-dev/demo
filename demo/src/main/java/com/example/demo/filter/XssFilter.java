package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.filter.request.XssRequest;

public class XssFilter implements Filter{

	private static final Logger logger = LoggerFactory.getLogger(XssFilter.class);
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        logger.debug("=======================================================");
        logger.debug( "XssFilter ");
        logger.debug("=======================================================");
        request.setCharacterEncoding("utf-8");
		
		chain.doFilter(new XssRequest(request), response);
	}

	@Override
	public void destroy(){
		
	}

	@Override
	public void init(FilterConfig fc) throws ServletException{
		
	}
	
}
