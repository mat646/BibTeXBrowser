package com.oop.bibtex.main;

import java.util.Map;

public abstract class Entry implements BibTeXEntity {

    public static Attributes[] requiredFields;
    public static Attributes[] optionalFields;

    final public Map<Attributes, String> records;

    public Entry(Map<Attributes, String> records) {
        this.records = records;
    }

    public String getKey() {
        return null;
    }
}
