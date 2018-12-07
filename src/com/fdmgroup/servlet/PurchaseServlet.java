package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.BookingDao;
import com.fdmgroup.dao.MovieDao;
import com.fdmgroup.dao.SeatingDao;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Movie;
import com.fdmgroup.model.Seating;
import com.fdmgroup.model.User;

public class PurchaseServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();

		
		if (session.getAttribute("loggedInUser") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else {
			User u = (User) session.getAttribute("loggedInUser");
			BookingDao bdao = new BookingDao();
			int temp = u.getId();
			List<Seating> seatingList = (ArrayList<Seating>)session.getAttribute("s");
			for (Seating s : seatingList) {
				System.out.println("here" +request.getParameter(s.getId()+""));
				if (request.getParameter(s.getId()+"") != "") {
					Booking b = new Booking(s.getId(), temp, Integer.parseInt(request.getParameter(s.getId()+"")));
					bdao.create(b);
				}
				
				
			}

			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			
		}
		
		
	}
}
