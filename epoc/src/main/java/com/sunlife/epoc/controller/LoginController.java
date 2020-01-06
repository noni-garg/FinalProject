package com.sunlife.epoc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sunlife.epoc.entity.User;
import com.sunlife.epoc.service.UserService;



@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= ("/"),method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value= {"/login"},method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username")String username,@RequestParam("pwd")String pwd,HttpSession session) {
		ModelAndView model = new ModelAndView();
		User user=new User();
		user.setUsername(username);
		user.setPassword(pwd);
		boolean flag = userService.login(user);
		if(flag) {
			model.setViewName("mainMenu");
			model.addObject("name",username);
			session.setAttribute("name", username);
		}
		else
			model.setViewName("index");
			model.addObject("message", "Login Failed");
		return model;
	}
	@RequestMapping(value = {"/goToMain"})
	public ModelAndView goBackToMain() {
		return new ModelAndView("mainMenu");
	}
}
