package com.dhruv.testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJDBC
{
	public static void main(String args[])
	{
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String user = "Springstudent";
		String pass= "Springstudent";
		try{
			System.out.println("Connecting to database: "+jdbcUrl);
			Connection conn= DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection Successfull");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
