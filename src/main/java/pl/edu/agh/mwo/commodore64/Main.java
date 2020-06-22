package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
//		String reportsPath = Intro.welcomePage();
//		PathCommander.getPath(reportsPath);
//		ReportsSelector reportSelector = new ReportsSelector();
//		reportSelector.SelectReport();

		PathCommander.getPath("C:\\Users\\Beata\\Desktop\\dane");
		
		/*for(Task t : PathCommander.getDataModel())
		{
			System.out.println("-----------");
			System.out.println("h " + t.getHours());
			System.out.println("m " + t.getMonth());
			System.out.println("y " + t.getYear());
			System.out.println("h " + t.getProject());
			System.out.println("h " + t.getPerson());
		}*/

//		Report1 report1 = new Report1(PathCommander.getDataModel(), "2018");

//		Report2 report2 = new Report2(PathCommander.getDataModel(), "2018");

		Report3 report3 = new Report3(PathCommander.getDataModel(), "2018", "Damian Kowal");
//		Report3 report3 = new Report3(PathCommander.getDataModel(), "2018", "Kamil Kosa");
//		Report3 report3 = new Report3(PathCommander.getDataModel(), "2018", "Katarzyna Mara");
//
// 		Report5 report5 = new Report5(PathCommander.getDataModel(), "Projekt 2");
	}
}