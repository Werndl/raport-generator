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
	private static ArrayList<String> logData = new ArrayList<>();
	
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
						logData.add(path);
						logData.add("Projekt: " + sh.getSheetName() + " - " + "Komorka (" + (c.getRowIndex() + 1) + ", " + (c.getColumnIndex() + 1) + ") jest pusta!");
						break;
					}
					
					if(c.getColumnIndex() == 0)
					{
						if(c.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(c))
						{
							DataFormatter dataFormatter = new DataFormatter();
							String cellValue = dataFormatter.formatCellValue(c);
							String month = cellValue.split("/")[0];
							String year = "20" + cellValue.split("/")[2];
							
							if(pathCompatibile(path, year, month))
							{
								task.setMonth(month);
								task.setYear(year);
							}
							else
							{
								logData.add(path);
								logData.add("Projekt: " + sh.getSheetName() + " - " + "Komorka (" + (c.getRowIndex() + 1) + ", " + (c.getColumnIndex() + 1) + ") - data nie jest zgodna z układem katalogow!");
								break;
							}
						}
						else
						{
							logData.add(path);
							logData.add("Projekt: " + sh.getSheetName() + " - " + "Komorka (" + (c.getRowIndex() + 1) + ", " + (c.getColumnIndex() + 1) + ") ma niepoprawne dane!");
							break;
						}
					}
					
					if(c.getColumnIndex() == 1) continue;

					if(c.getColumnIndex() == 2)
					{
						if(c.getCellType() == CellType.NUMERIC && !DateUtil.isCellDateFormatted(c))
						{
							c.setCellType(CellType.STRING);
							task.setHours(c.getStringCellValue());
						}
						else
						{
							logData.add(path);
							logData.add("Projekt: " + sh.getSheetName() + " - " + "Komorka (" + (c.getRowIndex() + 1) + ", " + (c.getColumnIndex() + 1) + ") ma niepoprawne dane!");
							break;
						}
					}
					
					task.setProject(sh.getSheetName());
				}
				
				if(verifyTaskBody()) dataModel.add(task);
			}
		}
	}
	
	public static ArrayList<String> getLogData() {
		return logData;
	}

	public void setLogData(ArrayList<String> logData) {
		this.logData = logData;
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
	
	public boolean pathCompatibile(String path, String ExcelYear, String ExcelMonth)
	{
		String pathYear = path.split("/")[path.split("/").length - 3];
		String pathMonth = path.split("/")[path.split("/").length - 2];
		
		if(pathYear.length() != 4 || pathMonth.length() != 2) return false;
		if(pathMonth.charAt(0) == '0') pathMonth = pathMonth.substring(1);
		
		if(ExcelYear.equals(pathYear) && ExcelMonth.equals(pathMonth)) return true;
		else return false;
	}
}