package com.fdmgroup.app;
import java.util.List;

import com.fdmgroup.dao.DbConnection;
import com.fdmgroup.dao.MovieDao;
import com.fdmgroup.dao.SeatingDao;
import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.Movie;
import com.fdmgroup.model.Seating;
import com.fdmgroup.model.User;

public class MainApp {
public static void main(String[] args) {
	Movie m = new Movie("The Godfather", "2h 55min", "Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan", "Crime, Drama");
	Movie m2 = new Movie("Coco", "1h 45min", "Lee Unkrich, Adrian Molina", "Anthony Gonzalez, Gael García Bernal", " Animation, Adventure, Comedy");
	Movie m3 = new Movie("The Grand Budapest Hotel", "1h 39min", "Wes Anderson", "Ralph Fiennes, F. Murray Abraham", "Adventure, Comedy, Drama");
	Movie m4 = new Movie("Reservoir Dogs", "1h 39min", "Quentin Tarantino", "Harvey Keitel, Tim Roth, Michael Madsen", "Crime, Drama, Thriller");
	MovieDao mdao = new MovieDao();
	mdao.create(m4);
	mdao.create(m3);
	mdao.create(m2);
	mdao.create(m);
	
	
	Seating s = new Seating("The Godfather", 200, "Regular", "2018 Dec 28th 17:00", 10.00, 1);
	Seating s1 = new Seating("The Godfather", 100, "IMAX", "2018 Dec 28th 20:00", 29.99, 2);
	Seating s2 = new Seating("The Godfather", 100, "D-BOX", "2018 Dec 28th 17:00", 30.00, 3);
	SeatingDao sdao = new SeatingDao();
	sdao.create(s);
	sdao.create(s1);
	sdao.create(s2);
	System.out.println("fuck");
	List<Seating> sl = sdao.findByMoviename("The Godfather");
	System.out.println(sl.size());
	
	}
	
}
