import org.junit.Assert;
import org.junit.Test;
import pl.edu.agh.mwo.commodore64.Intro;
import org.hamcrest.Matchers;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;


public class IntroTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String testDataFilePath = System.getProperty("user.dir") +
            "\\src\\test\\java\\testData\\2018\\01\\Damian_Kowal.xls";

//TODO  -Fix
//    @Test
//    public void testIntroWithoutParameter() {
//        String input = "";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        Assert.assertEquals("", Intro.welcomePage());
//    }

    @Test
    public void testIntroWithValidPathToReport() {
        InputStream in = new ByteArrayInputStream(testDataFilePath.getBytes());
        System.setIn(in);
        Assert.assertEquals(testDataFilePath, Intro.welcomePage());
    }
}
