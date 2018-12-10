package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.User;

public class ModifyServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("this");
		String newfname = request.getParameter("fname");
		String newlname = request.getParameter("lname");
		String newpassword = request.getParameter("newp");
		UserDao udao = new UserDao();
		HttpSession session = request.getSession();
		System.out.println("dogfight");

		User foundUser = (User) session.getAttribute("loggedInUser");
		System.out.println("dogfight");
		foundUser.setFirstname(newfname);
		foundUser.setLastname(newlname);
		foundUser.setPassword(newpassword);
		udao.update(foundUser);
		
		RequestDispatcher rd = request.getRequestDispatcher("service.jsp");
		rd.forward(request, response);
				
				
			
		
		
	}

}
