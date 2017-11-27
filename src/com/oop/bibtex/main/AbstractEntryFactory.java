package com.oop.bibtex.main;

import com.oop.bibtex.main.entries.*;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import java.util.Map;
import static com.oop.bibtex.main.Attributes.*;

interface AbstractEntryFactory {

}

class ArticleFactory implements AbstractEntryFactory {

    static BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(TITLE) != null &&
                records.get(JOURNAL) != null && records.get(YEAR) != null) {
            return new Article(records, key);
        } else {
            throw new IncompleteFieldsException("Article");
        }
    }
}

class BookFactory implements AbstractEntryFactory {

    static BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if ((records.get(AUTHOR) != null || records.get(EDITOR) != null) &&
                records.get(TITLE) != null && records.get(PUBLISHER) != null &&
                records.get(YEAR) != null) {
            return new Book(records, key);
        } else {
            throw new IncompleteFieldsException("Book");
        }
    }
}

class BookletFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(TITLE) != null) {
            return new Booklet(records, key);
        } else {
            throw new IncompleteFieldsException("Booklet");
        }
    }
}

class ConferenceFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(TITLE) != null &&
                records.get(BOOKTITLE) != null && records.get(YEAR) != null) {
            return new Conference(records, key);
        } else {
            throw new IncompleteFieldsException("Conference");
        }

    }
}

class InBookFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if ((records.get(AUTHOR) != null || records.get(EDITOR) != null) && records.get(TITLE) != null &&
                (records.get(CHAPTER) != null || records.get(PAGES) != null) &&
                records.get(PUBLISHER) != null && records.get(YEAR) != null) {
            return new InBook(records, key);
        } else {
            throw new IncompleteFieldsException("InBook");
        }

    }
}

class InCollectionFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(BOOKTITLE) != null &&
                records.get(TITLE) != null && records.get(PUBLISHER) != null &&
                records.get(YEAR) != null) {
            return new InCollection(records, key);
        } else {
            throw new IncompleteFieldsException("InCollection");
        }
    }
}

class InProceedingsFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(TITLE) != null &&
                records.get(BOOKTITLE) != null && records.get(YEAR) != null) {
            return new InProceedings(records, key);
        } else {
            throw new IncompleteFieldsException("InProceedings");
        }
    }
}

class ManualFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(TITLE) != null) {
            return new Manual(records, key);
        } else {
            throw new IncompleteFieldsException("Manual");
        }
    }
}

class MasterThesisFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(TITLE) != null &&
                records.get(SCHOOL) != null && records.get(YEAR) != null) {
            return new MasterThesis(records, key);
        } else {
            throw new IncompleteFieldsException("MasterThesis");
        }
    }
}

class MiscFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records != null) {
            return new Misc(records, key);
        } else {
            throw new IncompleteFieldsException("Misc");
        }
    }
}

class PhdThesisFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(TITLE) != null &&
                records.get(SCHOOL) != null && records.get(YEAR) != null) {
            return new PhdThesis(records, key);
        } else {
            throw new IncompleteFieldsException("PhdThesis");
        }
    }
}

class ProceedingsFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(TITLE) != null && records.get(YEAR) != null) {
            return new Proceedings(records, key);
        } else {
            throw new IncompleteFieldsException("Proceedings");
        }
    }
}

class TechReportFactory implements AbstractEntryFactory {

    static public TechReport createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(TITLE) != null &&
                records.get(INSTITUTION) != null && records.get(YEAR) != null) {
            return new TechReport(records, key);
        } else {
            throw new IncompleteFieldsException("TechReport");
        }
    }
}

class UnpublishedFactory implements AbstractEntryFactory {

    static public BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(TITLE) != null &&
                records.get(NOTE) != null) {
            return new Unpublished(records, key);
        } else {
            throw new IncompleteFieldsException("Unpublished");
        }
    }
}