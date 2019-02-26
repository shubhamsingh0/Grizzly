package com.grizly.helper;

import com.grizly.DAO.ProjectDaoInterface;
import com.grizly.DAO.ProjectDaoInterfaceImpl;

public class FactoryProductDao {

	public static ProjectDaoInterface createProductDao()
	{
		ProjectDaoInterface productdao=new ProjectDaoInterfaceImpl();
		
		
		return  productdao;
	}
	
}
