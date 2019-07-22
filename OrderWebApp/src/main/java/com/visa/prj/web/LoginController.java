package com.visa.prj.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@RequestMapping(value="login.do")
	public String doLogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd, Model m) {
		m.addAttribute("user", email);
		//By default addAttribute will store in request scope. So in top we are telling session
		//Attribute to store the "user" in session scope
		return "listProducts.do";
	}

}
