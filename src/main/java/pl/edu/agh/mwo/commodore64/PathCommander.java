package pl.edu.agh.mwo.commodore64;

import java.io.File;

public class PathCommander {

	public static void getPath(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		if (path.contains("\\")) {
			path = path.replace("\\", "/");
		}
 		for (File file : listOfFiles) {
			if(!file.isDirectory() && file.getName().contains(".xls")) {
				System.out.println(path + "/" + file.getName());
				//SebFyn(path + "/" + file.getName());
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
