package pl.edu.agh.mwo.commodore64;

import java.util.ArrayList;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.demo.charts.ExampleChart;

public class BarChart implements ExampleChart<CategoryChart>
{
	private String dataTitle;
	private ArrayList<String> projectsList = new ArrayList<>();
	private ArrayList<Double> hoursList = new ArrayList<>();
	
	public BarChart(String year, ArrayList<String> projectsList, ArrayList<Double> hoursList)
	{
		this.dataTitle = year;
		this.projectsList = projectsList;
		this.hoursList = hoursList;
	}
	
	@Override
	public CategoryChart getChart()
	{
		CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Wykres słupkowy dla raportu 2").xAxisTitle("Projekt").yAxisTitle("Liczba godzin [h]").build();
	    chart.addSeries(dataTitle, projectsList, hoursList);
	 
	    return chart;
	}

	@Override
	public String getExampleChartName()
	{
		return "Wykres słupkowy dla raportu 2";
	}
}
