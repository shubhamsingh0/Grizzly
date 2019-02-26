package com.grizly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grizly.DAO.ProjectDaoInterface;
import com.grizly.helper.FactoryProductDao;

/**
 * Servlet implementation class ProductServletClass
 */
@WebServlet(name = "ProductServlet", urlPatterns = { "/ProductServlet" })
public class ProductServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       boolean productexists=false;
       boolean productadded=false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(request.getParameter("product_id"));
		int pprice=Integer.parseInt(request.getParameter("product_price"));
		String pcategory=request.getParameter("product_category");
		String  pname=request.getParameter("product_name");
		String pdesc=request.getParameter("product_description");
		String pbrand=request.getParameter("product_brand");
		
		ProjectDaoInterface productDao=FactoryProductDao.createProductDao();
		
		productexists=productDao.productExists(pcategory,pname);
		
		if(productexists)
		{
			System.out.println("Product Already Exists");
			RequestDispatcher dispatcher=request.getRequestDispatcher("Add-Product.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			productadded=productDao.addProduct(pid, pname, pdesc, pcategory, pbrand, pprice);
			if(productadded) {
				System.out.println("Product Added Successfully");
				RequestDispatcher dispatcher=request.getRequestDispatcher("ViewServlet");
				dispatcher.forward(request, response);
			}
		}
		
		
		
		
		
		
		
	}

}
