import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.BibTeXFile;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import com.oop.bibtex.main.exceptions.IncompleteOptionsException;
import com.oop.bibtex.main.parserComponents.Converter;
import com.oop.bibtex.main.parserComponents.FileParser;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParserTest {

    @Test
    void parsingTest() throws IncompleteOptionsException, IOException, IncompleteFieldsException {

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

        bibTeXFile.elements.stream().forEach(x -> {
                    if (x instanceof Entry)
                        assertEquals(true, ((Entry) x).key.length() > 0);
                }
        );

    }

}
