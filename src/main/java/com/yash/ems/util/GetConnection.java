package com.yash.ems.util;

/*
 * GetConnection class is used to create connection with mysql database and
 * it returns the instance of Connection
 * Here empldb is the database which contains employee1 table
 * 
 * @author kushagra.sharma

 */

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class GetConnection 
{
	public static Connection getConn()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/empldb";
			/**
			 * empldb is DataBase
			 * root is username
			 * Password99 is the password
			 */
			Connection con = (Connection) DriverManager.getConnection(url,"root","Password99");
			return con;
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 

		return null;

	}

}
