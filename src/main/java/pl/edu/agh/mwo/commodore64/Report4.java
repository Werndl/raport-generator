package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Iterator;

public class Report4 {
	
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
