import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitorTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void test() {

        assertEquals(10, 10);
    }

    @AfterAll
    public static void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
