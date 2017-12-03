package com.oop.bibtex.main.factories;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.BibTeXEntity;
import com.oop.bibtex.main.entries.Misc;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;

import java.util.Map;

public class MiscFactory implements AbstractEntryFactory {

    /**
     *
     * @param records is map of attributes and values.
     * @param key associated with concrete entry.
     * @return entry object witch extends BibTeXEntity
     * @see BibTeXEntity
     * @throws IncompleteFieldsException when passed attributes don't satisfy all required fields.
     */
    public static BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records != null) {
            return new Misc(records, key);
        } else {
            throw new IncompleteFieldsException("Misc");
        }
    }
}
