import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.mwo.commodore64.PathCommander;
import pl.edu.agh.mwo.commodore64.Report1;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Report1Tests {

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
    public void testPositiveGenerateReport1ForGivenData() {

        String year = "2018";
        PathCommander.getPath(testDataFilePath);
        Report1 report1 = new Report1(PathCommander.getDataModel(), year);

        Assert.assertThat(outContent.toString(), Matchers.containsString("++++++++++++++++++++++++++++++++++++++++++"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Alfabetyczna lista pracowników za rok 2018"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Lp         Pracownik                      Godziny [h]"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("1          Damian Kowal                   389,40"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("2          Katarzyna Mara                 270"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("3          Marta Bolas                    144"));
        Assert.assertThat(outContent.toString(), Matchers.containsString("Suma:                                     803,40    "));
    }

    @Test
    public void testGenerateReport1ForNotExistYear() {

        String year = "20";
        PathCommander.getPath(testDataFilePath);
        Report1 report1 = new Report1(PathCommander.getDataModel(), year);

        Assert.assertThat(outContent.toString(), Matchers.containsString("Brak danych na rok " + year));
    }

    @Test
    public void testGenerateReport1ForNullYear() {

        String year = null;
        PathCommander.getPath(testDataFilePath);
        Report1 report1 = new Report1(PathCommander.getDataModel(), year);

        Assert.assertThat(outContent.toString(), Matchers.containsString("Brak danych na rok " + year));
    }
}
