package pl.edu.agh.mwo.commodore64;

public class Main
{
	public static void main(String[] args)
	{
		String path = Intro.welcomePage();
		ReportsSelector reportSelector = new ReportsSelector();
		reportSelector.SelectReport();

		PathCommander.getPath(path);

	}
}
