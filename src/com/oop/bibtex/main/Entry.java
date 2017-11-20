package com.oop.bibtex.main;

import java.util.Map;

public abstract class Entry implements BibTeXEntity {

    final protected Map<Attributes, String> records;

    public Entry(Map<Attributes, String> records) {
        this.records = records;
    }

    public String getKey() {
        return records.get("key");
    }
}
