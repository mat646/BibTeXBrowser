package com.oop.bibtex.main.factories;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.BibTeXEntity;
import com.oop.bibtex.main.entries.InCollection;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;

import java.util.Map;

import static com.oop.bibtex.main.Attributes.*;
import static com.oop.bibtex.main.Attributes.YEAR;

public class InCollectionFactory implements AbstractEntryFactory {

    public static BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(BOOKTITLE) != null &&
                records.get(TITLE) != null && records.get(PUBLISHER) != null &&
                records.get(YEAR) != null) {
            return new InCollection(records, key);
        } else {
            throw new IncompleteFieldsException("InCollection");
        }
    }
}
