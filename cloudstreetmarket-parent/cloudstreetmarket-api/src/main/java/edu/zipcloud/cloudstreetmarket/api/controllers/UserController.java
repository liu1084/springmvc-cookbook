package edu.zipcloud.cloudstreetmarket.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jim on 2016/12/21.
 * This class is ...
 */
@Controller
@RequestMapping(value = "/api")
public class UserController {
	@RequestMapping(value = {"", "/"})
	public String getInfo(){
		return "index";
	}
}
