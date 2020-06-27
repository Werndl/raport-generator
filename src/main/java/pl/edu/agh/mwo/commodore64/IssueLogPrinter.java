package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;

public class IssueLogPrinter {

	private static ArrayList<String> logData = new ArrayList<>();
	
	public static void printLog() {
		
		logData = GetDataFromExcel.getLogData();
		
		for (String i : logData) {
			System.out.println(i);
		}
	}

}
