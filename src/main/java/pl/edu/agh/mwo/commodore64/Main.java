package pl.edu.agh.mwo.commodore64;

public class Main
{
	public static void main(String[] args)
	{
		String path = Intro.welcomePage();
		ReportsSelector reportSelector = new ReportsSelector();
		reportSelector.SelectReport();

		PathCommander.getPath(path);
		
		//GetDataFromExcel dataGetter = new GetDataFromExcel();
		//dataGetter.initializePopulation("C:/Users/Acer/Desktop/reporter-dane/2012/02/Kowalski_Jan.xls");
	}
}
