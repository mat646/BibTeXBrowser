package com.oop.bibtex.main;

import java.util.Map;

/**
 * Entry - single bibliography position in file.
 */
public abstract class Entry implements BibTeXEntity {

    public static Attributes[] requiredFields;
    public static Attributes[] optionalFields;

    final public Map<Attributes, String> records;
    final public String key;

    /**
     *
     * @param records is map of attributes (required and optional)
     * @param key associated with entry.
     */
    public Entry(Map<Attributes, String> records, String key) {
        this.records = records;
        this.key = key;
    }

}
