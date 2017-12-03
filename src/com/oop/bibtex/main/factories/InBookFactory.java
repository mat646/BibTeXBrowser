package com.oop.bibtex.main.factories;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.BibTeXEntity;
import com.oop.bibtex.main.entries.InBook;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;

import java.util.Map;

import static com.oop.bibtex.main.Attributes.*;

public class InBookFactory implements AbstractEntryFactory {

    /**
     *
     * @param records is map of attributes and values.
     * @param key associated with concrete entry.
     * @return entry object witch extends BibTeXEntity
     * @see BibTeXEntity
     * @throws IncompleteFieldsException when passed attributes don't satisfy all required fields.
     */
    public static BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if ((records.get(AUTHOR) != null || records.get(EDITOR) != null) && records.get(TITLE) != null &&
                (records.get(CHAPTER) != null || records.get(PAGES) != null) &&
                records.get(PUBLISHER) != null && records.get(YEAR) != null) {
            return new InBook(records, key);
        } else {
            throw new IncompleteFieldsException("InBook");
        }

    }
}
