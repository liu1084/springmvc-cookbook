package com.jim.model.hibernate;

import com.jim.entity.BooksEntity;

import java.util.List;

/**
 * Created by jim on 2017/1/5.
 * This class is ...
 */
public interface BookManagementRepository{
	List index();
	BooksEntity create(BooksEntity BooksEntity);
	BooksEntity getById(String id);
	void update(BooksEntity BooksEntity);
	void delete(String id);
}
