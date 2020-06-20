package pl.edu.agh.mwo.commodore64;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SummaryReport
{
	Workbook ExcelSource;
	
	public void create()
	{
		try { ExcelSource = WorkbookFactory.create(new File("summaryReport.xlsx")); } catch (EncryptedDocumentException | IOException e) {e.printStackTrace();}
	}
	
	public Workbook getExcelSource() {return ExcelSource;}
	public void setExcelSource (Workbook ExcelSource) {this.ExcelSource = ExcelSource;}
}