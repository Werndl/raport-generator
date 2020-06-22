package pl.edu.agh.mwo.commodore64;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelPrinter {

	private static ArrayList<String[]> data = new ArrayList<>();
	
	public static ArrayList<String[]> createStringTemplate(String[] values) {

			data.add(values);

		return data;
	}

	public static void printToExcel(String[] columns,ArrayList<String[]> data) {
		try {
			ReportsExtractor.writeExcel(columns, data);
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}

