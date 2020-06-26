package pl.edu.agh.mwo.commodore64;

import java.io.File;
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

		fileName = getFileName();
		if (!fileName.isEmpty() || !fileName.equals("") || fileName != null) {

			Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

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

	}

	private static String getFileName() {

		Scanner scan = new Scanner(System.in);

		String path = getFilePath();

		if (path == null) {
			return "";
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy_MM_dd_HHmm");
		LocalDateTime now = LocalDateTime.now();
		System.out.print("Proszę podać nazwę raportu: ");
		return fileName = path + "/" + scan.nextLine() + "_" + dtf.format(now) + ".xlsx";
	}

	private static String getFilePath() {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		fileName = null;
		while (fileName == null || fileName.contains(Intro.getReportsPath())) {
			System.out.print("Proszę podać ścieżkę do zapisania pliku:");
			fileName = scan.nextLine();
			if (fileName.contains(Intro.getReportsPath())) {
				System.out.println("Plik nie może zostać zapisany w katalogu danych. Spróbuj ponownie");
			}

		}
		if (fileName.contains("\\")) {
			fileName = fileName.replace("\\", "/");
		}

		File f = new File(fileName);
		if (!f.exists()) {
			System.out.println("PODANA ŚCIEŻKA JEST BŁĘDNA");
			System.out.println("WPISZ: 1 jeśli chcesz spróbować jeszcze raz lub wciśnij inny klawisz jeśli chcesz wrócić do menu.");
			String nextTry = scan2.next();
			if (nextTry.equals("1")) {
				getFilePath();
				return fileName;
			}
			return null;
		}
		return fileName;
	}
}
