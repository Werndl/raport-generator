package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Iterator;

// alfabetyczna lista pracowników za dany rok
// sumaryczna liczba godzin za danych rok
// tabelka: imie i nazwisko, liczba godzin

public class Report1 {

	private TreeMap<String, Double> reportDatas = new TreeMap<String, Double>();
	private ArrayList<Task> filtredDatas = new ArrayList<Task>();
	private double temp;

    public Report1(ArrayList<Task> tasks, String yearFilter){	
    for (Task i: tasks) {
    	if(i.getYear() == yearFilter) {
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

    private void printReport() {
    	
    	Collection toPrint = reportDatas.entrySet();
    	Iterator element = toPrint.iterator();
    	while(element.hasNext()) {System.out.println(element.next());}
    }
}