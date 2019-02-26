package com.grizly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grizly.DAO.AdminDaoInterface;
import com.grizly.helper.FactoryAdminDao;

/**
 * Servlet implementation class AdminLoginServletClass
 */
@WebServlet(name = "AdminLoginServlet", urlPatterns = { "/AdminLoginServlet" })
public class AdminLoginServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int status=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		AdminDaoInterface adminlogin=FactoryAdminDao.createAdminDao();
		boolean loginstatus=adminlogin.login(username, password, status);
		int uid=adminlogin.fetchuser(username, password);
		String user=adminlogin.fetchuserString(username, password);
		HttpSession session=request.getSession(true);
		session.setAttribute("uid", uid);
		session.setAttribute("username", user);
		if(loginstatus==true)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("Add-Product.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
