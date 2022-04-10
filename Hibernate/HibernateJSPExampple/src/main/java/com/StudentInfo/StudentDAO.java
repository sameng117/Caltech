package com.StudentInfo;


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

/**
 * Servlet implementation class StudentDAO
 */
@WebServlet("/StudentDAO")
public class StudentDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public int register(Student stud)   {
    	
    	
    	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory=meta.getSessionFactoryBuilder().build();
    	int i=0;
    	try {
			Session session=factory.openSession();
			Transaction t=session.beginTransaction();
			i=(Integer)session.save(stud);
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
	int marks=Integer.parseInt(request.getParameter("txtmarks"));
	String name=request.getParameter("txtName");
	// put values in Object
	Student stud=new Student();
	stud.setMarks(marks);
	stud.setName(name);

	int i=register(stud);
	
	PrintWriter out=response.getWriter();
	if(i>0)
	out.println("Record inserted");
	else
		out.println("Record not inserted");
	
	
	
	}

}
