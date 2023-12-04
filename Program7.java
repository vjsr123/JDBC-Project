package com.learn.jdbcprogram;
import java.sql.*;
import java.util.Scanner;

public class Program7 {

	public static void main(String[] args) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbc_database";
		String username = "root";
		String password ="Jaga@123";
		Connection con =DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement();
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter  1 to insert,2 to update ,3 to delete,4 to select and any othre number to terminate");
			int choice = scan.nextInt();
			if(choice ==1)
			{
				insert(stmt);
			}
			else if (choice ==2)
			{
				update(stmt);
			}
			else if(choice ==3)
			{
				delete(stmt);
			}
			else if(choice ==4)
			{
				select(stmt);
			}
			else
			{
				System.out.println("Incorrect choice");
			}
		}
	}
	public static void insert(Statement stmt) throws Exception
	{
		String Query = "INSERT INTO EMPLOYEE VALUES(1,'AJAY',35000),(2,'ANKIT',45000),(3,'AMIT',55000)";
		stmt.executeUpdate(Query);
		System.out.println("Row is Inserted");
	}
	public static void update(Statement stmt) throws Exception
	{
		String Query = "UPDATE EMPLOYEE SET SALARY=65000 WHERE SALARY =55000";
		stmt.executeUpdate(Query);
		System.out.println("Data is Updated");
	}
	public static void delete(Statement stmt) throws Exception
	{
		String Query = "DELETE FROM EMPLOYEE WHERE ID=3";
		stmt.executeUpdate(Query);
		System.out.println("Row is Deleted");
	}
	public static void select(Statement stmt) throws Exception
	{
		String Query = "SELECT * FROM EMPLOYEE";
		stmt.executeQuery(Query);
	}

}
