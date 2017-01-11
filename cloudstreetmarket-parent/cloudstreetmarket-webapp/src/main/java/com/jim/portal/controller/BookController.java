package com.jim.portal.controller;

import com.jim.portal.entity.BooksEntity;
import com.jim.portal.hibernate.BookManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jim on 2017/1/5.
 * This class is ...
 */
@Controller
@RequestMapping(value = "/book")
public class BookController extends BaseController {
	@Autowired
	private BookManagementRepository bookManagementRepository;

	@RequestMapping(value = "/updateBook", method = RequestMethod.GET)
	public String updateBook(){
		return "system/book/update-book";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BooksEntity booksEntity, String id){
		result.clear();
		try {
			bookManagementRepository.update(booksEntity, id);
			result.put("result", 0);
		}catch (Exception ex){
			result.put("result", 1);
			result.put("msg", ex.toString());
		}

		return gson.toJson(result);
	}

	@RequestMapping(value = "/createBook", method = RequestMethod.GET)
	public String createBook(){
		return "system/book/create-book";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(BooksEntity booksEntity){
		result.clear();
		try {
			BooksEntity book = bookManagementRepository.create(booksEntity);
			result.put("result", 0);
			result.put("msg", book);
		}catch (Exception ex){
			result.put("result", 1);
			result.put("msg", ex.toString());
		}

		return gson.toJson(result);
	}

}
