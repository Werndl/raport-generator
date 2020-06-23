package pl.edu.agh.mwo.commodore64;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReportsSelector {

    private int reportOption;

    public void PrintReportsWelcomeMessage(){
        System.out.println("\nWybierz z poniższych opcji raport który chcesz wygenerować:");
        System.out.println("Raport 1: Alfabetyczna lista pracowników za dany rok. WPISZ: 1");
        System.out.println("Raport 2: Alfabetyczna lista projektów za dany rok. WPISZ: 2");
        System.out.println("Raport 3: Szczegółowy wykaz pracy danego pracownika. WPISZ: 3");
        System.out.println("Raport 4: Procentowe zaangażowanie danego pracownika w projekty za dany rok. WPISZ: 4");
        System.out.println("Raport 5: Szczegółowy wykaz pracy w danym projekcie, pokazujący liczbę godzin wypracowanych przez " +
                "poszczególnych pracowników w danym projekcie. WPISZ: 5");
        System.out.println("Raport 6: Generowanie wykresu słupkowego do raportu 2. WPISZ: 6");
        System.out.println("Raport 7: Wykres kołowy do raportu 4 dla danego pracownika. WPISZ: 7");
        System.out.println("Wyjście z programu. WPISZ: 0");
    }

    public int GetReportOptionToGenerateFromUser(){
        System.out.print("\nWpisz wybraną opcję: ");
        Scanner scan = new Scanner(System.in);
        reportOption = scan.nextInt();
        return reportOption;
    }

    public String GetYearToReportGenerating(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj rok, dla którego chcesz wygenerować raport: ");
        return scan.next();
    }

    public String GetNameAndSurnameToReportGenerating(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj imie i nazwisko osoby, dla której chcesz wygenerować raport: ");
        return scan.nextLine();
    }

    public String GetProjectToReportGenerating(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj projekt, dla którego chcesz wygenerować raport: ");
        return scan.nextLine();
    }

    public void GeneratingReportInfo(int reportOption){
       System.out.println("Generowanie raportu numer: " + reportOption);
    }

    public void CheckIfUserWantToGenerateAgain(){
        try {
            System.out.println("\nCzy chcesz wygenerować kolejny raport?");
            System.out.println("WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: ");
            Scanner scan = new Scanner(System.in);

            String generationAgainStatus = scan.next();
            if (generationAgainStatus.equals("1")){
                SelectReport();
            }
            else {
            	System.out.println("Koniec pracy");
                System.exit(0);
            }
        }
        catch (InputMismatchException err){
            System.out.println("Podana wartość jest błędna, spróbuj ponownie.");
            CheckIfUserWantToGenerateAgain();
        }
    }

    public void SelectReport(){
        PrintReportsWelcomeMessage();
        try {
            reportOption = GetReportOptionToGenerateFromUser();
            switch (reportOption){
                case 1:
                    GeneratingReportInfo(reportOption);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++");
                    Report1 report1 = new Report1(PathCommander.getDataModel(), GetYearToReportGenerating());
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
                    ExcelPrinter.checkIfUserWantToPrintExcel(reportOption);
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
                    break;
                case 2:
                    GeneratingReportInfo(reportOption);
                    System.out.print(2);
                    break;
                case 3:
                    GeneratingReportInfo(reportOption);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++");
                    Report3 report3 = new Report3(PathCommander.getDataModel(), GetYearToReportGenerating(), GetNameAndSurnameToReportGenerating());
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
                    ExcelPrinter.checkIfUserWantToPrintExcel(reportOption);
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
                    break;
                case 4:
                    GeneratingReportInfo(reportOption);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++");
                    System.out.print(4);
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
                    ExcelPrinter.checkIfUserWantToPrintExcel(reportOption);
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
                    break;
                case 5:
                    GeneratingReportInfo(reportOption);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++");
                    Report5 report5 = new Report5(PathCommander.getDataModel(), GetProjectToReportGenerating());
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
                    ExcelPrinter.checkIfUserWantToPrintExcel(reportOption);
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
                    break;
                case 6:
                    GeneratingReportInfo(reportOption);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++");
                    System.out.print(6);
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
                    break;
                case 7:
                    GeneratingReportInfo(reportOption);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++");
                    System.out.print(7);
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
                    break;
                case 0:
                	System.out.println("Koniec pracy");
                    System.exit(0);
                default:
                    System.out.println("Podana wartość jest błędna, spróbuj ponownie.");
                    SelectReport();
            }
            CheckIfUserWantToGenerateAgain();
        }
        catch (InputMismatchException err){
            System.out.println("\nPodana wartość jest błędna, spróbuj ponownie.");
            SelectReport();
        }
    }
}
