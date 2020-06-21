package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
    	
    	
    }

    public void printReport() {
    	
    }
    
    
	
	
}