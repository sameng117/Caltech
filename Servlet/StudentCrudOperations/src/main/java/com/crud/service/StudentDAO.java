package com.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.crud.model.Student;

public class StudentDAO {
	private static Connection getConnection() {
		Connection con=null;
		//Step 1 : load Driver in memory
		try {
			//to call Class loader to load class in memory at dymanic time
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
			//Step 2: Database information 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cred", "root","Comnet@123");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}
		public int insertData(Student student) {
			int result=0;
			try {
			Connection con=getConnection();
			
			java.sql.Date sdob=new java.sql.Date(student.getDOB().getTime());
			//To insert records 
			PreparedStatement ps=con.prepareStatement("insert into studentDetails(rollno, studname,dob) values(?,?,?)");
			ps.setInt(1,student.getRollno());
			ps.setString(2,student.getStudname());
			ps.setDate(3, sdob);
			result=ps.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
}
