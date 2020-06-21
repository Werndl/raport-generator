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
    	if(i.getYear().equals(yearFilter)) {
    		filtredDatas.add(i);
    	}   
    
    }
    fillReport();
	printReport();
}
    
    private void fillReport() {
    	
    	for (Task i: filtredDatas) {
    		if (reportDatas.containsKey(i.getPerson()) == true)
    		{
    			temp = reportDatas.get(i.getPerson()) + Double.parseDouble(i.getHours());
    			reportDatas.replace(i.getPerson(), temp);
    			}
    		else {
    			reportDatas.put(i.getPerson(),Double.parseDouble(i.getHours()));
    		}
    	}
    	
    	
    }

    public void printReport()
	{
		double sum = 0;
		int index = 1;
		System.out.printf("%-30s %-30s %-10s\n", "Lp", "Pracownik", "Godziny [h]");
		
		for(Map.Entry<String, Double> entry : reportDatas.entrySet())
		{
			String person = entry.getKey();
			Double hours = entry.getValue();
			
			System.out.printf("%-30s %-30s %-10s\n", index, person, hours);
			
			sum += hours;
			index++;
		}
		
		System.out.printf("%-61s %-10s", "Suma: ", sum);
	}
}