package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Report3 {

	private ArrayList<Task> projectWorkers = new ArrayList<>();
	private TreeMap<String, Double> workingHours = new TreeMap<>();

	// for Excel print
	private static String[] columns = { "Lp", "Miesiąc", "Projekt", "Godziny [h]" };
	private static  ArrayList<String[]> data = new ArrayList<>();

	private boolean checkEmployee(ArrayList<Task> dataModel, String year, String employee) {

		for (Task i : dataModel) {
			if (i.getPerson().equals(employee) && i.getYear().equals(year)) {
				return true;
			}
		}

		System.out.println("Brak danych pracownika na rok " + year);
		return false;
	}

	public Report3(ArrayList<Task> dataModel, String year, String employee) {

		if (checkEmployee(dataModel, year, employee)) {

			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(employee + " | Szczegółowy wykaz pracy za rok " + year);
			for (Task i : dataModel) {
				// for checking
				// System.out.println(i.getYear() + " - " + i.getPerson() + " - " + i.getMonth()
				// + " - " + i.getProject());
				if (i.getYear().equals(year)) {

					if (i.getPerson().equals(employee)) {
						projectWorkers.add(i);
					}
				}
			}
			fillReport();
			printReport();
		}
	}

	private void fillReport() {
		for (Task t : projectWorkers) {
			String key = makeCompoundKey(t.getMonth(), t.getProject());
			if (workingHours.containsKey(key)) {

				double dayHours = workingHours.get(key) + Double.parseDouble(t.getHours());
				workingHours.replace(key, dayHours);
			} else {
				workingHours.put(key, Double.parseDouble(t.getHours()));
			}
		}
	}

	private void printReport() {

		int index = 1;
		System.out.printf("%-10s %-15s %-20s %-10s\n", columns);

		for (Map.Entry<String, Double> entry : workingHours.entrySet()) {
			String key = entry.getKey();
			Double hours = entry.getValue();

			String[] keyValues = key.split(";");
			String month = keyValues[0];
			String[] monthName = { "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień",
					"Wrzesień", "Pażdziernik", "Listopad", "Grudzień" };
			String project = keyValues[1];

			String[] values = { String.valueOf(index), monthName[Integer.parseInt(month) - 1], project,
					hours.toString() };
			System.out.printf("%-10s %-15s %-20s %-10s\n", values);

			data.add(values);

			index++;
		}

	}

	private String makeCompoundKey(String month, String project) {
		if (month.length() > 1) {
			return month + ";" + project;
		}
		return "0" + month + ";" + project;
	}

	public static String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public static ArrayList<String[]> getData() {
		return data;
	}

	public void setData(ArrayList<String[]> data) {
		this.data = data;
	}

}
