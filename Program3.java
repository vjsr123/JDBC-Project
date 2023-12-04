package com.learn.jdbcprogram;
import java.sql.*;

public class Program3 {

	public static void main(String[] args)
	{
		try
		{
			String url ="jdbc:mysql://localhost:3306/jdbc_database";
			String username = "root";
			String password = "Jaga@123";
			String Query = "INSERT INTO STUDENT VALUES(1,'JAGA'),(2,'RAJA'),(3,'MADHU')";
			//Establishing connection
			Connection con =DriverManager.getConnection(url, username, password);
			System.out.println("Connection established");
			//Creating the statement
			Statement stmt = con.createStatement();
			//Executing the Query
			stmt.execute(Query);
			System.out.println("Query is Executed ");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
