package com.learn.jdbcprogram;
import java.sql.*;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbc_database";
		String username ="root";
		String password ="Jaga@123";
		Connection con = DriverManager.getConnection(url,username,password);
	}
	public static void update(Connection con) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the amount you want send to suraj");
		int amount = scan.nextInt();
		String query = "UPDATE BANK SET BALANCE=? WHERE NAME=?";
		PreparedStatement pstmt = con.prepareStatement(query);
	}

}
