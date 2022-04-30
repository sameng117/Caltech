package com.technicalkeeda.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.technicalkeeda.dao.MovieDao;
import com.technicalkeeda.entities.Movie;

public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/spring-configuration.xml");

		Movie lifeOfPi = new Movie();
		lifeOfPi.setReleaseYear(2012);
		lifeOfPi.setDirector("Ang Lee");
		lifeOfPi.setTitle("Life of Pi");

		Movie dabangg2 = new Movie();
		dabangg2.setReleaseYear(2011);
		dabangg2.setDirector("Arbaaz Khan");
		dabangg2.setTitle("Dabangg 2");

		MovieDao movieDao = (MovieDao) appContext.getBean("movieDao");
		movieDao.createMovie(lifeOfPi);
		movieDao.createMovie(dabangg2);

	}
}
