package com.learn.jdbcprogram;

import java.util.Scanner;
import java.sql.*;

public class ProgramJDBC {
	public void showtables(Connection con) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		String Query = "SHOW TABLES";
		PreparedStatement pstmt = con.prepareStatement(Query);
		ResultSet rs = pstmt.executeQuery(); 
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
		System.out.println("Selected tables  from the database");

	}
	public void create(Connection con) throws Exception 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the table you want to create");
		String str = scan.next();
		String Query = "CREATE TABLE " + str + " (ID INT ,NAME VARCHAR(20))";
		PreparedStatement pstmt = con.prepareStatement(Query);
		pstmt.executeUpdate();	
	}
	public void select(Connection con) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the tablename you want to select");
		String tablename = scan.next();
		String Query = "SELECT * FROM "+tablename;
		PreparedStatement pstmt = con.prepareStatement(Query);
		ResultSet rs = pstmt.executeQuery(); 
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		System.out.println("Selected data from the table");
	}
	public void insert(Connection con) throws Exception 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the tablename you want to insert");
		String str = scan.next();
		System.out.println("Enter the id :");
		int id = scan.nextInt();
		System.out.println("Enter the name :");
		String name = scan.next();
		String Query = "INSERT INTO "+ str +" VALUES (?,?)";
		PreparedStatement pstmt = con.prepareStatement(Query);
		pstmt.setInt(1, id);
		pstmt.setString(2,name);
		pstmt.executeUpdate();	
		System.out.println("Row is Inserted ");
	}
	public void update(Connection con) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the tablename you want to update");
		String str = scan.next();
		System.out.println("Enter the id :");
		int id = scan.nextInt();
		System.out.println("Enter the name :");
		String name = scan.next();
		String Query = "UPDATE "+ str+" SET NAME =? WHERE ID =?";
		PreparedStatement pstmt = con.prepareStatement(Query);
		pstmt.setString(1,name);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();	
		System.out.println("Row is Updated ");
	}
	public void delete(Connection con) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the tablename you want to delete the rows in the table");
		String str = scan.next();
		System.out.println("Enter the id :");
		int id = scan.nextInt();
		String Query = "DELETE FROM "+str+" WHERE ID=?";
		PreparedStatement pstmt = con.prepareStatement(Query);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();	
		System.out.println("Row is Deleted ");
	}

}
