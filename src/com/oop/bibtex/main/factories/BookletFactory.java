package com.oop.bibtex.main.factories;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.BibTeXEntity;
import com.oop.bibtex.main.entries.Booklet;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;

import java.util.Map;

import static com.oop.bibtex.main.Attributes.TITLE;

public class BookletFactory implements AbstractEntryFactory {

    public static BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(TITLE) != null) {
            return new Booklet(records, key);
        } else {
            throw new IncompleteFieldsException("Booklet");
        }
    }
}
