package com.grizly.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grizly.DAO.ViewDaoInterface;
import com.grizly.entity.ProductClass;
import com.grizly.helper.FactoryViewDao;

/**
 * Servlet implementation class ViewServletClass
 */
@WebServlet(name = "ViewServlet", urlPatterns = { "/ViewServlet" })
public class ViewServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ViewDaoInterface view=FactoryViewDao.createView();
		List<ProductClass> list=view.getinfo();
		request.setAttribute("productList", list);
	
		System.out.println("view product in jsp added");
		System.out.println(list.size());
		RequestDispatcher dispatcher=request.getRequestDispatcher("List-Product.jsp");

		dispatcher.forward(request, response);
	}

}
