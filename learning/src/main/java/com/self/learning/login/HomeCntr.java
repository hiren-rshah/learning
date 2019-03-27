package com.self.learning.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCntr {

	@RequestMapping(value = "/")
	public String home() {
		return "home.html";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login.html";
	}
	
	@RequestMapping(value = "/logout-success")
	public String logout() {
		return "logout.html";
	}
}
