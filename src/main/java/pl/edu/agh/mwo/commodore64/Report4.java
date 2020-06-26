package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Iterator;



public class Report4 {
	
	private class PersonProjects{
		
		public String person;
		
		public PersonProjects(String person) {
			this.person = person;
		}
		
		public HashMap<String,Double> projects = new HashMap<String,Double>();
		public HashMap<String,Double> projectsByPercent = new HashMap<String,Double>();
		public Double sum = 0.0;
		
	}
	private Double temp = 0.0;
	
	private TreeSet<String> allProjects = new TreeSet<String>();
	
	private static ArrayList<String> columns = new ArrayList<String>();
	
	private ArrayList<PersonProjects> personsProjects = new ArrayList<PersonProjects>();
	
	private ArrayList<Task> filteredDatas = new ArrayList<Task>();
	
	public Report4(ArrayList<Task> tasks, String yearFilter){	
	    for (Task i: tasks) {
	    	if(i.getYear().equals(yearFilter)) { filteredDatas.add(i); }   
	    }
	    makePersonProjects(filteredDatas);
	    fillAllProjects();
	    sumProjectsForPerson();
	    fillProjectByPercent();
	    beforePrintTask();
		printReport();
	}

	
	
	private void printReport() {
		
		int index = 1;
		System.out.printf("%-10s %-30s %-10s %-10s %-10s\n", Arrays.toString(columns.toArray()));
		
		for(PersonProjects pp: personsProjects) {
			System.out.printf("%-10s %-30s", index, pp.person);
			for(Map.Entry<String, Double> entry : pp.projectsByPercent.entrySet()) {
				for(String s: allProjects) {
					if(s.equals(entry.getKey())) {
						System.out.printf("Value: %.2f", entry.getValue());
					}
					else {
						System.out.print("---");
					}
					
				}
			}
			index++;
			System.out.println();
		}
		
		
	}
	
	private void makePersonProjects(ArrayList<Task> filtredDatas) { 
		// 1. Make objects from Task filtered by year
		// 2. Fill ArrayList with all those objects
		for (Task t: filteredDatas) {
			for (PersonProjects p: personsProjects) {
				if(t.getPerson().equals(p.person)) {
					if(p.projects.containsKey(t.getProject())) {
						temp = p.projects.get(t.getProject());
						p.projects.replace(t.getProject(), temp + Double.parseDouble(t.getHours()));
					}
					else { p.projects.put(t.getProject(),Double.parseDouble(t.getHours())); }
					
				}
				else { personsProjects.add(new PersonProjects(t.getPerson())); }
			}
		}
	}
	
	
	private void fillAllProjects() {
		for(PersonProjects pp: personsProjects) {
			
			for(String a: pp.projects.keySet()) {
				
			if(!allProjects.contains(a)) { allProjects.add(a); }
			}
		}
	}
	
	private void sumProjectsForPerson() {
		for(PersonProjects pp: personsProjects) { 
			for(Double a: pp.projects.values()) { pp.sum += a;}
		}
	}
	
	private void fillProjectByPercent() {
		for(PersonProjects pp: personsProjects) { 
			for(String a: pp.projects.keySet()) { pp.projectsByPercent.put(a,(pp.projects.get(a)/pp.sum)*100 );}
		}
	}
	
	private void beforePrintTask() {
		columns.add("Lp");
		columns.add("Pracownik");
		for (String a: allProjects) {columns.add(a);}
	}
	
}