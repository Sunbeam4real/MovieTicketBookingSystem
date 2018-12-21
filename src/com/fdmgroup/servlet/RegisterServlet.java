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

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");

		UserDao udao = new UserDao();

		User u = new User(username, password, firstname, lastname);
		udao.create(u);
		
			HttpSession session = req.getSession();
			session.setAttribute("loggedInUser",u);
			session.setAttribute("username", username);

			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
			
			
		
	}
}
