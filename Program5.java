package com.learn.jdbcprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program5 {

	public static void main(String[] args) {
		try
		{
			String url = "jdbc:mysql://localhost:3306/jdbc_database";
			String username = "root";
			String password = "Jaga@123";
			String Query = "DELETE FROM MSTUDENT WHERE ROLL_NO=3";
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
		// TODO Auto-generated method stub

	}

}
