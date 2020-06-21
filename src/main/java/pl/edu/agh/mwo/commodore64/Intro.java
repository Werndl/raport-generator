package pl.edu.agh.mwo.commodore64;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Intro {

	private static String path;
	public static String welcomePage() {

		try {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Witamy w programie raportow pracowniczych!\n");

			Scanner scan = new Scanner(System.in);

			System.out.print("Prosze podac sciezke katalogu: ");
			path = scan.next();
			File file = new File(path);
			if (file.exists() && path.contains(".xls")) {
				System.out.println("++++++++++++++++++++++++++++++++++++++++++");
				return path;
			} else {
				System.out.println("\nPODANA SCIEZKA JEST BLEDNA\n");
				welcomePage();
			}
		} catch (NoSuchElementException err) {
			System.out.println("\nPODANA SCIEZKA JEST BLEDNA\n");
			welcomePage();
		}
		return path;
	}
}
