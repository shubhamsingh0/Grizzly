package com.grizly.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.grizly.entity.ProductClass;
import com.grizly.helper.DatabaseConnectionClass;

public class ViewDaoInterfaceImpl implements ViewDaoInterface{
	private Connection connection=null;
	
	List<ProductClass> result=new ArrayList<>();
	public List<ProductClass> getinfo() {
		try {
			connection=DatabaseConnectionClass.getConnection();
			PreparedStatement statement=connection.prepareStatement("select * from product");
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				ProductClass details=new ProductClass();
				details.setPid(resultset.getInt("PID"));
				details.setPcategory(resultset.getString("PCATEGORY"));
				details.setPname(resultset.getString("PNAME"));
				details.setDesc(resultset.getString("PDESCRIPTION"));
				details.setPprice(resultset.getInt("PPRICE"));
				details.setPbrand(resultset.getString("PBRAND"));
				details.setPrating(resultset.getInt("PRATING"));
				result.add(details);
			}
			
			System.out.println("No. of elements "+result.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
