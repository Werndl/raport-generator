package pl.edu.agh.mwo.commodore64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SummaryReport
{
	private String path;
	
	public SummaryReport(String path)
	{
		this.path = path;
	}
	
	public void create()
	{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet firstSheet = workbook.createSheet("Raport");

        try (FileOutputStream fos = new FileOutputStream(new File("Raport zbiorczy.xls")))
        {
        	System.out.println("Dane zostaly wczytane.");
        	workbook.write(fos);
        }
        catch (IOException e)
        {
        	System.out.print("Wystapil blad!");
        	e.printStackTrace();
        }
	}
	
	public String getPath() {return this.path;}
}