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

import com.fdmgroup.dao.MovieDao;
import com.fdmgroup.dao.SeatingDao;
import com.fdmgroup.model.Movie;
import com.fdmgroup.model.Seating;

public class MovieServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		MovieDao mdao = new MovieDao();
		String movieName = request.getParameter("moviename");
		System.out.println(movieName);
		Movie m = mdao.findByMoviename(movieName);
		HttpSession session = request.getSession();
		session.setAttribute("m", m);
		SeatingDao sdao = new SeatingDao();
		List<Seating> s = sdao.findByMoviename(movieName);
		session.setAttribute("s", s);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("movie.jsp");
		rd.forward(request, response);
		
	}
}
