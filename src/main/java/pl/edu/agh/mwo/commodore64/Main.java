package pl.edu.agh.mwo.commodore64;

public class Main
{
	public static void main(String[] args)
	{
		GetDataFromExcel dataGetter = new GetDataFromExcel();
		dataGetter.initializePopulation("C:/Users/Acer/Desktop/reporter-dane/2012/02/Kowalski_Jan.xls");
		//"Dane zosta�y wczytane"
		//stworzenie Workbooka do tabeli zbiorczej, kt�ry b�dzie przekazywany do funkcji
		
		//GUI + -> nowa klasa (Workbook) -> report1(Workbook, String date, String name) (...)
		
		//usuni�cie tabeli zbiorczej
	}
}
