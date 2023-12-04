package com.learn.jdbcprogram;
import java.sql.*;
public class Program2 {

	public static void main(String[] args)
	{
		try
		{
			String url = "jdbc:mysql://localhost:3306/jdbc_database";
			String username = "root";
			String password = "Jaga@123";
			String Query ="CREATE TABLE STUDENT (ROLL_NO INT,NAME VARCHAR(15))";
			//Establishing the connection
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established");
			//creating the connection using statement
			Statement stmt = con.createStatement();
			//Executing the query using statement
			stmt.execute(Query);
			System.out.println("Query is executed");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}


	}

}
