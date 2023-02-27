package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;
 
@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath();
		
		switch(path) 
		{
			case "/logCustomer":
				validateCustomer(request,response);
				break;
			case "/regCustomer":
				insertCustomer(request,response);
				break;
			case "/log":
				getLoginPage(request,response);
				break;
			case "/reg":
				getRegistationPage(request,response);
				break;
			default:
				getStartUpPage(request, response);
				break;
		}	
	}

 
	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//read the email and password from jsp page
		String email =request.getParameter("tbEmail");
		String password = request.getParameter("tbPass");
		
		//call method present in dao
		boolean res =  DataAccess.validateCustomer(email, password);
		
		//condition and redirect user to destination page
		if(res) {
			try {
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				//store the successPage class data inside the rd
				SuccessPage sp = new SuccessPage();
				request.setAttribute("successDetails", sp);
				rd.forward(request, response);
			} catch (ServletException e) {
				 
				e.printStackTrace();
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
		}else {
			getLoginPage(request,response);
		}
		
		 
		
	}


	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
		 
		//read the data from jsp page
		String name = request.getParameter("tbName");
		String email = request.getParameter("tbEmail");
		long mobile = Long.parseLong(request.getParameter("tbMobile"));
		String password = request.getParameter("tbPass");
		String states = request.getParameter("ddlStates");
		
		
		//store that data in customer object
		Customer customer = new Customer(name, email, mobile, password, states);
		
		//call insertCustomer method present in dao by passing above object
		DataAccess.insertCustomer(customer);
		
		//redirect to login page with email and password	
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		
		
		
	}
	


	private void getRegistationPage(HttpServletRequest request, HttpServletResponse response) {
		 
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_registration.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		 
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_managment.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException e) { 
			e.printStackTrace();
		}
		 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}

