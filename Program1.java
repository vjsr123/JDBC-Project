package com.learn.jdbcprogram;
import java.sql.*;

public class Program1 {

	public static void main(String[] args) 
	{
		try 
		{
			String url = "jdbc:mysql://localhost:3306/jdbc_database";
			String username = "root";
			String password = "Jaga@123";

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");

			Connection con= DriverManager.getConnection(url,username,password);
			System.out.println("Connection is established at "+con);
		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
	}
}
