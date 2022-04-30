package com.technicalkeeda.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.technicalkeeda.dao.MovieDao;
import com.technicalkeeda.entities.Movie;

public class MovieDaoImpl implements MovieDao {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void createMovie(Movie movie) {
		hibernateTemplate.saveOrUpdate(movie);
	}

}