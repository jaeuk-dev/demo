package com.example.demo.interceptor;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class XssInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(XssInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug(request.getRequestURI());
		logger.debug("XSSInterceptor=============================================");
		
		boolean rtrVal = true;
		
		String[] filterStr = new String[] {"SCRIPT","<IFRAME","<OBJECT","<EMBEDED","<FORM","JAVASCRIPT"};
		
		Enumeration<String> keys = request.getParameterNames();
		while(keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			
			String[] value = request.getParameterValues(key);
			
			if(
					!"qafile".equals(key) && !"upfile".equals(key)
					&& value!=null && !value.equals("")
				) {
				
				int i=0;
				for(i=0;i<filterStr.length;i++) {
					if(value[0].toUpperCase().indexOf(filterStr[i]) != -1) {
						logger.debug("  key  =  [" + key + "]     value  =  [" + value[0] + "]");
						response.sendRedirect("/");
						rtrVal = false;
					}
				}
			}
		}
		
		return rtrVal;
	}
	

}
