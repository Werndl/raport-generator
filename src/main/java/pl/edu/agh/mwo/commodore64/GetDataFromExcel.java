package pl.edu.agh.mwo.commodore64;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcel
{
	private ArrayList<Task> dataModel = new ArrayList<Task>();
	private Task task = new Task();
	
	public void initializePopulation(String path)
	{
		try
		{
			Workbook wb = WorkbookFactory.create(new File(path));
			dataPopulation(wb);
		}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public void dataPopulation(Workbook wb)
	{
		for(Sheet sh : wb)
		{
			for(Row r : sh)
			{
				if(r.getRowNum() == 0) continue;
				for(Cell c : r)
				{
					if(c.getColumnIndex() == 0)
					{
						
					}
				}
			}
		}
	}
}
