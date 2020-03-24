package org.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.model.User;
import org.springmvc.service.UserService;
import org.springmvc.service.UserServiceImpl;

@Controller
public class UserController {
//	 @Autowired
	  public UserService userService= new UserServiceImpl();
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("RegisterPage");
	    mav.addObject("user", new User());
	    return mav;
	  }
	
	
	 @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	 public ModelAndView addUser(HttpServletRequest request, HttpServletResponse
	 response,@ModelAttribute("user") @Valid User user, BindingResult result, Model model) { 
		 ModelAndView mav = new ModelAndView();
	     mav.setViewName("RegisterPage");
		 if (result.hasErrors()) {
			 mav.addObject("user", user);
			 return mav;
	      }
		 userService.register(user);
		 return new ModelAndView("UserPage", "name", user.getFirstname()); }
	 
}
