package pl.edu.agh.mwo.commodore64;

public class Main
{
	public static void main(String[] args)
	{
		GetDataFromExcel dataGetter = new GetDataFromExcel();
		dataGetter.initializePopulation("C:/Users/Acer/Desktop/reporter-dane/2012/02/Kowalski_Jan.xls");
		//"Dane zosta³y wczytane"
		//stworzenie Workbooka do tabeli zbiorczej, który bêdzie przekazywany do funkcji
		
		//GUI + -> nowa klasa (Workbook) -> report1(Workbook, String date, String name) (...)
		
		//usuniêcie tabeli zbiorczej
	}
}
