import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.mwo.commodore64.PathCommander;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PathCommanderTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private String testDataFilePath = System.getProperty("user.dir") +
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
    public void testCheckIfProjectAreLoadedForGivenPath() {

        PathCommander.getPath(testDataFilePath);
        testDataFilePath = testDataFilePath.replace("\\", "/");

        String word = "Wczytano:";
        Pattern pattern = Pattern.compile("\\s(" + word + ")\\s");
        Matcher  matcher = pattern.matcher(outContent.toString());
        int count = 0;
        while (matcher.find()){
            count++;
        }
        Assert.assertEquals(count, 39);
//        First test file
        Assert.assertThat(outContent.toString(), Matchers.containsString("Wczytano: " + testDataFilePath + "/2018/01/Damian_Kowal.xls"));
//        Last test file
        Assert.assertThat(outContent.toString(), Matchers.containsString("Wczytano: " + testDataFilePath + "/2020/12/Roksana_Ekogroszek.xls"));
    }
}
