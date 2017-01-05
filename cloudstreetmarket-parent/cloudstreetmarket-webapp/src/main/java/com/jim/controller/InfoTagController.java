package com.jim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

/**
 * Created by jim on 2016/12/24.
 * This class is ...
 */
@Controller
@RequestMapping("/")
public class InfoTagController {
	@Autowired
	private WebApplicationContext webAppContext;
//
//	private static final LocalDateTime localDateTime = LocalDateTime.now();
//	private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss a");
//
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	@ResponseBody
	public String test(){
		return "test";
	}
//
//	@RequestMapping(value = "/helloHandler", method = RequestMethod.GET)
//	public String helloHandler(ModelMap modelAndView) {
//		modelAndView.addAttribute("message", "hello");
//		return "index";
//	}
//
//	@RequestMapping(value = "/message/{name:.+}", method = RequestMethod.GET)
//	public ModelAndView messageHandler(@PathVariable String name) {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("index");
//		return model;
//	}
//
//	@RequestMapping(value = "/hello/{name:.?}", method = RequestMethod.GET)
//	public ModelAndView hello(@PathVariable("name") String name) {
//
//		ModelAndView model = new ModelAndView();
//		model.setViewName("index");
//		model.addObject("message", name);
//
//		return model;
//
//	}
//
//	@RequestMapping("/server")
//	@ResponseBody
//	public String infoTagServer() {
//		return new StringJoiner("<br/>")
//				.add("html:5	")
//				.add("---------------------")
//				.add("Server:")
//				.add(webAppContext.getServletContext().getServerInfo())
//				.add("bean:")
//				.add((CharSequence) webAppContext.getBean("webAppVersion"))
//				.add("Start date:")
//				.add(localDateTime.format(dateTimeFormat))
//				.add("---------------------")
//				.toString();
//	}
}
