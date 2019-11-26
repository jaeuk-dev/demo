package com.example.demo.filter.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XssRequest extends HttpServletRequestWrapper{

	protected static final Logger LOGGER = LoggerFactory.getLogger(XssRequest.class);
	
	public XssRequest(HttpServletRequest request) {
        super(request);
        LOGGER.debug( "XssRequest ");
    }
	
	public String getParameter(String key) {
        LOGGER.debug( "getParameter ");
        String value = null;
        try {
            value = super.getParameter(key);
            if (value != null) {
                value = xssReplace(key);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return value;
    }

    public String[] getParameterValues(String key) {
        LOGGER.debug( "getParameterValues ");
        String[] values =super.getParameterValues(key);   
        try {
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    values[i] = xssReplace(key);     
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return values;
    }
    
    private String xssReplace(String key){
        String rslt   = (super.getParameter(key) == null) ? "" : super.getParameter(key);
        String url = super.getRequestURI();
        if(rslt != null)
        	rslt = rslt.trim();
        LOGGER.debug("=======================================================");
        LOGGER.debug("= before key =["+key+"]     rslt =["+rslt+"]");

        if( (
        	!((key.equals("setting") || key.equals("name") || key.equals("driver") || key.equals("url")) && ((rslt.contains("h2") || rslt.contains("H2"))))
        	&&
        	!(url.contains("h2-console"))
        	)
        	&&
            (rslt!=null && !rslt.equals(""))
          )
        {
            rslt = rslt.replaceAll("\\/","&#47;");
            rslt = rslt.replaceAll("\\<","&#60;");
            rslt = rslt.replaceAll("\\>","&#62;");
            rslt = rslt.replaceAll("\\@","&#64;");
            rslt = rslt.replaceAll("\\\\","&#92;");
            rslt = rslt.replaceAll("\\:","&#58;");
            rslt = rslt.replaceAll("\\*","&#42;");
            rslt = rslt.replaceAll("\\?","&#63;");
            rslt = rslt.replaceAll("\\|","&#124;");
            rslt = rslt.replaceAll("\\~","&#126;");
            rslt = rslt.replaceAll("\\!","&#33;");
            rslt = rslt.replaceAll("\\$","&#36;");
            rslt = rslt.replaceAll("\\%","&#37;");
            rslt = rslt.replaceAll("\\^","&#94;");
            rslt = rslt.replaceAll("\\(","&#40;");
            rslt = rslt.replaceAll("\\)","&#41;");
            rslt = rslt.replaceAll("\\_","&#95;");
            rslt = rslt.replaceAll("\\+","&#43;");
            rslt = rslt.replaceAll("\\{","&#123;");
            rslt = rslt.replaceAll("\\}","&#125;");
            rslt = rslt.replaceAll("\\'","&#39;");
            rslt = rslt.replaceAll("\\-","&#45;");
            rslt = rslt.replaceAll("\\=","&#61;");
            rslt = rslt.replaceAll("\\[","&#91;");
            rslt = rslt.replaceAll("\\]","&#93;");
            rslt = rslt.replaceAll("\\,","&#44;");
            rslt = rslt.replaceAll("\\.","&#46;");
            
            //#&;
            
        }

        LOGGER.debug("= after  key =["+key+"]     rslt =["+rslt+"]");
        LOGGER.debug("=======================================================");
        
        return rslt;
    }
}
