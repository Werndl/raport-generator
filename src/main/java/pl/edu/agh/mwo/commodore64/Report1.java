package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Report1 {

	private TreeMap<String, Double> reportDatas = new TreeMap<String, Double>();
	private ArrayList<Task> filtredDatas = new ArrayList<Task>();
	private double temp;
	
	//for Excel print
		private static String[] columns = {"Lp", "Pracownik", "Godziny [h]"};
		private static ArrayList<String[]> data = new ArrayList<>();
	
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
		
		System.out.printf("%-30s %-30s %-10s\n", columns);
		
		for(Map.Entry<String, Double> entry : reportDatas.entrySet())
		{
			String person = entry.getKey();
			Double hours = entry.getValue();

			String[] values = {String.valueOf(index), person, hours.toString()};
			System.out.printf("%-30s %-30s %-10s\n", values);
			
			data = ExcelPrinter.createStringTemplate(values);
			sum += hours;
			index++;
		}
		
		System.out.printf("%-61s %-10s", "Suma: ", sum);
		String[] sumFinal = {"Suma:","",String.valueOf(sum)};
		data = ExcelPrinter.createStringTemplate(sumFinal);
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
}