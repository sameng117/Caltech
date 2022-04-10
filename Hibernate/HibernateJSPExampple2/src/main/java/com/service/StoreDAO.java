package com.service;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.beans.Address;
import com.beans.EmployeeDetails;

/**
 * Servlet implementation class StudentDAO
 */
@WebServlet("/StudentDAO")
public class StoreDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public int register(EmployeeDetails employee)   {
    	
    	
    	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory=meta.getSessionFactoryBuilder().build();
    	int i=0;
    	try {
			Session session=factory.openSession();
			Transaction t=session.beginTransaction();
			i=(Integer)session.save(employee);
		
			t.commit();
			session.close();
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
    	return i;
    	
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// reading form values	
		EmployeeDetails e1=new EmployeeDetails();    
	    e1.setName("Kartik");    
	    e1.setEmail("Kartik@gmail.com");    
	        
	    Address address1=new Address();    
	    address1.setAddressLine1("F-9, ABC nagar");    
	    address1.setCity("Ghaziabad");    
	    address1.setState("UP");    
	    address1.setCountry("India");    
	    address1.setPincode(201301);    
	        
	    e1.setAddress(address1);    
	    address1.setEmployee(e1); 
	    
	int i=register(e1);
	
	PrintWriter out=response.getWriter();
	if(i>0)
	out.println("Record inserted");
	else
		out.println("Record not inserted");
	
	
	
	}

}
