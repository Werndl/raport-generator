package pl.edu.agh.mwo.commodore64;

import java.io.File;
import java.util.ArrayList;

public class PathCommander {

	static private GetDataFromExcel dataGetter = new GetDataFromExcel();
	
	static public ArrayList<Task> getDataModel() {return dataGetter.getDataModel();}
	
	public static void getPath(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		if (path.contains("\\")) {
			path = path.replace("\\", "/");
		}
 		for (File file : listOfFiles) {
			if(!file.isDirectory() && file.getName().contains(".xls")) {
				System.out.println("Wczytano: " + path + "/" + file.getName());
				dataGetter.initializePopulation(path + "/" + file.getName());
			}
		}
 		//change directory
		for (File directory : listOfFiles) {
			if (directory.isDirectory()) {
				String subpath = directory.getPath();
				if (subpath.contains("\\")) {
					subpath = subpath.replace("\\", "/");
				}
				getPath(directory.getPath());
			}
		}
	}
}
