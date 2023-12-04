package com.learn.jdbcprogram;

import java.sql.*;

public class StudentApp {

	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/jdbc_database";
		String username = "root";
		String password = "Jaga@123";
		//Establishing the Connection
		Connection con;
		try 
		{
			con = DriverManager.getConnection(url,username,password);
			Statement stmt =con.createStatement();
			System.out.println("Connection Established");
			Student st1=new Student(11,"Jaga",22);
			DBHandler.insert(con,st1.roll_no,st1.name,st1.age);
			Student st2=new Student(22,"Raj",23);
			DBHandler.insert(con,st2.roll_no,st2.name,st2.age);
			Student st3=new Student(33,"Madhu",24);
			DBHandler.insert(con,st3.roll_no,st3.name,st3.age);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
