package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Report5
{
	private ArrayList<Task> projectWorkers = new ArrayList<>();
	private TreeMap<String, Double> workingHours = new TreeMap<>();
	
	public Report5(ArrayList<Task> dataModel, String project)
	{
		if(projectExistanceCheck(dataModel, project))
		{
			for(Task t : dataModel)
			{
				if(t.getProject().equals(project)) projectWorkers.add(t);
			}
		}
		
		fillReport();
		printReport();
	}
	
	public boolean projectExistanceCheck(ArrayList<Task> dataModel, String project)
	{
		for(Task t : dataModel)
		{
			if(t.getProject().equals(project)) return true;
		}
		
		System.out.println("Projekt o nazwie " + project + " nie istnieje!");
		return false;
	}
	
	public void fillReport()
	{		
		for(Task t : projectWorkers)
		{
			if(workingHours.containsKey(t.getPerson()))
			{
				double dayHours = workingHours.get(t.getPerson()) + Double.parseDouble(t.getHours());
				workingHours.replace(t.getPerson(), dayHours);
			}
			else workingHours.put(t.getPerson(), Double.parseDouble(t.getHours()));
		}
	}
	
	public void printReport()
	{
		double sum = 0;
		System.out.printf("%-60s %-30s %-10s\n", "Lp", "Pracownik", "Godziny [h]");
		
		for(Map.Entry<String, Double> entry : workingHours.entrySet())
		{
			int index = 1;
			String person = entry.getKey();
			Double hours = entry.getValue();
			
			System.out.printf("%-60s %-30s %-10s\n", index, person, hours);
			
			sum += hours;
			index++;
		}
		
		System.out.printf("%-60s %-40s", "Suma: ", sum);
	}
}
