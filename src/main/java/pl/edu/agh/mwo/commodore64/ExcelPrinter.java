package pl.edu.agh.mwo.commodore64;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExcelPrinter {

	private static ArrayList<String[]> data = new ArrayList<>();
	
	public static ArrayList<String[]> createStringTemplate(String[] values) {

			data.add(values);

		return data;
	}

	public static void printToExcel(String[] columns,ArrayList<String[]> data) {
		try {
			if (data.isEmpty()) {
				System.out.println("Raport jest pusty - plik nie zostanie wygenerowany.");
			}
			else {
			ReportsExtractor.writeExcel(columns, data);
	        System.out.println("Wygenerowany raport jest dostepny w wybranej lokalizacji!");
			}
		} catch (IOException e) {
			System.out.println("Podana sciezka jest bledna. Powrot do Menu");
			//e.printStackTrace();
		}
	}
	
	public static void checkIfUserWantToPrintExcel(int raport) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nCzy chcesz wygenerowac raport do pliku Excel?");
		System.out.println("WPISZ: 1 jesli TAK, wcisnij inny klawisz jesli NIE: ");
		
		String generationStatus = scan.next();
		
		if (generationStatus.equals("1")){
			switch (raport) {
			case 1:
				printToExcel(Report1.getColumns(), Report1.getData());
				break;
			case 2:
				//printToExcel(Report2.getColumns(), Report2.getData());
				break;
			case 3:
				printToExcel(Report3.getColumns(), Report3.getData());
				break;
			case 4:
				//printToExcel(Report4.getColumns(), Report4.getData());
				break;
			case 5:
				printToExcel(Report5.getColumns(), Report5.getData());
				break;
			default:
				System.out.println("Blad generacji. Powrot do Menu");
				break;
			}			
		}
	}
}

