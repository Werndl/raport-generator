package pl.edu.agh.mwo.commodore64;

import java.util.Scanner;

public class Intro {

	public static String welcomePage() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Witamy w programie raportow pracowniczych!");
		System.out.println();

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Prosze podac sciezke katalogu:");
		String path = scan.next();
		

		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		return path;
	}
}
