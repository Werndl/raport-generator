package pl.edu.agh.mwo.commodore64;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		String reportsPath = Intro.welcomePage();
		PathCommander.getPath(reportsPath);
		ReportsSelector reportSelector = new ReportsSelector();
		reportSelector.SelectReport();

		//PathCommander.getPath("E:\\jnodz\\Documents\\IT\\PROJEKT\\dane");
		
		/*for(Task t : PathCommander.getDataModel())
		{
			System.out.println("-----------");
			System.out.println("h " + t.getHours());
			System.out.println("m " + t.getMonth());
			System.out.println("y " + t.getYear());
			System.out.println("h " + t.getProject());
			System.out.println("h " + t.getPerson());
		}*/

	}
}
