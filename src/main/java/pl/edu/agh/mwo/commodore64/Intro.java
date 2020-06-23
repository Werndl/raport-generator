package pl.edu.agh.mwo.commodore64;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Intro {

	private static String reportsPath;

	public static String welcomePage() {

		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Witamy w programie raportów pracowniczych!\n");

		return getPath();
	}

	private static String getPath() {
		try {
			Scanner scan = new Scanner(System.in);

			System.out.print("Proszę podać scieżkę katalogu danych: ");
			reportsPath = scan.nextLine();
			File file = new File(reportsPath);
			if (file.exists()) {
				System.out.println("++++++++++++++++++++++++++++++++++++++++++");
				return reportsPath;
			} else {
				System.out.println("\nPODANA SCIEŻKA JEST BŁĘDNA\n");
				getPath();
			}
		} catch (NoSuchElementException err) {
			System.out.println("\nPODANA SCIEŻKA JEST BŁĘDNA\n");
			getPath();
		}
		return reportsPath;
	}
	
	public static String getReportsPath() {
		return reportsPath;
	}

	public static void setReportsPath(String reportsPath) {
		Intro.reportsPath = reportsPath;
	}

	public static void app() {
		String reportsPath = Intro.welcomePage();
		PathCommander.getPath(reportsPath);
		
		ReportsSelector reportSelector = new ReportsSelector();
		  reportSelector.SelectReport();
	}
}
