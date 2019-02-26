package com.grizly.helper;

import com.grizly.DAO.AdminDaoInterface;
import com.grizly.DAO.AdminDaoInterfaceImpl;

public class FactoryAdminDao {
		
		public static AdminDaoInterface createAdminDao(){
			
		     AdminDaoInterface admindao =	new AdminDaoInterfaceImpl();
		     return admindao;
	}
}
