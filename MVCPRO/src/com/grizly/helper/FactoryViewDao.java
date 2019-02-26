package com.grizly.helper;

import com.grizly.DAO.ViewDaoInterface;
import com.grizly.DAO.ViewDaoInterfaceImpl;


public class FactoryViewDao {

	public static ViewDaoInterface createView()
	{
		ViewDaoInterface view=new ViewDaoInterfaceImpl();
		return view;
	}
}
