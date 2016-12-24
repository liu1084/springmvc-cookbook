package edu.zipcloud.cloudstreetmarket.api.controllers;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jim on 2016/12/21.
 * This class is ...
 */
@Controller
@RequestMapping
public class UserController {
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	@ResponseBody
	public String getInfo() {
		return "index";
	}

	@RequestMapping(
			value = "/ex/foos",
			headers = {"key=value", "key2=value2"},
			method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePath() {
		return "Get some Foos";
	}


	@RequestMapping(
			value = "/ex/foos",
			method = RequestMethod.GET,
			produces = "application/json",
			consumes = "application/json"
	)
	@ResponseBody
	public String getProduce() {
		Gson gson = new Gson();
		Map<String, String> person = new HashMap<>();
		person.put("name", "liujun");
		person.put("age", "20");

		List<Map<String, String>> persons = new ArrayList<>();
		persons.add(person);

		return gson.toJson(persons);
	}
}
