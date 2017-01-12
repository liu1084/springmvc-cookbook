package com.jim.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jim on 2017/1/12.
 * This class is ...
 */
@Controller(value = "/auth")
public class LoginController extends BaseController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(){
		return "";
	}
}
