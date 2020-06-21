package pl.edu.agh.mwo.commodore64;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcel
{
	private ArrayList<Task> dataModel = new ArrayList<Task>();
	private Task task;
	
	public ArrayList<Task> getDataModel() {return this.dataModel;}
	
	public void initializePopulation(String path)
	{
		try
		{
			Workbook wb = WorkbookFactory.create(new File(path));
			dataPopulation(wb, path);
		}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public void dataPopulation(Workbook wb, String path)
	{
		for(Sheet sh : wb)
		{
			for(Row r : sh)
			{
				if(r.getRowNum() == 0) continue;
				task = new Task();
				GetNameFromPath(path);
				for(Cell c : r)
				{
					if(c.getCellType() == CellType.BLANK)
					{
						System.out.println("Komorka (" + (c.getRowIndex() + 1) + ", " + (c.getColumnIndex() + 1) + ") jest pusta!");
						break;
					}
					
					if(c.getColumnIndex() == 0)
					{
						DataFormatter dataFormatter = new DataFormatter();
						String cellValue = dataFormatter.formatCellValue(c);
						task.setMonth(cellValue.split("/")[0]);
						task.setYear("20" + cellValue.split("/")[2]);
					}
					
					if(c.getColumnIndex() == 1) continue;

					if(c.getColumnIndex() == 2)
					{
						c.setCellType(CellType.STRING);
						task.setHours(c.getStringCellValue());
					}
					
					task.setProject(sh.getSheetName());
				}
				
				if(verifyTaskBody()) dataModel.add(task);
			}
		}
	}
	
	public void GetNameFromPath(String path)
	{
		String[] splittedPath = path.split("/");
		String rawName = splittedPath[splittedPath.length-1];
		String surname = rawName.split("_")[0];
		String name = rawName.split("_")[1].substring(0, rawName.split("_")[1].length() - 4);
		String person = surname + " " + name;
		task.setPerson(person);
	}
	
	public boolean verifyTaskBody()
	{
		if((task.getHours() != "" && task.getHours() != null)
		&& (task.getMonth() != "" && task.getMonth() != null)
		&& (task.getPerson() != "" && task.getPerson() != null)
		&& (task.getProject() != "" && task.getProject() != null)
		&& (task.getYear() != "" && task.getYear() != null)) return true;
		else return false;
	}
}
