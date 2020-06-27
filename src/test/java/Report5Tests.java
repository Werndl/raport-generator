import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.mwo.commodore64.PathCommander;
import pl.edu.agh.mwo.commodore64.Report5;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Report5Tests {

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
    public void testPositiveGenerateReport5ForGivenData() {

        String projectName = "Projekt2";
        PathCommander.getPath(testDataFilePath);
        Report5 report5 = new Report5(PathCommander.getDataModel(), projectName);

        Assert.assertThat(outContent.toString(), Matchers.containsString("++++++++++++++++++++++++++++++++++++++++++"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Szczegółowy wykaz pracy w projekcie: Projekt2"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Lp         Pracownik                      Godziny [h]"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("1          Damian Kowal                   240"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("2          Katarzyna Mara                 330"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Suma:                                     570.0     "));
    }

    @Test
    public void testGenerateReport5ForNotExistProject() {

        String projectName = "Projekt102";
        PathCommander.getPath(testDataFilePath);
        Report5 report5 = new Report5(PathCommander.getDataModel(), projectName);

        Assert.assertThat(outContent.toString(), Matchers.containsString("Projekt o nazwie " + projectName + " nie istnieje!"));
    }

    @Test
    public void testGenerateReport5ForProjectNullValue() {

        String projectName = null;

        PathCommander.getPath(testDataFilePath);
        Report5 report5 = new Report5(PathCommander.getDataModel(), projectName);

        Assert.assertThat(outContent.toString(), Matchers.containsString("Projekt o nazwie " + projectName + " nie istnieje!"));
    }
}
