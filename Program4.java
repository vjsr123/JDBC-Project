package com.learn.jdbcprogram;

import java.sql.*;
import java.sql.DriverManager;

public class Program4 {

	public static void main(String[] args)
	{
		try
		{
			String url = "jdbc:mysql://localhost:3306/jdbc_database";
			String username = "root";
			String password = "Jaga@123";
			String Query = "UPDATE STUDENT SET NAME ='ANKIT' WHERE NAME='MADHU'";
			//Establishing the connection
			Connection con = DriverManager.getConnection(url, username, password);
			//Creating the statement
			Statement stmt =con.createStatement();
			//Executing the statement
			stmt.executeUpdate(Query);
			System.out.println("Query is Executed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
