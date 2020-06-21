package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		/*String path = Intro.welcomePage();
		ReportsSelector reportSelector = new ReportsSelector();
		reportSelector.SelectReport();*/

		PathCommander.getPath("C:/Users/Acer/Downloads/dane");
		
		/*for(Task t : PathCommander.getDataModel())
		{
			System.out.println("-----------");
			System.out.println("h " + t.getHours());
			System.out.println("m " + t.getMonth());
			System.out.println("y " + t.getYear());
			System.out.println("h " + t.getProject());
			System.out.println("h " + t.getPerson());
		}*/
		
		Report5 report5 = new Report5(PathCommander.getDataModel(), "Projekt2");
		//Report1 report1 = new Report1(PathCommander.getDataModel(), "2018");
	}
}
