package com.jim.portal.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jim on 2017/1/5.
 * This class is ...
 */
public class BaseController {
	protected Gson gson = new Gson();
	protected Map result = new HashMap();
	protected Logger logger = LoggerFactory.getLogger(BaseController.class);
}
