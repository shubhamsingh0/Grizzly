package com.grizly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.grizly.helper.DatabaseConnectionClass;

public class VendorDaoInterfaceImpl implements VendorDaoInterface{
	private Connection connection=null;int status=0;
	boolean flag=false;
	 public boolean login(String user,String pass,int status) 
	 {
		connection=DatabaseConnectionClass.getConnection();
		try{
		PreparedStatement statement = connection.prepareStatement("select * from login where USERNAME=? and PASSWORD=?");
		statement.setString(1,user);
		statement.setString(2, pass);
		ResultSet resultset=statement.executeQuery();
		PreparedStatement countstatement=connection.prepareStatement("select count from login where USERNAME=?");
		countstatement.setString(1, user);
		ResultSet count=countstatement.executeQuery();
		int c=0;
		if(count.next()) {
			
			c=count.getInt("COUNT");
		}
		if(resultset.next()) {
														/*String s=resultset.getString("USERNAME");String p=resultset.getString("PASSWORD");System.out.println(s+"  "+p);*/
				status=resultset.getInt("STATUS");System.out.println("status");
				if(status==0 && c<3) {
				PreparedStatement s=connection.prepareStatement("UPDATE login SET COUNT = '0' where USERNAME=?");
				s.setString(1,user);
				s.executeUpdate();
				flag=true;
				}
		}
		else
		{	c++;
			if(c<=3 && status!=-1) {
			PreparedStatement s=connection.prepareStatement("UPDATE login SET COUNT = ? where USERNAME=?");
			s.setInt(1, c);
			s.setString(2, user);
			s.executeUpdate();
			flag=false;
			}
			else if(c>3)
			{
				 PreparedStatement state= connection.prepareStatement("UPDATE login SET STATUS = '-1' where USERNAME=?");
				 state.setString(1, user);
				 int row=state.executeUpdate();
				 if(row>0)
				 {
				System.out.println("Status Updated !!!   You cant log in now.\n Contact admin to unlock\n");
				 flag=false;
					 
				 }
			}
			
			
		}
		
		DatabaseConnectionClass.closeConnection(connection);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return flag; 
	}

	 public String fetchuserString(String username,String password) {
		 connection=DatabaseConnectionClass.getConnection();String  user="";
			try{
					PreparedStatement statement = connection.prepareStatement("select USERNAME from login where USERNAME=? and PASSWORD=?");
					statement.setString(1,username);
					statement.setString(2, password);
					ResultSet resultset=statement.executeQuery();
					
					if(resultset.next())
					{
						user=resultset.getString("USERNAME");
					}
					
			 }catch(Exception e){
				 e.printStackTrace();
			 }return user;
	 }
}
