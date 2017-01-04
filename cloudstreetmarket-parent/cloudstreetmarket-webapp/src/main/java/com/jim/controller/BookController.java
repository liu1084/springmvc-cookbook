package com.jim.controller;

import com.jim.model.hibernate.BookManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jim on 2017/1/5.
 * This class is ...
 */
@RestController
@RequestMapping(value = "/book/api")
public class BookController {
	@Autowired
	private BookManagementRepository bookManagementRepository;

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public List<?> index(){
		return bookManagementRepository.index();
	}
}
