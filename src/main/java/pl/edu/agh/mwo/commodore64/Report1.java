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
	
	
	
    public Report1(ArrayList<Task> tasks, String yearFilter){	
    for (Task i: tasks) {
    	if(i.getYear() == yearFilter) {
    		filtredDatas.add(i);
    	}
    	fillReport();
    	printReport();
    }
    
    
    }
    
    private void fillReport() {
    	
    	for (Task i: filtredDatas) {
    		if (reportDatas.containsKey(i.getPerson()) == true)
    		{
    			temp = reportDatas.get(i.getPerson()) + i.getHours();
    			reportDatas.replace(i.getPerson(), temp);
    			}
    		else {
    			reportDatas.put(i.getPerson(),i.getHours());
    		}
    	}
    	
    	
    }

    private void printReport() {
    	
    	Collection toPrint = reportDatas.entrySet();
    	Iterator element = toPrint.iterator();
    	while(element.hasNext())
    	System.out.println(element.next());
    	
    }
    
    
	
	
}