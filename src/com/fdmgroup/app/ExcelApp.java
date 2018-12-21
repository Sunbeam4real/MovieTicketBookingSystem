package com.fdmgroup.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fdmgroup.dao.MovieDao;
import com.fdmgroup.model.Movie;

public class ExcelApp {
	public void excelDataExchange() throws IOException {
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
