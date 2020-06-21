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

//		PathCommander.getPath("E:\\jnodz\\Documents\\IT\\PROJEKT\\dane");

		/*for(Task t : PathCommander.getDataModel())
		{
			System.out.println("-----------");
			System.out.println("h " + t.getHours());
			System.out.println("m " + t.getMonth());
			System.out.println("y " + t.getYear());
			System.out.println("h " + t.getProject());
			System.out.println("h " + t.getPerson());
		}*/
		Report3 report = new Report3(PathCommander.getDataModel(), "2018", "Damian Kowal");
		Report5 report1 = new Report5(PathCommander.getDataModel(), "Projekt 2");
		Report1 report2 = new Report1(PathCommander.getDataModel(), "2018");

		//TO FIX - issue with long name -???
		//Report3 report3 = new Report3(PathCommander.getDataModel(), "2018", "Katarzyna Mara");
	}
}
