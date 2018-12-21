package com.fdmgroup.app;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fdmgroup.dao.DbConnection;
import com.fdmgroup.dao.MovieDao;
import com.fdmgroup.dao.SeatingDao;
import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.Movie;
import com.fdmgroup.model.Seating;
import com.fdmgroup.model.User;

public class MainApp {
public static void main(String[] args) throws IOException {
	/*Movie m = new Movie("1", "The Godfather", "2h 55min", "Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan", "Crime, Drama", "img/godgather.jpg", "The aging patriarch of an organized crime dynasty transfers control of his ...", "yes");
	Movie m2 = new Movie("2", "Coco", "1h 45min", "Lee Unkrich, Adrian Molina", "Anthony Gonzalez, Gael García Bernal", " Animation, Adventure, Comedy", "img/coco2.jpg", "Aspiring musician Miguel, confronted with his family's ancestral ban on music...", "yes");
	Movie m3 = new Movie("3", "The Grand Budapest Hotel", "1h 39min", "Wes Anderson", "Ralph Fiennes, F. Murray Abraham", "Adventure, Comedy, Drama", "img/hotel.jpg","A legendary concierge at a famous European hotel between the wars and...", "yes");
	Movie m4 = new Movie("4", "Reservoir Dogs", "1h 39min", "Quentin Tarantino", "Harvey Keitel, Tim Roth, Michael Madsen", "Crime, Drama, Thriller", "img/dogs.jpg", "A botched robbery indicates a police informant, and the pressure mounts in the...", "yes");
	Movie m5 = new Movie("5", "Back to the Future", "1h 48min", "Robert Zemeckis", "Michael J. Fox, Christopher Lloyd, Lea Thompson", "Adventure, Comedy, Sci-Fi", "img/backtofuture.jpg", "After visiting 2015, Marty McFly must repeat his visit to 1955 to prevent disastrous changes to 1985...", "yes");
	MovieDao mdao = new MovieDao();
	mdao.create(m5);
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
	System.out.println(sl.size());*/
	
	FileInputStream fis = new FileInputStream(new File("test.xlsx"));
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	
	
	XSSFSheet sheet = wb.getSheetAt(0);
	String[] arr = new String[9];
	int index = 0;
	Iterator<Row> rowIt = sheet.iterator();
	MovieDao mdao = new MovieDao();

	while(rowIt.hasNext()) {
		index = 0;
		Row row = rowIt.next();
		Iterator<Cell> cellIt = row.cellIterator();
		while (cellIt.hasNext()) {
			Cell cell = cellIt.next();
			if (index == 0) {
				String temp = cell.toString();
				double num = Double.parseDouble(temp);
				int tempi = (int) num;
				arr[index] = Integer.toString(tempi);
				System.out.println(arr[index]);
			}
			else {
				arr[index] = cell.toString();
			}
			
			index++;
		}
		
		Movie m = new Movie(arr[0], arr[1], arr[2], arr[3],arr[4], arr[5], arr[6], arr[7],arr[8]);
		System.out.println(m.toString());
		mdao.update(m);
	}
	
	wb.close();
	fis.close();
	
	}
	
}
