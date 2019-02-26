package com.grizly.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionClass {
	public final static String driver="com.mysql.jdbc.Driver";
	public final static String url="jdbc:mysql://localhost:3306/adminlogin";
	public final static String uname="root";
	public final static String pass="root";
	
	public static Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(url,uname,pass);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;	
	}
	public static Connection closeConnection(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return connection;
	}
	
}
