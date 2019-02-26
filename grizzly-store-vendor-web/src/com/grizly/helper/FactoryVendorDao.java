package com.grizly.helper;

import com.grizly.dao.VendorDaoInterface;
import com.grizly.dao.VendorDaoInterfaceImpl;

public class FactoryVendorDao {
	
	public static VendorDaoInterface createAdminDao(){
		
	     VendorDaoInterface vendordao =	new VendorDaoInterfaceImpl();
	     return vendordao;
}}
