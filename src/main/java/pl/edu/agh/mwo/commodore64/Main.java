package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		/*String path = Intro.welcomePage();
		ReportsSelector reportSelector = new ReportsSelector();
		reportSelector.SelectReport();

		PathCommander.getPath(path);*/
		
		GetDataFromExcel dataGetter = new GetDataFromExcel();
		dataGetter.initializePopulation("C:/Users/Acer/Downloads/dane/2018/01/Damian_Kowal.xls");
		
		/*for(Task t : dataGetter.getDataModel())
		{
			System.out.println("-----------");
			System.out.println("h " + t.getHours());
			System.out.println("m " + t.getMonth());
			System.out.println("y " + t.getYear());
			System.out.println("h " + t.getProject());
			System.out.println("h " + t.getPerson());
		}*/
		
		//Report5 report = new Report5(dataGetter.getDataModel(), "Projekt 1");
	}
}
