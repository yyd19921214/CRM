package com.java1234.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  
@RequestMapping("/security")  
public class MainController {
	protected static Logger logger = Logger.getLogger("controller");
	
	@RequestMapping(value = "/common", method = RequestMethod.GET)
	public String getCommonPage() {
		System.out.println("Received request to show common page");
//		logger.debug("Received request to show common page");
		return "commonpage";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)  
    public String getAadminPage() {  
//        logger.debug("Received request to show admin page");
		System.out.println("Received request to show admin page");
        return "adminpage";  
  
    }  
	

}
