package com.grizly.DAO;

public interface AdminDaoInterface {
	public boolean login(String username,String password,int status);
	public int fetchuser(String username,String password);
	public String fetchuserString(String username,String password);
}
