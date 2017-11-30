import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import com.oop.bibtex.main.factories.ArticleFactory;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static com.oop.bibtex.main.Attributes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactoryTest {

    @Test
    void ArticleFactoryTest(){

        String key = "test-article";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE,"title");
        mockMap.put(JOURNAL,"journal");
        mockMap.put(YEAR, "year");

        try {
            Entry article = (Entry) ArticleFactory.createEntity(mockMap, key);

            assertEquals("author",article.records.get(AUTHOR));
            assertEquals("title",article.records.get(TITLE));
            assertEquals("journal",article.records.get(JOURNAL));
            assertEquals("year",article.records.get(YEAR));

        } catch (IncompleteFieldsException e) {
            e.printStackTrace();
        }

    }

    @Test
    void ArticleFactoryExceptionTest(){

        String key = "test-article";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE,"author");
        mockMap.put(JOURNAL,"journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> ArticleFactory.createEntity(mockMap, key));
    }

}
