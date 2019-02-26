package com.grizly.dao;

public interface VendorDaoInterface {
	public boolean login(String username,String password,int status);
	
	public String fetchuserString(String username,String password);
}
