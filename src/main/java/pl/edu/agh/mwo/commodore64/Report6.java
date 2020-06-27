package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;

import org.apache.fontbox.util.autodetect.WindowsFontDirFinder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.SwingWrapper;

public class Report6
{
	private Report2 report2;
	private ArrayList<String> projectsList = new ArrayList<>();
	private ArrayList<Double> hoursList = new ArrayList<>();
	
	public Report6(ArrayList<Task> dataModel, String year)
	{
		report2 = new Report2(dataModel, year, 0);
		if(report2.ifYearExists(dataModel, year)) displayChart(year);
	}
	
	public void fillChartData()
	{
		for (Map.Entry<String, Double> entry : report2.getWorkingHours().entrySet())
		{
			String project = entry.getKey();
			Double hours = entry.getValue();
			
			projectsList.add(project);
			hoursList.add(hours);
		}
	}
	
	public void displayChart(String year)
	{
		fillChartData();
		BarChart reportAsChart = new BarChart(year, projectsList, hoursList);
	    CategoryChart chart = reportAsChart.getChart();
	    new SwingWrapper<CategoryChart>(chart).displayChart().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
