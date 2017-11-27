package com.oop.bibtex.main;

import java.util.Map;

public abstract class Entry implements BibTeXEntity {

    public static Attributes[] requiredFields;
    public static Attributes[] optionalFields;

    final public Map<Attributes, String> records;
    final public String key;

    public Entry(Map<Attributes, String> records, String key) {
        this.records = records;
        this.key = key;
    }

}
