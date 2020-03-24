package org.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.model.Login;
import org.springmvc.model.User;
import org.springmvc.service.UserService;
import org.springmvc.service.UserServiceImpl;

@Controller
public class LoginController {
	
	UserService userService= new UserServiceImpl();
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("LoginPage");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("login") Login login) {
		
	    ModelAndView mav = null;
	    User user = userService.validateUser(login);

	    if (user != null) {
	      mav = new ModelAndView("UserPage");
	      mav.addObject("name", user.getFirstname());
	    } else {
	      mav = new ModelAndView("LoginPage");
	      mav.addObject("message", "Username or Password is wrong!!");
	    }

	    return mav;
	  }
}
