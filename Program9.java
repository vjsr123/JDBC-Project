package com.learn.jdbcprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Program9 {

	public static void main(String[] args) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbc_database";
		String username = "root";
		String password ="Jaga@123";
		Connection con =DriverManager.getConnection(url,username,password);
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter  1 to insert,2 to update ,3 to delete,4 to select and any othre number to terminate");
			int choice = scan.nextInt();
			if(choice ==1)
			{
				insert(con);
			}
			else if (choice ==2)
			{
				update(con);
			}
			else if(choice ==3)
			{
				delete(con);
			}
			else if(choice ==4)
			{
				select(con);
			}
			else
			{
				System.out.println("Incorrect choice");
			}
		}
	}
	public static void insert(Connection con) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no.of rows you want to insert:");
		int rows = scan.nextInt();
		for(int i=1;i<=rows;i++)
		{
			System.out.println("Enter the id: ");
			int id = scan.nextInt();
			System.out.println("Enter the name: ");
			String name = scan.next();
			System.out.println("Enter the salary: ");
			int salary = scan.nextInt();
			String Query = "INSERT INTO EMPLOYEE VALUES(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setInt(3,salary);
			pstmt.executeUpdate();
			System.out.println((i)+"Row is Inserted");
		}
	}

	public static void update(Connection con) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no.of rows to update");
		int rows = scan.nextInt();
		for(int i=1;i<=rows;i++)
		{
			System.out.println("Enter the new  salary : ");
			int salary = scan.nextInt();
			System.out.println("Enter the id you want to update: ");
			int id = scan.nextInt();
			String Query = "UPDATE EMPLOYEE SET SALARY=? WHERE id =?";
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.setInt(1,salary);
			pstmt.setInt(2,id);
			pstmt.executeUpdate();
			System.out.println("Data is Updated");
		}
	}
	public static void delete(Connection con) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no.of rows to be deleted:");
		int rows = scan.nextInt();
		for(int i=1;i<=rows;i++)
		{
			System.out.println("Enter the id to be deleted : ");
			int id =  scan.nextInt();
			String Query = "DELETE FROM EMPLOYEE WHERE ID = ? ";
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
			System.out.println("Row you have entered is Deleted");
		}
	}
	public static void select(Connection con) throws Exception
	{
		String Query = "SELECT * FROM EMPLOYEE WHERE ID =?";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id to be selected : ");
		int id =  scan.nextInt();
		PreparedStatement pstmt = con.prepareStatement(Query);
		pstmt.setInt(1,id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}

	}

}
