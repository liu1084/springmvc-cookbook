package com.jim.model.hibernate.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
/**
 * Created by jim on 2017/1/4.
 * This class is ...
 */
@Repository
@Transactional(readOnly = true)
public class BaseRepositoryImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
