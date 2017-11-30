package com.oop.bibtex.main;

import com.oop.bibtex.main.visitors.IFileVisitor;

public class StringEntity implements BibTeXEntity {

    private String key;
    private String value;

    public StringEntity(String value, String key) {
        this.value = value;
        this.key = key;
    }

    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
