package com.oop.bibtex.main.factories;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.BibTeXEntity;
import com.oop.bibtex.main.entries.Unpublished;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;

import java.util.Map;

import static com.oop.bibtex.main.Attributes.AUTHOR;
import static com.oop.bibtex.main.Attributes.NOTE;
import static com.oop.bibtex.main.Attributes.TITLE;

public class UnpublishedFactory implements AbstractEntryFactory {

    public static BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(TITLE) != null &&
                records.get(NOTE) != null) {
            return new Unpublished(records, key);
        } else {
            throw new IncompleteFieldsException("Unpublished");
        }
    }
}
