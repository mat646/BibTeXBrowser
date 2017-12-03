import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import com.oop.bibtex.main.factories.*;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static com.oop.bibtex.main.Attributes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactoryTest {

    @Test
    void ArticleFactoryTest() throws IncompleteFieldsException{

        String key = "test-article";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) ArticleFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("journal", article.records.get(JOURNAL));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void ArticleFactoryExceptionTest() {

        String key = "test-article";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE, "author");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> ArticleFactory.createEntity(mockMap, key));
    }

    @Test
    void BookFactoryTest() throws IncompleteFieldsException {

        String key = "test-book";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(PUBLISHER, "publisher");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) BookFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("publisher", article.records.get(PUBLISHER));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void BookFactoryExceptionTest() {

        String key = "test-book";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE, "author");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> BookFactory.createEntity(mockMap, key));
    }

    @Test
    void BookletFactoryTest() throws IncompleteFieldsException {

        String key = "test-booklet";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) BookletFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("journal", article.records.get(JOURNAL));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void BookletFactoryExceptionTest() {

        String key = "test-booklet";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> BookletFactory.createEntity(mockMap, key));
    }

    @Test
    void ConferenceFactoryTest() throws IncompleteFieldsException {

        String key = "test-conference";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(BOOKTITLE, "booktitle");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) ConferenceFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("booktitle", article.records.get(BOOKTITLE));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void ConferenceFactoryExceptionTest() {

        String key = "test-conference";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE, "author");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> ConferenceFactory.createEntity(mockMap, key));
    }

    @Test
    void InBookFactoryTest() throws IncompleteFieldsException {

        String key = "test-inbook";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(CHAPTER, "chapter");
        mockMap.put(PUBLISHER, "publisher");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) InBookFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("chapter", article.records.get(CHAPTER));
        assertEquals("year", article.records.get(YEAR));


    }

    @Test
    void InBookFactoryExceptionTest() {

        String key = "test-inbook";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE, "author");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> InBookFactory.createEntity(mockMap, key));
    }

    @Test
    void InCollectionFactoryTest() throws IncompleteFieldsException {

        String key = "test-incollection";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(BOOKTITLE, "booktitle");
        mockMap.put(PUBLISHER, "publisher");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) InCollectionFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("publisher", article.records.get(PUBLISHER));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void InCollectionFactoryExceptionTest() {

        String key = "test-incollection";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE, "author");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> InCollectionFactory.createEntity(mockMap, key));
    }

    @Test
    void InProceedingsFactoryTest() throws IncompleteFieldsException {

        String key = "test-inproceedings";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(BOOKTITLE, "booktitle");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) InProceedingsFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("journal", article.records.get(JOURNAL));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void InProceedingsFactoryExceptionTest() {

        String key = "test-inproceedings";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE, "author");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> InProceedingsFactory.createEntity(mockMap, key));
    }

    @Test
    void ManualFactoryTest() throws IncompleteFieldsException {

        String key = "test-manual";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) ManualFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("journal", article.records.get(JOURNAL));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void ManualFactoryExceptionTest() {

        String key = "test-manual";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> ManualFactory.createEntity(mockMap, key));
    }

    @Test
    void MasterThesisFactoryTest() throws IncompleteFieldsException {

        String key = "test-master";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(SCHOOL, "school");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) MasterThesisFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("school", article.records.get(SCHOOL));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void MasterThesisFactoryExceptionTest() {

        String key = "test-master";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE, "author");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> MasterThesisFactory.createEntity(mockMap, key));
    }

    @Test
    void MiscFactoryTest() throws IncompleteFieldsException {

        String key = "test-misc";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) MiscFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("journal", article.records.get(JOURNAL));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void MiscFactoryExceptionTest() {

        String key = "test-misc";

        assertThrows(IncompleteFieldsException.class, () -> MiscFactory.createEntity(null, key));
    }

    @Test
    void PhdThesisFactoryTest() throws IncompleteFieldsException {

        String key = "test-phdthesis";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(SCHOOL, "school");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) PhdThesisFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("school", article.records.get(SCHOOL));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void PhdThesisFactoryExceptionTest() {

        String key = "test-article";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE, "author");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> PhdThesisFactory.createEntity(mockMap, key));
    }

    @Test
    void ProceedingsFactoryTest() throws IncompleteFieldsException {

        String key = "test-proceedings";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) ProceedingsFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("journal", article.records.get(JOURNAL));
        assertEquals("year", article.records.get(YEAR));


    }

    @Test
    void ProceedingsFactoryExceptionTest() {

        String key = "test-proceedings";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> ProceedingsFactory.createEntity(mockMap, key));
    }

    @Test
    void TechReportFactoryTest() throws IncompleteFieldsException {

        String key = "test-techreport";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(INSTITUTION, "institution");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) TechReportFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("institution", article.records.get(INSTITUTION));
        assertEquals("year", article.records.get(YEAR));


    }

    @Test
    void TechReportFactoryExceptionTest() {

        String key = "test-techreport";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE, "author");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> TechReportFactory.createEntity(mockMap, key));
    }

    @Test
    void UnpublishedFactoryTest() throws IncompleteFieldsException {

        String key = "test-unpublished";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(AUTHOR, "author");
        mockMap.put(TITLE, "title");
        mockMap.put(NOTE, "note");
        mockMap.put(YEAR, "year");

        Entry article = (Entry) UnpublishedFactory.createEntity(mockMap, key);

        assertEquals("author", article.records.get(AUTHOR));
        assertEquals("title", article.records.get(TITLE));
        assertEquals("note", article.records.get(NOTE));
        assertEquals("year", article.records.get(YEAR));

    }

    @Test
    void UnpublishedFactoryExceptionTest() {

        String key = "test-unpublished";
        Map<Attributes, String> mockMap = new HashMap<>();
        mockMap.put(TITLE, "author");
        mockMap.put(JOURNAL, "journal");
        mockMap.put(YEAR, "year");

        assertThrows(IncompleteFieldsException.class, () -> UnpublishedFactory.createEntity(mockMap, key));
    }

}
