package pl.edu.agh.mwo.commodore64;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Main
{
	public static void main(String[] args)
	{
		String summaryReportPath = "Raport zbiorczy.xls";
		SummaryReport summaryReport = new SummaryReport(summaryReportPath);
		summaryReport.create();
		try
		{
			Workbook SummaryWorkbook = WorkbookFactory.create(new File(summaryReportPath));
			GetDataFromExcel dataGetter = new GetDataFromExcel(SummaryWorkbook);
		} catch (EncryptedDocumentException | IOException e) {e.printStackTrace();}
		
		//"Dane zosta�y wczytane"
		//stworzenie Workbooka do tabeli zbiorczej, kt�ry b�dzie przekazywany do funkcji
		
		//GUI + -> nowa klasa (Workbook) -> report1(Workbook, String date, String name) (...)
		
		//usuni�cie tabeli zbiorczej
	}
}
