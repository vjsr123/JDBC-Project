package com.learn.jdbcprogram;
import java.sql.*;

public class DBHandler 
{
	public static void insert(Connection con,int roll_no,String name,int age)
	{
		String Query="INSERT INTO STUDENT VALUES(?,?,?)";
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, roll_no);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.executeUpdate();
			System.out.println("Rows are inserted");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
