package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Iterator;

public class Report1 {

	private TreeMap<String, Double> reportDatas = new TreeMap<String, Double>();
	private ArrayList<Task> filtredDatas = new ArrayList<Task>();
	private double temp;
	
	
	
    public Report1(ArrayList<Task> tasks, int yearFilter){	
    for (Task i: tasks) {
    	if(i.getYear() == yearFilter) {
    		filtredDatas.add(i);
    	}
    	fillReport();
    	printReport();
    }
    
    
    }
    
    public void fillReport() {
    	
    	for (Task i: filtredDatas) {
    		for (String x: reportDatas) {
    			
    		}
    	}
    	
    	
    }

    public void printReport() {
    	
    	Collection toPrint = reportDatas.entrySet();
    	Iterator element = entrySet.iterator();
    	while(element.hasNext())
    	System.out.println(element.next());
    	
    }
    
    
	
	
}