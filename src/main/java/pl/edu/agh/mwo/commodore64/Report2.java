package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Report2 {
	private ArrayList<Task> project = new ArrayList<>();
	private TreeMap<String, Double> workingHours = new TreeMap<>();

	// for Excel print
	private static String[] columns = { "Lp", "Projekt", "Godziny [h]" };
	private static ArrayList<String[]> data = new ArrayList<>();

	public Report2(ArrayList<Task> dataModel, String year) {
		
		data.clear();
		if (ifYearExists(dataModel, year)) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Alfabetyczna lista projektów za rok " + year);
			for (Task t : dataModel) {
				if (t.getYear().equals(year))
					project.add(t);
			}

			fillReport();
			printReport();
		}
	}
	
	public Report2(ArrayList<Task> dataModel, String year, int reportIndex)
	{
		for (Task t : dataModel)
		{
			if (t.getYear().equals(year)) project.add(t);
		}

		fillReport();
	}

	public void fillReport() {
		for (Task t : project) {
			if (workingHours.containsKey(t.getProject())) {
				double dayHours = workingHours.get(t.getProject()) + Double.parseDouble(t.getHours());
				workingHours.replace(t.getProject(), dayHours);
			} else
				workingHours.put(t.getProject(), Double.parseDouble(t.getHours()));
		}
	}

	public void printReport() {
		double sum = 0;
		int index = 1;
		System.out.printf("%-10s %-30s %-10s\n", columns);

		for (Map.Entry<String, Double> entry : workingHours.entrySet()) {
			String project = entry.getKey();
			Double hours = entry.getValue();

			String[] values = { String.valueOf(index), project, hours.toString() };
			System.out.printf("%-10s %-30s %-10s\n", values);

			data.add(values);

			sum += hours;
			index++;
		}

		System.out.printf("%-41s %-10s", "Suma: ", sum);
		String[] sumFinal = { "Suma:", "", String.valueOf(sum) };
		data.add(sumFinal);
	}

	public boolean ifYearExists(ArrayList<Task> dataModel, String year) {
		for (Task t : dataModel) {
			if (t.getYear().equals(year))
				return true;
		}

		System.out.println("Projektu nie prowadzono w " + year + " roku!");
		return false;
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
	
	public TreeMap<String, Double> getWorkingHours()
	{
		return this.workingHours;
	}
	
	public ArrayList<Task> getProject()
	{
		return this.project;
	}
}
