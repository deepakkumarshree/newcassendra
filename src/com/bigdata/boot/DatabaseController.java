package com.bigdata.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

	  @RequestMapping("/")
	    public String hello() {
	    	System.out.println("deepak ------------------------->");
	        return "nextPage";
	    }
}
