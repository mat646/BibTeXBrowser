import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.BibTeXFile;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import com.oop.bibtex.main.exceptions.IncompleteOptionsException;
import com.oop.bibtex.main.parserComponents.Converter;
import com.oop.bibtex.main.parserComponents.FileParser;
import com.oop.bibtex.main.visitors.BasicFileVisitor;
import javafx.util.Pair;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitorTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeAll
     static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    void TestForVisiting() throws IOException, IncompleteFieldsException,IncompleteOptionsException {

        FileParser fileParser = new FileParser();
        Converter converter = new Converter();

        Character symbol = '+';
        String path = "/home/mateusz/Pulpit/xampl.bib";
        ArrayList<String> types = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();

        //Intermediate form
        if (path == null) throw new IncompleteOptionsException("path");
        Pair<Map<String, Map<Attributes, String>>, Map<String, String>> bibTeXIntermediateForm =
                fileParser.parse(path);

        //Objective form
        BibTeXFile bibTeXFile = converter.convert(bibTeXIntermediateForm);

        //Passing execution parameters
        if (symbol == null) throw new IncompleteOptionsException("symbol");
        BasicFileVisitor basicFileVisitor = new BasicFileVisitor(symbol, types, authors);

        //Printing on screen
        bibTeXFile.accept(basicFileVisitor);


        String result = outContent.toString();

        assertEquals(true, result.length() > 50);
    }

    @AfterAll
    static void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
