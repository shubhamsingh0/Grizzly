package com.grizly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grizly.dao.VendorDaoInterface;

import com.grizly.helper.FactoryVendorDao;

/**
 * Servlet implementation class VendorServletClass
 */
@WebServlet(name = "VendorServlet", urlPatterns = { "/VendorServlet" })
public class VendorServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 int status=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		VendorDaoInterface adminlogin=FactoryVendorDao.createAdminDao();
		boolean loginstatus=adminlogin.login(username, password, status);
	
		String user=adminlogin.fetchuserString(username, password);
		HttpSession session=request.getSession(true);
		
		session.setAttribute("username", user);
		
		if(loginstatus==true)
		{System.out.println("login successful");
		//	RequestDispatcher dispatcher=request.getRequestDispatcher("Add-Product.jsp");
			//dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
		}
		
		
	}

}
