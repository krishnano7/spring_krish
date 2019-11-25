package com.spring.conterollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	@RequestMapping(value="goToHomePage")
	public String goToHome() {
		
		System.out.println("BaseController class :: goToHomePage Method ");// base.controller is add for directly return to HomePage.jsp from addItemToMenu.jsp
		
		return "HomePage";
		
	}

}
