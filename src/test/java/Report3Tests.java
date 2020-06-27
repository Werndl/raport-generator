import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.mwo.commodore64.PathCommander;
import pl.edu.agh.mwo.commodore64.Report3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Report3Tests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private final String testDataFilePath = System.getProperty("user.dir") +
            "\\resources\\dane1";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testPositiveGenerateReport3ForGivenData() {

        String year = "2020";
        String employee = "Karol Strassburger";
        PathCommander.getPath(testDataFilePath);
        Report3 report3 = new Report3(PathCommander.getDataModel(), year, employee);

        Assert.assertThat(outContent.toString(), Matchers.containsString("++++++++++++++++++++++++++++++++++++++++++"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Karol Strassburger | Szczegółowy wykaz pracy za rok 2020"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Lp         Miesiąc         Projekt              Godziny [h]"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("1          Styczeń         Projekt 1            198,00"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("2          Styczeń         Projekt 2            264,00"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("3          Styczeń         Projekt 3            240,00"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("4          Pażdziernik     Projekt 1            2400,00"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("5          Grudzień        Projekt 1            195,60"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("6          Grudzień        Projekt 2            297,60"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("7          Grudzień        Projekt 3            296,40"));
    }

    @Test
    public void testGenerateReport3ForNotExistYear() {

        String year = "20";
        String employee = "Karol Strassburger";
        PathCommander.getPath(testDataFilePath);
        Report3 report3 = new Report3(PathCommander.getDataModel(), year, employee);

        Assert.assertThat(outContent.toString(), Matchers.containsString("Brak danych na rok " + year));
    }

    @Test
    public void testGenerateReport3ForWrongEmployee() {

        String year = "2020";
        String employee = "Karol Hamburger";
        PathCommander.getPath(testDataFilePath);
        Report3 report3 = new Report3(PathCommander.getDataModel(), year, employee);

        Assert.assertThat(outContent.toString(), Matchers.containsString("Pracownik " + employee + " nie istnieje!"));
    }

    @Test
    public void testGenerateReport3ForNullYear() {

        String year = null;
        String employee = "Karol Strassburger";

        PathCommander.getPath(testDataFilePath);
        Report3 report3 = new Report3(PathCommander.getDataModel(), year, employee);

        Assert.assertThat(outContent.toString(), Matchers.containsString("Brak danych na rok " + year));
    }

    @Test
    public void testGenerateReport3ForNullEmployeeValue() {

        String year = "2020";
        String employee = null;

        PathCommander.getPath(testDataFilePath);
        Report3 report3 = new Report3(PathCommander.getDataModel(), year, employee);

        Assert.assertThat(outContent.toString(), Matchers.containsString("Pracownik " + employee + " nie istnieje!"));
    }
}
