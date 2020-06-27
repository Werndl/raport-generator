import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.mwo.commodore64.PathCommander;
import pl.edu.agh.mwo.commodore64.Report2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Report2Tests {

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
    public void testPositiveGenerateReport2ForGivenData() {

        String year = "2020";
        PathCommander.getPath(testDataFilePath);
        Report2 report2 = new Report2(PathCommander.getDataModel(), year);

        Assert.assertThat(outContent.toString(), Matchers.containsString("++++++++++++++++++++++++++++++++++++++++++"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Alfabetyczna lista projektów za rok 2020"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Lp         Projekt                        Godziny [h]"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("1          Projekt 1                      1873,20"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("1          Projekt 1                      1873,20"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("3          Projekt 3                      1893,66"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Suma:                                     5890,00   "));
    }

    @Test
    public void testGenerateReport2ForNotExistYear() {

        String year = "20";
        PathCommander.getPath(testDataFilePath);
        Report2 report2 = new Report2(PathCommander.getDataModel(), year);

        Assert.assertThat(outContent.toString(), Matchers.containsString("Projektu nie prowadzono w " + year + " roku!"));
    }

    @Test
    public void testGenerateReport2ForNullYear() {

        String year = null;
        PathCommander.getPath(testDataFilePath);
        Report2 report2 = new Report2(PathCommander.getDataModel(), year);

        Assert.assertThat(outContent.toString(), Matchers.containsString("Projektu nie prowadzono w " + year + " roku!"));
    }
}
