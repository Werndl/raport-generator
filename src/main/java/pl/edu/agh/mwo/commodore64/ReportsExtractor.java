package pl.edu.agh.mwo.commodore64;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReportsExtractor {

	private static String fileName;

	public static void writeExcel(String[] columns, ArrayList<String[]> data) throws IOException {
		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		getFileName();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Report");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (String[] i : data) {
			Row row = sheet.createRow(rowNum++);

			for (int k = 0; k < i.length; k++) {
				row.createCell(k).setCellValue(i[k]);
			}
		}

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(fileName);
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();
	}

	private static String getFileName() {

		Scanner scan = new Scanner(System.in);

		String path = getFilePath();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd-HHmm");
		LocalDateTime now = LocalDateTime.now();
		System.out.print("Proszę podać nazwę raportu: ");
		return fileName = path + "/" + scan.nextLine() + "-" + dtf.format(now) + ".xlsx";
	}

	private static String getFilePath() {
		Scanner scan = new Scanner(System.in);

		
		while (fileName == null || fileName.contains(Intro.getReportsPath())) {
		System.out.print("Proszę podać scieżkę do zapisania pliku:");
		fileName = scan.nextLine();
		if (fileName.contains(Intro.getReportsPath())) {
			System.out.println("Plik nie może zostać zapisany w katalogu danych. Spróbuj ponownie");
		}

		
		} 
			if (fileName.contains("\\")) {
				fileName = fileName.replace("\\", "/");

		}
			return fileName;
	}
}
