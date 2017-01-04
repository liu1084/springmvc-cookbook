package com.jim.model.hibernate.Impl;

import com.jim.entity.BooksEntity;
import com.jim.model.hibernate.BookManagementRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jim on 2017/1/4.
 * This class is ...
 */
@Repository
public class BookManagementRepositoryImpl extends BaseRepositoryImpl implements BookManagementRepository {
	@Override
	public List index() {
		String hql = "from BooksEntity";
		return this.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public BooksEntity create(BooksEntity BooksEntity) {
		return (BooksEntity) this.getCurrentSession().save(BooksEntity);
	}

	@Override
	public BooksEntity getById(String id) {
		return this.getCurrentSession().get(BooksEntity.class, id);
	}

	@Override
	public void update(BooksEntity BooksEntity) {
		this.getCurrentSession().update(BooksEntity);
	}

	@Override
	public void delete(String id) {
		this.getCurrentSession().delete(this.getById(id));
	}
}
