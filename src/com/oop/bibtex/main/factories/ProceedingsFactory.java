package com.oop.bibtex.main.factories;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.BibTeXEntity;
import com.oop.bibtex.main.entries.Proceedings;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;

import java.util.Map;

import static com.oop.bibtex.main.Attributes.TITLE;
import static com.oop.bibtex.main.Attributes.YEAR;

public class ProceedingsFactory implements AbstractEntryFactory {

    public static BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(TITLE) != null && records.get(YEAR) != null) {
            return new Proceedings(records, key);
        } else {
            throw new IncompleteFieldsException("Proceedings");
        }
    }
}
