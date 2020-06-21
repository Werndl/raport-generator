package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Report3 {

	private ArrayList<Task> projectWorkers = new ArrayList<>();
	private TreeMap<String, Double> workingHours = new TreeMap<>();

	public Report3(ArrayList<Task> dataModel, String year, String employee) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(employee + " | Szczegółowy wykaz pracy za rok " + year);
		for (Task i : dataModel) {
			if (i.getYear().equals(year)) {
				
				if (i.getPerson().contains(employee)) {
					projectWorkers.add(i);
				}
			}
		}
		fillReport();
		printReport();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
	}

	public void fillReport() {
		for (Task t : projectWorkers) {
			String key = makeCompoundKey(t.getMonth(), t.getProject());
			if (workingHours.containsKey(key)) {
				
				double dayHours = workingHours.get(key) + Double.parseDouble(t.getHours());
				workingHours.replace(key, dayHours);
			} 
			else {
				workingHours.put(key, Double.parseDouble(t.getHours()));
			}
		}
	}

	public void printReport() {
		double sum = 0;
		int index = 1;
		System.out.printf("%-10s %-20s %-20s %-10s\n", "Lp", "Miesiac","Projekt", "Godziny [h]");

		for (Map.Entry<String, Double> entry : workingHours.entrySet()) {
			String key = entry.getKey();
			//String key = "month;test";
			Double hours = entry.getValue();
			
			String[] keyValues = key.split(";");
			String month = keyValues[0];
			String[] monthName = {"Styczeń","Luty","Marzec","Kwiecień",
					"Maj","Czerwiec","Lipiec","Sierpień","Wrzesień",
					"Pażdziernik","Listopad","Grudzień"};
			String project = keyValues[1];

			System.out.printf("%-10s %-20s %-20s %-10s\n", index, monthName[Integer.parseInt(month)], project, hours);

			index++;
		}

	}
	
	String makeCompoundKey(String month, String project) {
		  return month + ";" + project;
		}
}
