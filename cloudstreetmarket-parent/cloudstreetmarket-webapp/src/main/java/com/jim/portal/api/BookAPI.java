package com.jim.portal.api;

import com.jim.portal.controller.BaseController;
import com.jim.portal.entity.BooksEntity;
import com.jim.portal.hibernate.BookManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class BookAPI extends BaseController {
	@Autowired
	private BookManagementRepository bookManagementRepository;

	@RequestMapping(value = "/{first}/{max}", method = RequestMethod.GET)
	public String index(@PathVariable("first") int first, @PathVariable("max") int max){
		result.clear();
		try {
			List list = bookManagementRepository.index(first, max);
			result.put("result", 0);
			result.put("msg", list);

		}catch (Exception ex){
			result.put("result", 0);
			result.put("msg", ex.toString());
		}

		return gson.toJson(result);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public BooksEntity getById(@PathVariable("id") String id){
		return bookManagementRepository.getById(id);
	}
}
