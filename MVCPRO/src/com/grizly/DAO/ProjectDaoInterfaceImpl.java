package com.grizly.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.grizly.helper.DatabaseConnectionClass;

public class ProjectDaoInterfaceImpl implements ProjectDaoInterface {
	public boolean flag=false;
	public boolean flagexists=false;
	private Connection connection=null;
	String cat="";
	String nam="";
	public boolean productExists(String pcategory,String pname) {
		connection = DatabaseConnectionClass.getConnection();
		try {
			connection=DatabaseConnectionClass.getConnection();
			PreparedStatement statement=connection.prepareStatement("select PCATEGORY,PNAME from product where PCATEGORY=? or PNAME=?");
			
			statement.setString(1,pcategory);
			statement.setString(2,pname);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				cat=resultset.getString("PCATEGORY");
				
				nam=resultset.getString("PNAME");
				
				if(cat.equals(pcategory)||nam.equals(pname)) {
					flagexists=true;
					
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(flagexists) {
			return flagexists;
		}else
			{ flagexists=false;
			return flagexists;
			}
			}
	
	
	public  boolean addProduct(int pid, String pname, String pdesc,String pcategory ,String pbrand,int pprice) {

		try {
			connection=DatabaseConnectionClass.getConnection();
			PreparedStatement statement=connection.prepareStatement("INSERT INTO product (PID, PPRICE, PCATEGORY, PNAME, PDESCRIPTION, PBRAND) VALUES (?,?,?,?,?,?)");
			statement.setInt(1, pid);
			statement.setInt(2, pprice);
			statement.setString(3,pcategory);
			statement.setString(4, pname);
			statement.setString(5, pdesc);
			statement.setString(6, pbrand);
			int row=statement.executeUpdate();
			if(row>0)
			{
				flag=true;
			}
			else
			{flag=false;
			}	
			DatabaseConnectionClass.closeConnection(connection);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return flag;	
	}
}
