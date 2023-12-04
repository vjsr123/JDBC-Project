package com.learn.jdbcprogram;
import java.sql.*;
import java.util.Scanner;

public class ProgramJDBCApp {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc_database";
		String username =  "root";
		String password = "Jaga@123";
		// Establishing the connection 
		try
		{
			Connection con= DriverManager.getConnection(url,username,password);
			Scanner scan= new Scanner(System.in);
			while(true) {
			System.out.println("Enter 1 for show tables,Enter 2 for Creating table,Enter 3 for Reading the data,Enter 4 for inserting the data,Enter 5 for updating the data,Enter 6 for deleting the data");
			int choice = scan.nextInt();
			ProgramJDBC pjdbc = new ProgramJDBC();
			
				switch(choice)
				{
				case 1:pjdbc.showtables(con);
				break;
				case 2:pjdbc.create(con);
				break;
				case 3:pjdbc.select(con);
				break;
				case 4:pjdbc.insert(con);
				case 5:pjdbc.update(con);
				case 6:pjdbc.delete(con);
				}
			}
			


		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}



	}
}
