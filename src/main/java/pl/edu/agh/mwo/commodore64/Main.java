package pl.edu.agh.mwo.commodore64;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		//String reportsPath = Intro.welcomePage();
		//PathCommander.getPath(reportsPath);
		//ReportsSelector reportSelector = new ReportsSelector();
		//reportSelector.SelectReport();

		//PathCommander.getPath("C:\\Users\\Acer\\Downloads\\dane");
		
		/*for(Task t : PathCommander.getDataModel())
		{
			System.out.println("-----------");
			System.out.println("h " + t.getHours());
			System.out.println("m " + t.getMonth());
			System.out.println("y " + t.getYear());
			System.out.println("h " + t.getProject());
			System.out.println("h " + t.getPerson());
		}*/

		String[] columns = {"Lp", "Miesiac", "Projekt", "Godziny [h]"};
		ArrayList<String[]> data = new ArrayList<>();
		data.add(columns);
		try {
			ReportsExtractor.writeExcel(columns, data);
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		//Report5 report1 = new Report5(PathCommander.getDataModel(), "Projekt 2");
		//Report1 report2 = new Report1(PathCommander.getDataModel(), "2018");
//		Report3 report3 = new Report3(PathCommander.getDataModel(), "2018", "Katarzyna Mara");
	}
}
