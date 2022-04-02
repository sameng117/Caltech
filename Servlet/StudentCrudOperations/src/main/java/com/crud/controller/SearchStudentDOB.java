package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.model.Student;
import com.crud.service.StudentDAO;


@WebServlet("/SearchStudentDOB")
public class SearchStudentDOB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchStudentDOB() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno=	Integer.parseInt(request.getParameter("txtRollno"));
		StudentDAO sdao=new StudentDAO();
		/*String ans=sdao.getStudentDOB(rollno);
		PrintWriter out=response.getWriter();
		out.println("student DOB="+ans);*/
		ArrayList<Student> list=new StudentDAO().getStudentDOB();
		PrintWriter out=response.getWriter();
		out.println("<table border=2>");
		for(Student student:list) {
			out.println("<tr><td>"+student.getRollno()+"</td><td> "+student.getStudname()+"</td><td> "+student.getDOB()+"</td> ");
		out.println("<td><a href='EditServlet?rollno="+student.getRollno()+"'>edit</a></td>");
		out.println("<td><a href='DeleteServlet?rollno="+student.getRollno()+"'>delete</a></td></tr>");
}
		
		out.println("</table>");
		
		
		
	}

}
