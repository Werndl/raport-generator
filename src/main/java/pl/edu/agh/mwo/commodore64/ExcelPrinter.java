package pl.edu.agh.mwo.commodore64;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExcelPrinter {

	public static void printToExcel(String[] columns, ArrayList<String[]> data) {
		try {
			if (data.isEmpty()) {
				System.out.println("Raport jest pusty - plik nie zostanie wygenerowany");
			} else {
				ReportsExtractor.writeExcel(columns, data);
				System.out.println("Wygenerowany raport jest dostępny w wybranej lokalizacji!");
			}
		} catch (IOException e) {
			System.out.println("PODANA ŚCIEŻKA JEST BŁĘDNA. Powrót do Menu");
			//e.printStackTrace();
		}
	}

	public static void checkIfUserWantToPrintExcel(int raport) {
		if (validateEmptyData(raport)) {
			Scanner scan = new Scanner(System.in);
			System.out.println("\nCzy chcesz wygenerować raport do pliku Excel?");
			System.out.println("WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: ");

			String generationStatus = scan.next();

			if (generationStatus.equals("1")) {
				switch (raport) {
				case 1:
					printToExcel(Report1.getColumns(), Report1.getData());
					break;
				case 2:
					printToExcel(Report2.getColumns(), Report2.getData());
					break;
				case 3:
					printToExcel(Report3.getColumns(), Report3.getData());
					break;
//				case 4:
//					printToExcel(Report4.getColumns(), Report4.getData());
//					break;
				case 5:
					printToExcel(Report5.getColumns(), Report5.getData());
					break;
				default:
					System.out.println("Błąd generacji. Powrót do Menu");
					break;
				}
			}
		}
	}

	private static boolean validateEmptyData(int raport) {

		switch (raport) {
		case 1:
			if (Report1.getData().isEmpty() || Report1.getData() == null) {
				return false;
			}
			break;
		case 2:
			if (Report2.getData().isEmpty() || Report2.getData() == null) {
				return false;
			}
			break;
		case 3:
			if (Report3.getData().isEmpty() || Report3.getData() == null) {
				return false;
			}
			break;

//		case 4:
//			if (Report4.getData().isEmpty() || Report4.getData() == null) {
//				return false;
//			}
//			break;

		case 5:
			if (Report5.getData().isEmpty() || Report5.getData() == null) {
				return false;
			}
			break;
		default:
			System.out.println("Błąd generacji. Powrót do Menu");
			break;
		}

		return true;
	}
}
