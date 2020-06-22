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
		
		public String personName = "";
		public HashMap<String,Double> projects = new HashMap<String,Double>();
		
	}
	
	private TreeSet<String> allProjects = new TreeSet<String>();
	
	private ArrayList<PersonProjects> personsProjects = new ArrayList<PersonProjects>();
	
	private ArrayList<Task> filtredDatas = new ArrayList<Task>();
	
	public Report4(ArrayList<Task> tasks, String yearFilter){	
	    for (Task i: tasks) {
	    	if(i.getYear().equals(yearFilter)) {
	    		filtredDatas.add(i);
	    	}   
	    
	    }
	    fillReport();
		printReport();
	}

	
	private void fillReport(){
		
	}
	
	private void printReport() {
		
	}
	
}