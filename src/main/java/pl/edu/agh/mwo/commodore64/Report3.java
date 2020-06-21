package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Report3 {

	private ArrayList<Task> projectWorkers = new ArrayList<>();
	private TreeMap<String, Double> workingHours = new TreeMap<>();
	
	private boolean checkEmployee(ArrayList<Task> dataModel, String year,String employee) {
		
		for(Task i: dataModel) {
			if(i.getPerson().equals(employee)) {
				return true;
			}
		}
		System.out.println("Brak danych pracownika na rok " + year);
		return false;
	}

	public Report3(ArrayList<Task> dataModel, String year, String employee) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(employee + " | Szczegółowy wykaz pracy za rok " + year);
		if(checkEmployee(dataModel, year, employee)) {
		for (Task i : dataModel) {
			System.out.println(i.getPerson() + " - " + i.getMonth() + " - " + i.getProject());
			if (i.getYear().equals(year)) {
				//System.out.println(i.getPerson() + " - " + i.getMonth() + " - " + i.getProject());
				if (i.getPerson().contains(employee)) {
					projectWorkers.add(i);
					//System.out.println(i.getPerson() + " - " + i.getMonth() + " - " + i.getProject());
				}
			}
		}
		}
		fillReport();
		printReport();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
	}

	private void fillReport() {
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

	private void printReport() {
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

			System.out.printf("%-10s %-20s %-20s %-10s\n", index, monthName[Integer.parseInt(month)-1], project, hours);

			index++;
		}

	}
	
	String makeCompoundKey(String month, String project) {
		  return month + ";" + project;
		}
}
