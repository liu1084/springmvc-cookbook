package com.jim.model.hibernate.Impl;

import com.jim.entity.BooksEntity;
import com.jim.model.hibernate.BookManagementRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by jim on 2017/1/4.
 * This class is ...
 */
@Repository
public class BookManagementRepositoryImpl extends BaseRepositoryImpl implements BookManagementRepository {
	@Override
	public List index(int first, int max) {
		String hql = "from BooksEntity";

		return this.getCurrentSession().createQuery(hql).setMaxResults(max).setFirstResult(first).list();
	}

	@Override
	public BooksEntity create(BooksEntity BooksEntity) {
		return (BooksEntity) this.getCurrentSession().save(BooksEntity);
	}

	@Override
	public BooksEntity getById(String id) {
		return this.getCurrentSession().get(BooksEntity.class, Long.parseLong(id));
	}

	@Override
	public void update(BooksEntity booksEntity, String id) throws Exception {
		BooksEntity book = getById(id);
		if (StringUtils.isEmpty(book)){
			throw new Exception("book id is not exist");
		}

		book.setAuthor(booksEntity.getAuthor());
		book.setCategory(booksEntity.getCategory());
		book.setCover(booksEntity.getCover());
		book.setDescription(booksEntity.getDescription());
		book.setFormat(booksEntity.getFormat());
		book.setIsbn(booksEntity.getIsbn());
		book.setLanguage(booksEntity.getLanguage());
		book.setName(booksEntity.getName());

		this.getCurrentSession().update(book);
	}

	@Override
	public void delete(String id) {
		this.getCurrentSession().delete(this.getById(id));
	}
}
