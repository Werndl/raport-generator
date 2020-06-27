import org.junit.Assert;
import org.junit.Test;
import pl.edu.agh.mwo.commodore64.Intro;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class IntroTests {

    private final String testDataFilePath = System.getProperty("user.dir") +
            "\\resources\\dane1";

    @Test
    public void testIntroWithValidPathToReport() {
        InputStream in = new ByteArrayInputStream(testDataFilePath.getBytes());
        System.setIn(in);
        Assert.assertEquals(testDataFilePath, Intro.welcomePage());
    }
}
