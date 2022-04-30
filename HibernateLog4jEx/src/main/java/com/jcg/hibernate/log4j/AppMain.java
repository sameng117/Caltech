package com.jcg.hibernate.log4j;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppMain {

	static Logger logger = Logger.getLogger(AppMain.class);

	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 

		// Creating Hibernate SessionFactory Instance
		SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void main(String[] args) {	
		Employee empObj = null;
		Session sessionObj = null;
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			for(int i = 101; i <= 105; i++) {
				empObj = new Employee();							
				empObj.setEmpId(i);
				empObj.setEmpName("Emp. " + i);
				empObj.setEmpSal(10000);
				sessionObj.save(empObj);
			}

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();

			logger.info(".......Records Saved Successfully To The Database.......");
		} catch(Exception exObj) {
			sessionObj.getTransaction().rollback();
			logger.error(".......Transaction Is Being Rolled Back......." + exObj);			
		} finally {	
			sessionObj.flush();
			sessionObj.close();
		}
	}
}