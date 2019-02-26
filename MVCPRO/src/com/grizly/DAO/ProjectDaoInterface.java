package com.grizly.DAO;

public interface ProjectDaoInterface {
	public boolean productExists(String category,String name);
	public boolean addProduct(int pid, String pname, String pdesc,String pcategory ,String pbrand,int pprice);
	
	
}
