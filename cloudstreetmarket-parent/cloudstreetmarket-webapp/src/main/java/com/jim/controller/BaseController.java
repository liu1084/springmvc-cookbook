package com.jim.controller;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jim on 2017/1/5.
 * This class is ...
 */
public class BaseController {
	protected Gson gson = new Gson();
	protected Map result = new HashMap();
}
